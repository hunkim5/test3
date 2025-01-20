package com.airpremia.eosh.authoritymanagement.user.repository;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.authoritymanagement.user.entities.UserEntity;

@Repository
public interface AuthorityUserRepository {
    UserEntity selectAuthorityUserByUserId(String userId);
}
