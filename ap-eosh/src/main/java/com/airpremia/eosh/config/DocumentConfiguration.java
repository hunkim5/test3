package com.airpremia.eosh.config;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.AntPathMatcher;

import com.airpremia.esmsfos.core.properties.CoreSecurityProperties;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DocumentConfiguration {
    private final CoreSecurityProperties coreSecurityProperties;
    private static final String SECURITY_SCHEMAS = "_SECURITY_SCHEMAS";
    private final SecurityRequirement securityRequirement = new SecurityRequirement().addList(SECURITY_SCHEMAS);

    @Value("${springdoc.server-base-url}")
    private String serverBaseUrl;


    @Profile({"test || local"})
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .addServersItem(
                new Server().url(serverBaseUrl)
            )
            .info(
                new Info()
                    .title("AP-eSMS API")
                    .summary("AP-eSMS에 사용하는 API")
                    .description("""
                        <div><code>공용적인 RESPONSE  statusCode</code></div>
                        <hr/>
                        <div><code>statusCode = "default.lOGIN_ACCESS_BLOCK" 해당 계정은 BLOCK 된 상태입니다[accessToken,refresh토큰 삭제]</code></div>
                        <hr/>
                        <div><code>statusCode = "default.lOGIN_ACCESS_DENY" 로그인이 거부된상태 [accessToken,refresh토큰 삭제]</code></div>
                        <hr/>
                        <div><code>statusCode = "auth.AUTH_NEED_TO_REFRESH" accessToken의 expired됨을 알림 refresh토큰을 통해서 accessToken을 재발급.</code></div>
                        <hr/>
                        <div><code>statusCode = "auth.AUTH_DANGER_ACCESS" 해당 accessToken은 invalid한(해킹시도) 요소로 보입니다. [accessToken,refresh토큰 삭제]</code></div>
                        <hr/>
                        <div><code>statusCode = "auth.AUTH_NEED_TO_LOGIN" 해당 요청은 로그인이 필수.</code></div>
                        <hr/>
                        """)
                    .version("1.0.0")
            )
            .components(
                new Components()
                    .addSecuritySchemes(SECURITY_SCHEMAS,
                        new SecurityScheme()
                            .in(In.HEADER)
                            .type(Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .description("""
                                <div><code>http status code 401시에는 권한이 필요하다는 응답</code></div>
                                <div><code>data payload에서 statusCode별 상황은 아래와 같다.</code></div>
                                <hr/>
                                <div><code>statusCode = "default.lOGIN_ACCESS_BLOCK" 해당 계정은 BLOCK 된 상태입니다[accessToken,refresh토큰 삭제]</code></div>
                                <hr/>
                                <div><code>statusCode = "default.lOGIN_ACCESS_DENY" 로그인이 거부된상태 [accessToken,refresh토큰 삭제]</code></div>
                                <hr/>
                                <div><code>statusCode = "auth.AUTH_NEED_TO_REFRESH" accessToken의 expired됨을 알림 refresh토큰을 통해서 accessToken을 재발급.</code></div>
                                <hr/>
                                <div><code>statusCode = "auth.AUTH_DANGER_ACCESS" 해당 accessToken은 invalid한(해킹시도) 요소로 보입니다. [accessToken,refresh토큰 삭제]</code></div>
                                <hr/>
                                <div><code>statusCode = "auth.AUTH_NEED_TO_LOGIN" 해당 요청은 로그인이 필수.</code></div>
                                <hr/>
                                <br/>header에 넣는 요소
                                <br/>Authorization:Bearer @{accessToken}
                                <br/>
                                <hr />
                                <br/>테스트 값
                                <hr />
                                    <p><code>.eyJzdWIiOiIxIiwiZXhwIjoxNzQ3OTg2NzA0LCJ1c2VyRGV0YWlscyI6eyJ1c2VyTm0iOiLthYzsiqTtirjsnKDsoIAifSwiQXV0aG9yaXphdGlvbiI6ImFueSJ9.GMWi75QG73eE1XMnnMQoeCW7B33xkZ6cJ4qQbA__eef8m55VErYuDWieW0XHVS43BTwQjJFgZRdKotKvmOvV-A</code></p>
                                <hr />
                                """)
                    )
            );

    }

    //    path의존적으로 처리
    @Bean
    public OpenApiCustomizer securityOpenApiCustomiser() {
        List<String> notJwtCheckers = coreSecurityProperties.getJwtNotCheckUriAntMatchers();
        final AntPathMatcher antPathMatcher = new AntPathMatcher();
        return openApi -> {

            Paths paths = openApi.getPaths();
            if (paths != null) {
                paths.keySet().removeIf(path -> path.startsWith("/default/"));
                paths.forEach((path, pathItem) -> {

                    if (notJwtCheckers.stream().noneMatch(needAuthUri -> antPathMatcher.match(needAuthUri, path))) {
                        applySecurityToPathItem(pathItem);
                    }
                });
                Map<String, PathItem> sortedPaths = paths.entrySet().stream()
                    .sorted(Comparator.comparing(entry -> entry.getValue().readOperationsMap().values().stream()
                        .map(Operation::getSummary)
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElse("")))
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        Paths::new
                    ));
                Paths newPaths = new Paths();
                sortedPaths.forEach(newPaths::addPathItem);
                openApi.setPaths(newPaths);
            }
        };
    }

    private void applySecurityToPathItem(PathItem pathItem) {
        if (pathItem.getGet() != null) {
            pathItem.getGet().addSecurityItem(securityRequirement);
        }
        if (pathItem.getPost() != null) {
            pathItem.getPost().addSecurityItem(securityRequirement);
        }
        if (pathItem.getPut() != null) {
            pathItem.getPut().addSecurityItem(securityRequirement);
        }
        if (pathItem.getDelete() != null) {
            pathItem.getDelete().addSecurityItem(securityRequirement);
        }
        if (pathItem.getPatch() != null) {
            pathItem.getPatch().addSecurityItem(securityRequirement);
        }
        if (pathItem.getOptions() != null) {
            pathItem.getOptions().addSecurityItem(securityRequirement);
        }
        if (pathItem.getHead() != null) {
            pathItem.getHead().addSecurityItem(securityRequirement);
        }
        if (pathItem.getTrace() != null) {
            pathItem.getTrace().addSecurityItem(securityRequirement);
        }
    }
}
