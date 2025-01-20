package com.airpremia.eosh.authoritymanagement.authoritymanagement.service;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.controller.AuthorityManagementDetailResponse;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.controller.AuthorityManagementResponse;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.controller.AuthorityManagementSearchRequest;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.controller.AuthorityManagementUpdateRequest;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementDetailDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementInsertDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementSearchDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementUpdateDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.entities.AuthorityManagementEntity;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.repository.AuthorityManagementRepository;
import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorityManagementService {
    private final AuthorityManagementRepository authorityManagementRepository;
    private final CommonFunction commonFunction;

    @Transactional
    public int insertHr() {
        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(new HrEmpTransDto());

        List<AuthorityManagementEntity> hrData = authorityManagementRepository.selectAuthorityManagementHrData();
        for (AuthorityManagementEntity data : hrData) {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        }
        //동기화 작업
        List<HrEmpDto> unmatchList =
            orgHrList.stream().filter(o -> hrData.stream().noneMatch(n -> o.getEmpNo().equals(n.getEmpNo()))).toList();

        int result = 0;
        List<AuthorityManagementInsertDto> insertDtos =
            unmatchList.stream().map(AuthorityManagementInsertDto::new).toList();
        for (AuthorityManagementInsertDto insertDto : insertDtos) {
            result += authorityManagementRepository.insertAuthorityManagementHr(insertDto);
        }

        return result;
    }

    @Transactional
    public int updateAuthorityManagement(
        List<AuthorityManagementUpdateRequest> updateRequestList) {
        List<AuthorityManagementUpdateDto> updateDtoList =
            updateRequestList.stream().map(AuthorityManagementUpdateDto::new).toList();

        int result = 0;
        for (AuthorityManagementUpdateDto updateDto : updateDtoList) {
            result += authorityManagementRepository.updateAuthorityManagement(updateDto);
        }
        return result;
    }

    public PageImpl<AuthorityManagementResponse> selectAuthorityManagementPage(
        AuthorityManagementSearchRequest searchRequest, Pageable pageable) {
        AuthorityManagementSearchDto searchDto = searchRequest.convertAuthorityManagementSearchDto();
        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        List<AuthorityManagementDto> pageList =
            authorityManagementRepository.selectAuthorityManagementList(searchDto);
        for (AuthorityManagementDto data : pageList) {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        }

        List<AuthorityManagementDto> matchList = pageList.stream()
            .filter(filter -> orgHrList.stream().anyMatch(matcher -> filter.getEmpNo().equals(matcher.getEmpNo())))
            .toList();

        for (AuthorityManagementDto dto : matchList) {
            for (HrEmpDto empDto : orgHrList) {
                if (dto.getEmpNo().equals(empDto.getEmpNo())) {
                    dto.mergeInfo(empDto);
                }
            }
        }

        int total = matchList.size();
        matchList = commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(matchList.stream().map(AuthorityManagementResponse::new).toList(), pageable, total);
    }

    public AuthorityManagementDetailResponse selectAuthorityManagement(Long userSeq) {
        AuthorityManagementDetailDto dto = authorityManagementRepository.selectAuthorityManagement(userSeq);

        if (dto == null) {
            dto = new AuthorityManagementDetailDto();
        } else {
            String empNo = "P" + dto.getUserId().substring(0, 6);
            HrEmpDto hrData = commonFunction.getHrEmpDto(empNo);
            dto = new AuthorityManagementDetailDto(hrData);
        }
        return dto.convertAuthorityManagementDetailResponse();
    }
}
