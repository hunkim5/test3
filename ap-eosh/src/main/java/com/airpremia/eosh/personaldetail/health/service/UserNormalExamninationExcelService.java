package com.airpremia.eosh.personaldetail.health.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.RealTimePublicNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UpdateUserSexDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;
import com.airpremia.eosh.personaldetail.health.repository.HealthRepository;
import com.airpremia.eosh.personaldetail.health.repository.RealTimePublicNormalExaminationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNormalExamninationExcelService {
    private final HealthRepository healthRepository;
    private final RealTimePublicNormalExaminationRepository realTimePublicNormalExaminationRepository;
    private final CommonFunction commonFunction;
    private static final String DATE = "uuuuMMdd";

    @Transactional
    public Boolean uploadUserNormalExamninationExcelList(MultipartFile[] fileList) {
        for (MultipartFile file : fileList) {
            try {
                Workbook workbook = new XSSFWorkbook(file.getInputStream());
                for (int i = 0; i <= workbook.getNumberOfSheets() - 1; i++) {
                    Sheet sheet = workbook.getSheetAt(i);
                    insertExcel(sheet);
                }
            } catch (IOException e) {
                throw new ExpectedException(ExceptionCode.WORKBOOK_IOEXCEPTION_ERROR);
            }

        }
        return true;
    }

    private int insertExcel(Sheet sheet) {
        int index = 1;
        int result = 0;
        while (true) {
            Row securityInchargeExcelData = sheet.getRow(index);
            if (securityInchargeExcelData == null) {
                break;
            }
            String regNumber = securityInchargeExcelData.getCell(5).toString().trim();
            RealTimePublicNormalExaminationDto data = new RealTimePublicNormalExaminationDto(securityInchargeExcelData);

            String sex = "";
            if ("1".equals(regNumber.substring(7, 8))) {
                sex = "MALE";
            } else if ("2".equals(regNumber.substring(7, 8))) {
                sex = "FEMALE";
            }

            String userJobClassificationclassification = securityInchargeExcelData.getCell(7).toString().trim();
            data.setUserJobClassificationclassificationEnum(
                UserJobClassificationClassificationEnum.findByValue(userJobClassificationclassification)
            );

            data.setExaminationStatusEnum(ExaminationStatusEnum.DRAFT);

            if (index == 1) {
                result += realTimePublicNormalExaminationRepository.deleteRealTimePublicNormalExamination();
            }
            result += realTimePublicNormalExaminationRepository.insertRealTimePublicNormalExamination(data);

            HrEmpTransDto hrEmpDto = new HrEmpTransDto();
            hrEmpDto.setEmpNm(securityInchargeExcelData.getCell(4).toString().trim());

            List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

            for (HrEmpDto empDto : orgHrList) {
                if (String.valueOf(empDto.getBirthYmd()).replace("-", "").contains(regNumber.substring(0, 6))) {
                    String userId = empDto.getEmpNo().substring(1, 7) + DateTimeFormatter.ofPattern(DATE)
                        .format(empDto.getBirthYmd());
                    LocalDate now = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
                    String yyyy = now.format(formatter);
                    UserNormalExaminationDto checkDto = new UserNormalExaminationDto(userId, yyyy);
                    checkDto.setDeptCd(empDto.getDeptCd());
                    checkDto.setDeptNm(empDto.getDeptNm());
                    checkDto.setPostNm(empDto.getPostNm());
                    checkDto.setExaminationStatusEnum(data.getExaminationStatusEnum());

                    Long userSeq = healthRepository.selectUserSeq(checkDto.getUserId());

                    data.setUserSeq(userSeq);
                    checkDto.setUserSeq(userSeq);
                    checkDto.setExaminationCodes(data);

                    List<String> checkList = healthRepository.selectUserNormalExaminationCheck(checkDto);
                    data.injectionData(empDto);
                    if (checkList != null && checkList.size() == 1) {
                        result += healthRepository.updateRealTimeUserNormalExamination(data);
                    }
                    UpdateUserSexDto updateUserSexDto = new UpdateUserSexDto(userSeq, sex);

                    result += healthRepository.updateUserSex(updateUserSexDto);

                    healthRepository.insertUserNormalExamination(checkDto);
                }
            }
            index++;
        }
        return result;
    }
}
