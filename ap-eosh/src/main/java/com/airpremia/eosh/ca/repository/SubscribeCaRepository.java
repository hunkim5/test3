package com.airpremia.eosh.ca.repository;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.ca.entities.SubscribeCaEntity;

@Repository
public interface SubscribeCaRepository {
    SubscribeCaEntity selectDetail(String subscribeCaUuid);

    void insertSubscribeCa(SubscribeCaEntity saveDto);

    void updateSubscribeCa(SubscribeCaEntity saveDto);

}
