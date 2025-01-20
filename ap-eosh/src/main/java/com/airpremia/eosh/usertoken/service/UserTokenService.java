package com.airpremia.eosh.usertoken.service;

import java.util.Arrays;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.components.jwt.JwtComponent;
import com.airpremia.eosh.components.jwt.Payload;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTokenService {
    private final JwtComponent jwtComponent;

    public UserTokenDto getUserToken() {
        String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
        Claims claims = jwtComponent.getAllClaimsFromToken(token);
        Payload payload = new Payload(claims);

        return UserTokenDto.builder()
            .empNo(payload.getEmpNo())
            .empName(payload.getName())
            .email(payload.getEmail())
            .deptCd(payload.getDeptCd())
            .deptNm(payload.getDeptNm())
            .deptFnCd(payload.getDeptFnCd())
            .birthYmd(payload.getBirthYmd())
            .roles(Arrays.asList(payload.getGroups().split(",")))
            .build();
    }

    public String getBearerAccessToken() {
        return "Bearer " + getAccessToken();
    }

    private String getAccessToken() {
        return SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
    }
}
