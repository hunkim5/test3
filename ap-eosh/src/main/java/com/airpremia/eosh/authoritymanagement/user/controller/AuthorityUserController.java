package com.airpremia.eosh.authoritymanagement.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.authoritymanagement.user.service.AuthorityUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/authority/users")
@Tag(name = "권한 사용자")
@RequiredArgsConstructor
public class AuthorityUserController {
    private final AuthorityUserService authorityUserService;

    @Operation(summary = "사용자 조회")
    @GetMapping(value = "/{userId}")
    public ResponseEntity<AuthorityUserResponse> selectAuthorityUserByUserId(
        @PathVariable String userId
    ) {
        return ResponseEntity.ok(authorityUserService.selectAuthorityUserByUserId(userId));
    }
}
