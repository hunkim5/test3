package com.airpremia.eosh.common.dto;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementSearchDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestSearchDto;
import com.airpremia.eosh.certification.dto.UserProtectGearDeptRequestDto;
import com.airpremia.eosh.common.controller.HrEmpResponse;
import com.airpremia.eosh.personaldetail.basicinfo.dto.BasicInfoDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailFirstDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserSpecialExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveySearchDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectGearDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectiondeviceDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HrEmpTransDto {
    private String empNo;
    private String empNm;
    private String email;
    private String userId;
    private String handphone;
    private String postNm;
    private String deptCd;
    private String deptNm;
    private String deptFnCd;
    private String deptFnNm;
    private LocalDate birthYmd;
    private String birthDate;
    private LocalDate hireYmd;
    private String responseKey;
    private LocalDate hireYmdFrom;
    private LocalDate hireYmdTo;
    private List<String> empNoList;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;


    public HrEmpResponse convertHrEmpResponse() {
        HrEmpResponse data = new HrEmpResponse();
        data.setEmpNo(this.empNo);
        data.setEmpNm(this.empNm);
        data.setEmail(this.email);
        data.setUserId(this.userId);
        data.setHandphone(this.handphone);
        data.setPostNm(this.postNm);
        data.setDeptCd(this.deptCd);
        data.setDeptNm(this.deptNm);
        data.setDeptFnCd(this.deptFnCd);
        data.setDeptFnNm(this.deptFnNm);
        data.setBirthYmd(this.birthYmd);
        data.setHireYmd(this.hireYmd);
        return data;
    }

    public void setSearchValue(AuthorityManagementSearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.email = searchDto.getEmail();
        this.postNm = searchDto.getPostNm();
        this.birthYmd = searchDto.getBirthYmd();
        this.handphone = searchDto.getHandphone();
        this.hireYmd = searchDto.getHireYmd();
    }

    public void setSearchValue(HealthCheckDetailFirstDto searchDto) {
        this.empNm = searchDto.getEmpNm();
    }

    public void setSearchValue(AuthorityRequestSearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.empNoList = searchDto.getEmpNoList();
    }

    public void setSearchValue(BasicInfoDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.postNm = searchDto.getPostNm();
        this.hireYmdFrom = searchDto.getHireYmdFrom();
        this.hireYmdTo = searchDto.getHireYmdTo();
        this.birthYmd = searchDto.getBirthYmd();
        this.birthDate = searchDto.getBirthYmd() != null ? searchDto.getBirthYmd().toString().replace("-", "") : null;
    }

    public void setSearchValue(HealthSearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
    }

    public void setSearchValue(UserProtectiondeviceDto searchDto) {
        this.deptFnCd = searchDto.getStorageDepartmentCode();
    }

    public void setSearchValue(UserProtectGearDto searchDto) {
        this.deptFnCd = searchDto.getStorageDepartmentCode();
    }

    public void setSearchValue(UserProtectGearDeptRequestDto requestDto) {
        this.deptFnCd = requestDto.getStorageDepartmentCode();
    }

    public void setSearchValue(UserNormalExaminationSearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.birthYmd = searchDto.getBirthYmd();
        this.userJobClassificationClassificationEnum =
            searchDto.getUserJobClassificationClassificationEnum();
    }

    public void setSearchValue(UserSpecialExaminationDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.birthYmd = searchDto.getBirthYmd();
        this.userJobClassificationClassificationEnum =
            searchDto.getUserJobClassificationClassificationEnum();
    }

    public void setSearchValue(UserCerebrocardiovascularExaminationSearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.birthYmd = searchDto.getBirthYmd();
        this.userJobClassificationClassificationEnum =
            searchDto.getUserJobClassificationClassificationEnum();
    }

    public void setSearchValue(UserCosmicRadiationExaminationSearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
        this.birthYmd = searchDto.getBirthYmd();
        this.userJobClassificationClassificationEnum =
            searchDto.getUserJobClassificationClassificationEnum();
    }

    public void setSearchValue(UserWorkStressSurveySearchDto searchDto) {
        this.empNm = searchDto.getEmpNm();
        this.deptNm = searchDto.getDeptNm();
    }
}

