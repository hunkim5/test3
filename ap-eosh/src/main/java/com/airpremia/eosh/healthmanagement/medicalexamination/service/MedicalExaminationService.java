package com.airpremia.eosh.healthmanagement.medicalexamination.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationSearchRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationResponse;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserSpecialExaminationDto;
import com.airpremia.eosh.personaldetail.health.repository.HealthRepository;
import com.airpremia.eosh.personaldetail.health.repository.UserCerebrocardiovascularExaminationRepository;
import com.airpremia.eosh.personaldetail.health.repository.UserCosmicRadiationExaminationRepository;
import com.airpremia.eosh.personaldetail.health.repository.UserSpecialExaminationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalExaminationService {
    private final HealthRepository healthRepository;
    private final UserCerebrocardiovascularExaminationRepository userCerebrocardiovascularExaminationRepository;
    private final UserCosmicRadiationExaminationRepository userCosmicRadiationExaminationRepository;
    private final UserSpecialExaminationRepository userSpecialExaminationRepository;
    private final CommonFunction commonFunction;

    private <T extends UserExaminationPageDto> List<T> processExaminationList(
        List<T> list,
        UserExaminationSearchDto searchDto,
        List<HrEmpDto> orgHrList,
        Pageable pageable
    ) {
        list.forEach(data -> {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        });

        List<T> matchList = list.stream()
            .filter(o -> orgHrList.stream().anyMatch(n -> o.getEmpNo().equals(n.getEmpNo())))
            .toList();

        for (T dto : matchList) {
            for (HrEmpDto empDto : orgHrList) {
                empDto.setUserJobClassificationClassificationEnum(dto.getUserJobClassificationClassificationEnum());
                if (dto.getEmpNo().equals(empDto.getEmpNo())) {
                    dto.mergeInfo(dto, empDto);
                }
            }
        }

        if (searchDto.getBirthYmd() != null) {
            matchList = matchList.stream()
                .filter(dto -> dto.getBirthYmd().equals(searchDto.getBirthYmd()))
                .toList();
        }

        return commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());
    }

    public Page<UserNormalExaminationResponse> selectUserNormalExaminationPage(
        UserNormalExaminationSearchRequest request, Pageable pageable) {
        UserNormalExaminationSearchDto searchDto = new UserNormalExaminationSearchDto(request);

        List<UserNormalExaminationPageDto> list = healthRepository.selectUserNormalExaminationPage(searchDto);

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        List<UserNormalExaminationPageDto> matchList = processExaminationList(
            list,
            searchDto,
            orgHrList,
            pageable
        );

        return new PageImpl<>(
            matchList.stream().map(UserNormalExaminationResponse::new).toList(),
            pageable,
            matchList.size()
        );
    }

    public Page<UserSpecialExaminationResponse> selectUserSpecialExaminationPage(
        UserSpecialExaminationRequest request, Pageable pageable) {
        UserSpecialExaminationDto searchDto = new UserSpecialExaminationDto(request);

        List<UserSpecialExaminationDto> list =
            userSpecialExaminationRepository.selectUserSpecialExaminationPage(searchDto);

        for (UserSpecialExaminationDto data : list) {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        }

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);
        List<UserSpecialExaminationDto> matchList =
            list.stream().filter(o -> orgHrList.stream().anyMatch(n -> o.getEmpNo().equals(n.getEmpNo())))
                .toList();

        for (UserSpecialExaminationDto dto : matchList) {
            for (HrEmpDto empDto : orgHrList) {
                empDto.setUserJobClassificationClassificationEnum(dto.getUserJobClassificationClassificationEnum());
                if (dto.getEmpNo().equals(empDto.getEmpNo())) {
                    dto.mergeInfo(dto, empDto);
                }
            }
        }

        int total = matchList.size();

        if (searchDto.getBirthYmd() != null) {
            matchList = matchList.stream().filter(dto -> dto.getBirthYmd().equals(searchDto.getBirthYmd())).toList();
        }

        matchList = commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(matchList.stream().map(UserSpecialExaminationResponse::new).toList(), pageable, total);
    }

    public Page<UserCosmicRadiationExaminationResponse> selectUserCosmicRadiationExaminationPage(
        UserCosmicRadiationExaminationRequest request, Pageable pageable) {
        UserCosmicRadiationExaminationSearchDto searchDto =
            new UserCosmicRadiationExaminationSearchDto(request);

        List<UserCosmicRadiationExaminationPageDto> list =
            userCosmicRadiationExaminationRepository.selectUserCosmicRadiationExaminationPage(searchDto);

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        List<UserCosmicRadiationExaminationPageDto> matchList = processExaminationList(
            list,
            searchDto,
            orgHrList,
            pageable
        );

        return new PageImpl<>(
            matchList.stream().map(UserCosmicRadiationExaminationResponse::new).toList(),
            pageable,
            matchList.size()
        );
    }

    public Page<UserCerebrocardiovascularExaminationResponse> selectUserCerebrocardiovascularExaminationPage(
        UserCerebrocardiovascularExaminationRequest request, Pageable pageable) {
        UserCerebrocardiovascularExaminationSearchDto searchDto =
            new UserCerebrocardiovascularExaminationSearchDto(request);

        List<UserCerebrocardiovascularExaminationPageDto> list =
            userCerebrocardiovascularExaminationRepository.selectUserCerebrocardiovascularExaminationPage(searchDto);

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        List<UserCerebrocardiovascularExaminationPageDto> matchList = processExaminationList(
            list,
            searchDto,
            orgHrList,
            pageable
        );

        return new PageImpl<>(
            matchList.stream().map(UserCerebrocardiovascularExaminationResponse::new).toList(),
            pageable,
            matchList.size()
        );
    }
}
