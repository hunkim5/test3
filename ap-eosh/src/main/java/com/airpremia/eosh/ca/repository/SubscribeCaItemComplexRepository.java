package com.airpremia.eosh.ca.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.ca.dto.CaCollectionSearchDto;
import com.airpremia.eosh.ca.dto.SubscribeCaItemWithSourceDto;


@Repository
public interface SubscribeCaItemComplexRepository {
    Page<SubscribeCaItemWithSourceDto> selectPage(
        @Param(value = "searchDto") CaCollectionSearchDto searchDto, Pageable pageable);

    Page<SubscribeCaItemWithSourceDto> selectAdminPage(
        @Param(value = "searchDto") CaCollectionSearchDto searchDto, Pageable pageable);

    List<SubscribeCaItemWithSourceDto> selectList(@Param(value = "searchDto") CaCollectionSearchDto searchDto);

    List<SubscribeCaItemWithSourceDto> selectAdminList(@Param(value = "searchDto") CaCollectionSearchDto searchDto);
}
