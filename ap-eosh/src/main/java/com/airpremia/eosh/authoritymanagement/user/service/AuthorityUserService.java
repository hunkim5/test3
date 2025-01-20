package com.airpremia.eosh.authoritymanagement.user.service;

import org.springframework.stereotype.Service;

import com.airpremia.eosh.authoritymanagement.user.controller.AuthorityUserResponse;
import com.airpremia.eosh.authoritymanagement.user.entities.UserEntity;
import com.airpremia.eosh.authoritymanagement.user.repository.AuthorityUserRepository;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityUserService {
    private final AuthorityUserRepository authorityUserRepository;

    public AuthorityUserResponse selectAuthorityUserByUserId(String userId) {
        UserEntity user = authorityUserRepository.selectAuthorityUserByUserId(userId);

        if (user == null) {
            throw new ExpectedException(ExceptionCode.NOT_FOUND_USER);
        }

        return new AuthorityUserResponse(user);
    }
}
