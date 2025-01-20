package com.airpremia.eosh.report.workreport;

import java.util.function.BiConsumer;

import org.springframework.stereotype.Component;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WorkReportCommon {

    private final UserTokenService userTokenService;
    private final CommonFunction commonFunction;
    private static final String MAINTENANCE_DEPARTMENT_CODE = "00035";  // 정비팀 부서 코드

    public <T> T getStorageDepartmentCode(T dto, BiConsumer<T, String> setStorageDepartmentCodeFunction) {
        String userEmpNo = userTokenService.getUserToken().getEmpNo();
        HrEmpDto hrEmpDto = commonFunction.getHrEmpNoDto(userEmpNo);
        String[] deptFnCd = hrEmpDto.getDeptFnCd().split(">");
        String storageDepartmentCode = hrEmpDto.getDeptFnCd().contains(MAINTENANCE_DEPARTMENT_CODE) ? deptFnCd[2] : deptFnCd[1];

        setStorageDepartmentCodeFunction.accept(dto, storageDepartmentCode);

        return dto;
    }
}
