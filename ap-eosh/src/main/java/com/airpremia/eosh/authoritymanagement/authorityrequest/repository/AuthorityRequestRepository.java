package com.airpremia.eosh.authoritymanagement.authorityrequest.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestInsertDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestSearchDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestUpdateDto;

@Repository
public interface AuthorityRequestRepository {

    int insertAuthorityRequest(AuthorityRequestInsertDto insertDto);

    void updateAuthorityRequest(AuthorityRequestUpdateDto authorityRequestUpdateDto);

    void updateAuthorityManagement(AuthorityRequestUpdateDto updateDto);

    List<AuthorityRequestDto> selectAuthorityRequestPage(
        AuthorityRequestSearchDto searchDto);

    AuthorityRequestDto selectAuthorityRequest(long userAuthorityRequestSeq);

    AuthorityRequestInsertDto selectAuthorityRequestInsert(
        AuthorityRequestInsertDto authorityRequestInsertDtoList);

    AuthorityRequestUpdateDto selectAuthorityRequestUpdate(
        AuthorityRequestUpdateDto authorityRequestUpdateDtoList);

    int deleteAuthorityRequest(long userAuthorityRequestSeq);

}
