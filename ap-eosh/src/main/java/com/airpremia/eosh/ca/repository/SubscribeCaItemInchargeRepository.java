package com.airpremia.eosh.ca.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.ca.entities.SubscribeCaItemInchargeEntity;

@Repository
public interface SubscribeCaItemInchargeRepository {

    List<SubscribeCaItemInchargeEntity> selectItemInchargeList(
        String subscribeCaUuid,
        Long subscribeCaItemSeq
    );

    void deleteSubscribeCaInchargeListExclude(
        SubscribeCaItemInchargeEntity subscribeCaItemInchargeEntity, List<Long> excludeInchargeSeqList
    );

    void insertSubscribeCaIncharge(SubscribeCaItemInchargeEntity eachInchargeData);

    void updateSubscribeCaIncharge(SubscribeCaItemInchargeEntity eachInchargeData);

}
