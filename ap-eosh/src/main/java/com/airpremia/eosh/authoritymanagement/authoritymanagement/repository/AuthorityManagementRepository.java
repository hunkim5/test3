package com.airpremia.eosh.authoritymanagement.authoritymanagement.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementDetailDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementInsertDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementSearchDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementUpdateDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.entities.AuthorityManagementEntity;

@Repository
public interface AuthorityManagementRepository {
    List<AuthorityManagementEntity> selectAuthorityManagementHrData();

    int insertAuthorityManagementHr(AuthorityManagementInsertDto insertDto);

    int updateAuthorityManagement(AuthorityManagementUpdateDto authorityManagementUpdateDto);

    Page<AuthorityManagementDto> selectAuthorityManagementPage(
        @Param(value = "searchDto") AuthorityManagementSearchDto searchDto, Pageable pageable);

    List<AuthorityManagementDto> selectAuthorityManagementList(
        @Param(value = "searchDto") AuthorityManagementSearchDto searchDto);


    AuthorityManagementDetailDto selectAuthorityManagement(
        Long userSeq);


}
