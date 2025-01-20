package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Row;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.RealTimePublicNormalExaminationResponse;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RealTimePublicNormalExaminationDto {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "생년월일 이름")
    private String birthDtName;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "생년월일")
    private String birthDtString;
    @Schema(description = "사용자 '직군'분류 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationclassificationEnum;
    @Schema(description = "'일반검진' 여부 코드")
    private ExaminationCodeEnum normalExaminationCode;
    @Schema(description = "'위암' 여부 코드")
    private ExaminationCodeEnum stomachCancerBoolCode;
    @Schema(description = "'구강검진' 여부 코드")
    private ExaminationCodeEnum oralExamBoolCode;
    @Schema(description = "'유방암' 여부 코드")
    private ExaminationCodeEnum breastCancerBoolCode;
    @Schema(description = "'대장암' 여부 코드")
    private ExaminationCodeEnum colonCancerBoolCode;
    @Schema(description = "'자궁경부암' 여부 코드")
    private ExaminationCodeEnum cervicalCancerBoolCode;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "부서코드")
    private String deptCd;
    @Schema(description = "부서명")
    private String deptNm;
    @Schema(description = "직위")
    private String postNm;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "검진 상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    private LocalDate examinationDt;
    private String multipleFileUuid;
    private String insertUserId;
    private String insertIp;

    public RealTimePublicNormalExaminationDto(Row securityInchargeExcelData) {
        String userJobClassificationclassification = securityInchargeExcelData.getCell(7).toString().trim();

        RealTimePublicNormalExaminationDto data = new RealTimePublicNormalExaminationDto();
        if (userJobClassificationclassification.equals("사무직")) {
            data.setUserJobClassificationclassificationEnum(UserJobClassificationClassificationEnum.OFFICE);
        } else {
            data.setUserJobClassificationclassificationEnum(UserJobClassificationClassificationEnum.NOT_OFFICE);
        }
        this.name = securityInchargeExcelData.getCell(4).toString().trim();
        this.birthDtString = securityInchargeExcelData.getCell(5).toString().trim().substring(0, 6);
        this.birthDtName = securityInchargeExcelData.getCell(5).toString().trim().substring(0, 6) + name;
        this.normalExaminationCode = ExaminationCodeEnum.findByValue(securityInchargeExcelData.getCell(11).toString().trim());
        this.stomachCancerBoolCode = ExaminationCodeEnum.findByValue(securityInchargeExcelData.getCell(13).toString().trim());
        this.oralExamBoolCode = ExaminationCodeEnum.findByValue(securityInchargeExcelData.getCell(12).toString().trim());
        this.breastCancerBoolCode = ExaminationCodeEnum.findByValue(securityInchargeExcelData.getCell(14).toString().trim());
        this.colonCancerBoolCode = ExaminationCodeEnum.findByValue(securityInchargeExcelData.getCell(15).toString().trim());
        this.cervicalCancerBoolCode = ExaminationCodeEnum.findByValue(securityInchargeExcelData.getCell(16).toString().trim());
    }

    public RealTimePublicNormalExaminationResponse convertRealTimePublicNormalExaminationResponse() {
        RealTimePublicNormalExaminationResponse data = new RealTimePublicNormalExaminationResponse();
        data.setBirthDtName(this.birthDtName);
        data.setName(this.name);
        data.setBirthDtString(this.birthDtString);
        data.setUserJobClassificationclassificationEnum(this.userJobClassificationclassificationEnum);
        data.setStomachCancerBoolCode(String.valueOf(this.stomachCancerBoolCode));
        data.setOralExamBoolCode(String.valueOf(this.oralExamBoolCode));
        data.setBreastCancerBoolCode(String.valueOf(this.breastCancerBoolCode));
        data.setColonCancerBoolCode(String.valueOf(this.colonCancerBoolCode));
        data.setCervicalCancerBoolCode(String.valueOf(this.cervicalCancerBoolCode));
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setInsertDtm(this.insertDtm);
        return data;
    }

    public void injectionData(HrEmpDto empDto) {
        String date = "uuuuMMdd";
        this.userId = empDto.getEmpNo() + DateTimeFormatter.ofPattern(date)
            .format(empDto.getBirthYmd());
        this.deptCd = empDto.getDeptCd();
        this.deptNm = empDto.getDeptNm();
        this.postNm = empDto.getPostNm();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        this.standardYyyy = now.format(formatter);
    }

}
