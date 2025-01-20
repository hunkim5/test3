package com.airpremia.eosh.certification.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.certification.dto.CertificationSafeguardingDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingSearchDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingUpdateDto;
import com.airpremia.eosh.certification.dto.ProtectGearDepartmentQuantityDto;
import com.airpremia.eosh.certification.dto.UserProtectGearDeptDto;
import com.airpremia.eosh.certification.dto.UserProtectGearDeptRequestDto;


@Repository
public interface CertificationProtectGearRepository {

    Page<CertificationSafeguardingDto> selectCertificationProtectGearPage(CertificationSafeguardingSearchDto searchDto, Pageable pageable);

    CertificationSafeguardingDto selectCertificationProtectGear(Long safeguardingSeq);

    int updateCertificationProtectGear(CertificationSafeguardingUpdateDto dto);

    List<ProtectGearDepartmentQuantityDto> selectProtectGearDepartmentQuantity(String deptCd);

    int updateProtectGearDepartmentQuantity(ProtectGearDepartmentQuantityDto dto);

    List<UserProtectGearDeptDto> selectUserProtectGearDeptStatus(UserProtectGearDeptRequestDto requestDto);

    int insertUserProtectGearDeptStatus(UserProtectGearDeptDto dto);

    int updateUserProtectGearDeptStatus(UserProtectGearDeptDto dto);
}
