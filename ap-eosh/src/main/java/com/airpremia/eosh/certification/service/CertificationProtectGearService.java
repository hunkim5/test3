package com.airpremia.eosh.certification.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.certification.controller.CertificationSafeguardingRequest;
import com.airpremia.eosh.certification.controller.CertificationSafeguardingResponse;
import com.airpremia.eosh.certification.controller.CertificationSafeguardingSearchRequest;
import com.airpremia.eosh.certification.controller.ProtectGearDeptResponse;
import com.airpremia.eosh.certification.controller.ProtectGearDeptUpdateRequest;
import com.airpremia.eosh.certification.controller.UserProtectGearDeptRequest;
import com.airpremia.eosh.certification.controller.UserProtectGearDeptResponse;
import com.airpremia.eosh.certification.controller.UserProtectGearDeptUpdateRequest;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingSearchDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingUpdateDto;
import com.airpremia.eosh.certification.dto.ProtectGearDepartmentQuantityDto;
import com.airpremia.eosh.certification.dto.UserProtectGearDeptDto;
import com.airpremia.eosh.certification.dto.UserProtectGearDeptRequestDto;
import com.airpremia.eosh.certification.repository.CertificationProtectGearRepository;
import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificationProtectGearService {

    private final CertificationProtectGearRepository certificationProtectGearRepository;
    private final CommonFunction commonFunction;


    public Page<CertificationSafeguardingResponse> selectCertificationProtectGearPage(
        CertificationSafeguardingSearchRequest searchRequest, Pageable pageable) {

        CertificationSafeguardingSearchDto searchDto = new CertificationSafeguardingSearchDto(searchRequest);

        Page<CertificationSafeguardingDto> pageList = certificationProtectGearRepository.selectCertificationProtectGearPage(searchDto, pageable);

        return pageList.map(CertificationSafeguardingResponse::new);
    }

    public CertificationSafeguardingResponse selectCertificationProtectGear(Long safeguardingSeq) {
        CertificationSafeguardingDto dto = certificationProtectGearRepository.selectCertificationProtectGear(safeguardingSeq);
        if (dto == null) {
            dto = new CertificationSafeguardingDto();
        }
        return new CertificationSafeguardingResponse(dto);
    }

    @Transactional
    public int updateCertificationProtectGear(CertificationSafeguardingRequest request, Long safeguardingSeq) {
        CertificationSafeguardingUpdateDto dto = new CertificationSafeguardingUpdateDto(request);
        dto.setSafeguardingSeq(safeguardingSeq);
        return certificationProtectGearRepository.updateCertificationProtectGear(dto);
    }

    public List<ProtectGearDeptResponse> selectProtectGearDepartmentQuantity(String deptCd) {

        List<ProtectGearDepartmentQuantityDto> quantityList = certificationProtectGearRepository.selectProtectGearDepartmentQuantity(deptCd);

        return quantityList.stream().map(ProtectGearDeptResponse::new).toList();
    }

    public int updateProtectGearDepartmentQuantity(List<ProtectGearDeptUpdateRequest> request) {
        List<ProtectGearDepartmentQuantityDto> updateDto = request.stream().map(ProtectGearDepartmentQuantityDto::new).toList();

        int result = 0;
        for (ProtectGearDepartmentQuantityDto dto : updateDto) {
            if (dto.getDeptProtectGearStatusSeq() != null) {
                result += certificationProtectGearRepository.updateProtectGearDepartmentQuantity(dto);
            }
        }

        return result;
    }

    public List<UserProtectGearDeptResponse> selectUserProtectGearDeptStatus(UserProtectGearDeptRequest request) {
        UserProtectGearDeptRequestDto requestDto = new UserProtectGearDeptRequestDto(request);

        if (requestDto.getStorageDepartmentCode() == null) {
            return List.of();
        }

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(requestDto);
        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);
        List<UserProtectGearDeptDto> protectlist =
            certificationProtectGearRepository.selectUserProtectGearDeptStatus(requestDto);

        return orgHrList.stream()
            .map(dto -> {
                UserProtectGearDeptResponse response = new UserProtectGearDeptResponse();
                response.setHrEmpInfo(dto);

                protectlist.stream()
                    .filter(userProtectGearDeptDto -> userProtectGearDeptDto.getUserId().equals(dto.getUserId()))
                    .findFirst()
                    .ifPresent(response::setUserUserProtectGearInfo);

                return response;
            })
            .toList();
    }

    @Transactional
    public int updateUserProtectGearDeptStatus(List<UserProtectGearDeptUpdateRequest> request) {
        List<UserProtectGearDeptDto> updateDto = request.stream().map(UserProtectGearDeptDto::new).toList();

        int result = 0;
        for (UserProtectGearDeptDto dto : updateDto) {
            if (dto.getUserProtectGearStatusSeq() == null) {
                if (dto.checkUpdateData()) {
                    result += certificationProtectGearRepository.insertUserProtectGearDeptStatus(dto);
                }
            } else {
                result += certificationProtectGearRepository.updateUserProtectGearDeptStatus(dto);
            }
        }

        return result;
    }
}
