package com.airpremia.eosh.personaldetail.basicinfo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoResponse;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoSearchRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoSearchResponse;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoUpdateRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemResponse;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogResponse;
import com.airpremia.eosh.personaldetail.basicinfo.dto.BasicInfoDto;
import com.airpremia.eosh.personaldetail.basicinfo.dto.BasicInfoUpdateDto;
import com.airpremia.eosh.personaldetail.basicinfo.dto.UserQualificationItemDto;
import com.airpremia.eosh.personaldetail.basicinfo.dto.UserSafetyOfficeLogDto;
import com.airpremia.eosh.personaldetail.basicinfo.repository.BasicInfoRepository;
import com.airpremia.eosh.personaldetail.basicinfo.repository.UserQualificationItemRepository;
import com.airpremia.eosh.personaldetail.basicinfo.repository.UserSafetyOfficeLogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicInfoService {

    private final BasicInfoRepository basicInfoRepository;
    private final UserSafetyOfficeLogRepository userSafetyOfficeLogRepository;
    private final UserQualificationItemRepository userQualificationItemRepository;
    private final CommonFunction commonFunction;

    public BasicInfoResponse selectBasicInfo(long userSeq) {

        BasicInfoDto dto = basicInfoRepository.selectBasicInfo(userSeq);

        String empNo = "P" + dto.getUserId().substring(0, 6);

        HrEmpDto hrData = commonFunction.getHrEmpNoDto(empNo);

        dto.setEmpNm(hrData.getEmpNm());
        dto.setEmpNo(hrData.getEmpNo());
        dto.setDeptNm(hrData.getDeptNm());
        dto.setEmail(hrData.getEmail());
        dto.setHandphone(hrData.getHandphone());
        dto.setBirthYmd(hrData.getBirthYmd());
        dto.setPostNm(hrData.getPostNm());

        List<UserSafetyOfficeLogDto> userSafetyOfficeLogDto =
            userSafetyOfficeLogRepository.selectUserSafetyOfficeLog(userSeq);

        List<UserQualificationItemDto> userQualificationItemDto =
            userQualificationItemRepository.selectUserQualificationItem(userSeq);

        BasicInfoResponse res = new BasicInfoResponse();
        res.setBasicInfoDto(dto);
        res.setUserSafetyOfficeLogResponse(
            userSafetyOfficeLogDto.stream().map(UserSafetyOfficeLogResponse::new).toList());

        res.setUserQualificationItemResponse(
            userQualificationItemDto.stream().map(UserQualificationItemResponse::new).toList());

        return res;
    }

    public BasicInfoResponse selectBasicInfoUser() {
        return selectBasicInfo(commonFunction.getUserSeq());
    }

    @Transactional
    public BasicInfoResponse updateBasicinfo(BasicInfoUpdateRequest req) {

        BasicInfoUpdateDto basicInfo = new BasicInfoUpdateDto(req);
        basicInfoRepository.updateBasicInfo(basicInfo);

        saveUserSafetyOfficeLog(req.getUserSafetyOfficeLogRequest(), req.getUserSeq());

        saveUserQualificationItem(req.getUserQualificationItemRequest(), req.getUserSeq());

        return selectBasicInfo(req.getUserSeq());
    }

    public void saveUserSafetyOfficeLog(List<UserSafetyOfficeLogRequest> reqList, long userSeq) {

        List<UserSafetyOfficeLogDto> saveList = reqList.stream().map(UserSafetyOfficeLogDto::new).toList();

        List<UserSafetyOfficeLogDto> safetyOfficeList =
            userSafetyOfficeLogRepository.selectUserSafetyOfficeLog(userSeq);
        List<UserSafetyOfficeLogDto> deleteList = safetyOfficeList.stream()
            .filter(safety -> saveList.stream()
                .noneMatch(saveItem -> safety.getUserSafetyOfficeLogSeq().equals(saveItem.getUserSafetyOfficeLogSeq())))
            .toList();
        for (UserSafetyOfficeLogDto deleteDto : deleteList) {
            userSafetyOfficeLogRepository.deleteUserSafetyOfficeLog(deleteDto);
        }

        for (UserSafetyOfficeLogDto dto : saveList) {
            if (dto.getUserSafetyOfficeLogSeq() == null) {
                userSafetyOfficeLogRepository.insertUserSafetyOfficeLog(dto);
            } else {
                userSafetyOfficeLogRepository.updateUserSafetyOfficeLog(dto);
            }
        }
    }

    public void saveUserQualificationItem(List<UserQualificationItemRequest> reqList, long userSeq) {

        List<UserQualificationItemDto> saveList = reqList.stream().map(UserQualificationItemDto::new).toList();

        List<UserQualificationItemDto> qualificationList =
            userQualificationItemRepository.selectUserQualificationItem(userSeq);

        List<UserQualificationItemDto> deleteList = qualificationList.stream()
            .filter(qualification -> saveList.stream()
                .noneMatch(saveItem -> qualification.getUserQualificationItemSeq()
                    .equals(saveItem.getUserQualificationItemSeq())))
            .toList();

        for (UserQualificationItemDto deleteDto : deleteList) {
            userQualificationItemRepository.deleteUserQualificationItem(deleteDto);
        }

        for (UserQualificationItemDto dto : saveList) {
            if (dto.getUserQualificationItemSeq() == null) {
                userQualificationItemRepository.insertUserQualificationItem(dto);
            } else {
                userQualificationItemRepository.updateUserQualificationItem(dto);
            }
        }
    }

    public void deleteUserSafetyOfficeLog(List<UserSafetyOfficeLogRequest> reqList) {
        for (UserSafetyOfficeLogRequest req : reqList) {
            UserSafetyOfficeLogDto dto = new UserSafetyOfficeLogDto(req);
            userSafetyOfficeLogRepository.deleteUserSafetyOfficeLog(dto);
        }
    }

    public int deleteUserQualificationItem(List<UserQualificationItemRequest> reqList) {
        int result = 0;
        for (UserQualificationItemRequest req : reqList) {
            UserQualificationItemDto dto = new UserQualificationItemDto(req);
            result += userQualificationItemRepository.deleteUserQualificationItem(dto);
        }
        return result;
    }

    public Page<BasicInfoSearchResponse> selectBasicInfoSearch(BasicInfoSearchRequest req, Pageable pageable) {
        BasicInfoDto dto = new BasicInfoDto(req);

        List<BasicInfoDto> pageList = basicInfoRepository.selectBasicInfoSearch(dto);
        for (BasicInfoDto data : pageList) {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        }

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(dto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        Map<String, HrEmpDto> empMap = orgHrList.stream()
            .collect(Collectors.toMap(HrEmpDto::getEmpNo, empDto -> empDto));

        List<BasicInfoDto> matchList = pageList.stream()
            .filter(data -> empMap.containsKey(data.getEmpNo()))
            .peek(data -> {
                HrEmpDto empDto = empMap.get(data.getEmpNo());
                data.setEmpNm(empDto.getEmpNm());
                data.setDeptNm(empDto.getDeptNm());
                data.setEmail(empDto.getEmail());
                data.setPostNm(empDto.getPostNm());
                data.setBirthYmd(empDto.getBirthYmd());
                data.setHandphone(empDto.getHandphone());
                data.setHireYmd(empDto.getHireYmd());
            }).toList();

        int total = matchList.size();
        matchList = commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(matchList.stream().map(BasicInfoSearchResponse::new).toList(), pageable, total);
    }

    public List<UserQualificationItemResponse> selectUserQualificationItemByUserId(String userSeq) {

        return userQualificationItemRepository.selectUserQualificationItemByUserId(userSeq).stream()
            .map(UserQualificationItemResponse::new).toList();
    }
}
