package com.airpremia.eosh.ca.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.ca.entities.SubscribeCaEntity;
import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;

@Repository
public interface SubscribeCaItemRepository {
    List<SubscribeCaItemEntity> selectList(String subscribeCaUuid);

    SubscribeCaItemEntity selectSubscribeCaItemDetail(Long subscribeCaItemSeq);

    void deleteSubscribeCaItem(SubscribeCaItemEntity entity);

    void insertSubscribeCaItem(SubscribeCaItemEntity entity);

    void updateSubscribeCaItem(SubscribeCaItemEntity entity);

    void updateSubscribeCaItemCaApprvalprcEnum(SubscribeCaItemEntity entity);

    int selectCaCountByRange(
        @Param(value = "start") LocalDate start,
        @Param(value = "end") LocalDate end
    );

    void deleteSubscribeCaItemByUuid(SubscribeCaEntity entity);
}
