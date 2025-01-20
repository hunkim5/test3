package com.airpremia.eosh.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import com.airpremia.eosh.common.controller.HrEmpResponse;
import com.airpremia.eosh.common.controller.HrWrapperResponse;
import com.airpremia.eosh.common.dto.HrDeptTreeDto;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.common.dto.HrWrapperDto;
import com.airpremia.eosh.common.dto.HrWrapperListDto;
import com.airpremia.eosh.common.repository.CommonFunctionRepository;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class CommonFunction {

    private final RestClient restClient;
    private final RestClient hrClient;

    private final CommonFunctionRepository commonFunctionRepository;
    private final UserTokenService userTokenService;

    @Value("${hr.api.hr-emp-path}")
    private String hrEmpPath;


    public HrWrapperListDto<HrEmpDto> getHrEmps(HrEmpTransDto hrEmpDto) {
        HrWrapperListDto<HrEmpDto> result;

        result = restClient
            .get()
            .uri(uriBuilder ->
                setUriBuilder(uriBuilder, hrEmpDto).build()
            )
            .retrieve().body(new ParameterizedTypeReference<>() {
            });

        return result;
    }

    private UriBuilder setUriBuilder(UriBuilder uriBuilder, HrEmpTransDto hrEmpDto) {
        uriBuilder
            .path(hrEmpPath + "/list")
            .queryParam("empNm", hrEmpDto.getEmpNm())
            .queryParam("deptNm", hrEmpDto.getDeptNm())
            .queryParam("deptCd", hrEmpDto.getDeptCd())
            .queryParam("postName", hrEmpDto.getPostNm())
            .queryParam("hireYmdFrom", hrEmpDto.getHireYmdFrom())
            .queryParam("hireYmdTo", hrEmpDto.getHireYmdTo())
            .queryParam("birthDate", hrEmpDto.getBirthDate())
            .queryParam("deptFnCd", hrEmpDto.getDeptFnCd());
        if (hrEmpDto.getEmpNoList() != null) {
            uriBuilder.queryParam("empNoList", hrEmpDto.getEmpNoList());
        }
        return uriBuilder;
    }

    public List<HrEmpDto> getHrEmpsLiveList(HrEmpTransDto hrEmpDto) {
        HrWrapperListDto<HrEmpDto> empWrapper = getHrEmps(hrEmpDto);
        if (empWrapper == null) {
            empWrapper = new HrWrapperListDto<>();
        }
        ArrayList<HrEmpDto> hrList = (ArrayList<HrEmpDto>) empWrapper.getData();
        return hrList.stream().filter(h -> h.getEmpNo().startsWith("P")).map(HrEmpDto::getHrEmpDtoWithUserId).toList();
    }

    public HrWrapperDto<HrEmpDto> getHrEmp(String empNo) {
        return restClient
            .get()
            .uri(uriBuilder ->
                uriBuilder
                    .path(hrEmpPath + "/" + empNo)
                    .build())
            .retrieve().body(new ParameterizedTypeReference<>() {
            });
    }

    public HrEmpDto getHrEmpDto(String userId) {
        String empNo = "P" + userId.substring(0, 6);
        HrWrapperDto<HrEmpDto> empWrapper = getHrEmp(empNo);
        HrEmpDto dto = new HrEmpDto();
        if (empWrapper != null) {
            dto = empWrapper.getData();
        }
        return dto;
    }

    public HrEmpDto getHrEmpNoDto(String empNo) {
        HrWrapperDto<HrEmpDto> empWrapper = getHrEmp(empNo);
        HrEmpDto dto = new HrEmpDto();
        if (empWrapper != null) {
            dto = empWrapper.getData();
        }
        return dto.getHrEmpDtoWithUserId();
    }

    public HrEmpResponse getHrEmpResponse(String userId) {
        String empNo = "P" + userId.substring(0, 6);
        HrWrapperDto<HrEmpDto> empWrapper = getHrEmp(empNo);
        return new HrEmpResponse(empWrapper.getData());
    }

    public <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {

        int fromIndex = ((page + 1) - 1) * pageSize;
        if (sourceList == null || sourceList.size() <= fromIndex) {
            return Collections.emptyList();
        }

        // toIndex exclusive
        return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
    }

    public long getUserSeq() {
        UserTokenDto userToken = userTokenService.getUserToken();
        String userTokenEmpNo = userToken.getEmpNo();
        String userTokenBirthYmd = String.valueOf(userToken.getBirthYmd());
        String userId = userTokenEmpNo.substring(1, 7) + userTokenBirthYmd.replace("-", "");

        return commonFunctionRepository.selectUserSeq(userId);
    }

    public HrWrapperResponse<List<HrDeptTreeDto>> selectHrDeptTree(String deptCd, boolean isDissolved) {
        return hrClient
            .get()
            .uri(uriBuilder -> {
                uriBuilder
                    .path(hrEmpPath).queryParam("cd", deptCd).queryParam("dissolved", isDissolved);
                return uriBuilder.build();
            })
            .header("Authorization", userTokenService.getBearerAccessToken())
            .retrieve()
            .body(new ParameterizedTypeReference<HrWrapperResponse<List<HrDeptTreeDto>>>() {
            });
    }

}
