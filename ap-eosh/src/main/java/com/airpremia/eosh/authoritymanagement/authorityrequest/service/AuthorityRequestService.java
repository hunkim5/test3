package com.airpremia.eosh.authoritymanagement.authorityrequest.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestInsertRequest;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestInsertResponse;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestResponse;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestSearchRequest;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestUpdateRequest;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestUpdateResponse;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestInsertDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestSearchDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestUpdateDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.repository.AuthorityRequestRepository;
import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityRequestService {
    private final Logger logger = LoggerFactory.getLogger(AuthorityRequestService.class);

    private final AuthorityRequestRepository authorityRequestRepository;
    private final CommonFunction commonFunction;
    private final UserTokenService userTokenService;
    private static final String DATE = "uuuuMMdd";

    @Transactional
    public AuthorityRequestInsertResponse insertinsertAuthorityRequest(AuthorityRequestInsertRequest insertRequest) {
        AuthorityRequestInsertDto insertDto = new AuthorityRequestInsertDto(insertRequest);
        long userSeq = commonFunction.getUserSeq();
        insertDto.setUserSeq(userSeq);
        authorityRequestRepository.insertAuthorityRequest(insertDto);

        return new AuthorityRequestInsertResponse(authorityRequestRepository.selectAuthorityRequestInsert(insertDto));
    }

    @Transactional
    public AuthorityRequestUpdateResponse updateAuthorityRequest(AuthorityRequestUpdateRequest updateRequest) {
        AuthorityRequestUpdateDto updateDto = new AuthorityRequestUpdateDto(updateRequest);
        authorityRequestRepository.updateAuthorityRequest(updateDto);
        return new AuthorityRequestUpdateResponse(authorityRequestRepository.selectAuthorityRequestUpdate(updateDto));
    }

    public Page<AuthorityRequestResponse> selectAuthorityRequestPage(
        AuthorityRequestSearchRequest searchRequest, Pageable pageable) {
        AuthorityRequestSearchDto searchDto = new AuthorityRequestSearchDto(searchRequest);

        if (searchDto.getGubun().equals("user")) {
            long userSeq = commonFunction.getUserSeq();
            searchDto.setUserSeq(userSeq);
        }

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        List<AuthorityRequestDto> pageList =
            authorityRequestRepository.selectAuthorityRequestPage(searchDto);

        for (AuthorityRequestDto data : pageList) {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        }
        for (HrEmpDto empDto : orgHrList) {
            empDto.setResponseKey(empDto.getEmpNo().substring(1, 7) + DateTimeFormatter.ofPattern(DATE)
                .format(empDto.getBirthYmd()));
        }
        List<AuthorityRequestDto> matchList =
            pageList.stream().filter(o -> orgHrList.stream().anyMatch(n -> o.getUserId().equals(n.getResponseKey())))
                .toList();

        for (AuthorityRequestDto dto : matchList) {
            for (HrEmpDto empDto : orgHrList) {
                if (dto.getUserId().equals(empDto.getResponseKey())) {
                    dto.mergeInfo(dto, empDto);
                }
            }
        }

        int total = matchList.size();
        matchList = commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(matchList.stream().map(AuthorityRequestResponse::new).toList(), pageable, total);
    }

    public AuthorityRequestResponse selectAuthorityRequest(long userAuthorityRequestSeq) {
        AuthorityRequestDto dto = authorityRequestRepository.selectAuthorityRequest(userAuthorityRequestSeq);
        String empNo = "P" + dto.getUserId().substring(0, 6);
        HrEmpDto hrData = commonFunction.getHrEmpDto(empNo);


        return new AuthorityRequestDto().mergeHrInfo(dto, hrData);
    }

    public int deleteAuthorityRequest(long userAuthorityRequestSeq) {
        return authorityRequestRepository.deleteAuthorityRequest(userAuthorityRequestSeq);
    }
}
