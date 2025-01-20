package com.airpremia.eosh.components.jwt;


import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.airpremia.eosh.components.auth.JwtAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtComponent {
    public static final String NAME = "name";
    public static final String DEPT_CD = "deptCd";
    public static final String ROLES = "roles";
    private final String secret;

    public JwtComponent(@Value("${airpremia.core.security.jwt-secret}") String secret) {
        this.secret = secret;
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secret));
    }

    // 토큰에서 만료 시간 가져오기
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // 특정 클레임 추출
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // 모든 클레임 추출
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    // 토큰 발급
    public String generateToken(String subject, Map<String, Object> claims, Long expiration) {
        if (claims == null) {
            claims = new HashMap<>();
        }

        return Jwts.builder()
            .subject(subject)
            .claims(claims)
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey(), Jwts.SIG.HS512)
            .compact();
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            getAllClaimsFromToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        Collection<? extends GrantedAuthority> authorities = null;

        if (claims.get(ROLES) != null) {
            authorities = Arrays.stream(claims.get(ROLES).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
        }
        return new JwtAuthenticationToken(getClaimFromToken(token, Claims::getSubject), token, authorities);
    }

    public Map<String, Object> makeClaims(String name, String deptCd, String roles) {
        Map<String, Object> claims = new HashMap<>();

        claims.put(NAME, name);
        claims.put(DEPT_CD, deptCd);
        claims.put(ROLES, roles);

        return claims;
    }
}


