package com.airpremia.eosh.common.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommonFunctionRepository {
    long selectUserSeq(String userId);
}
