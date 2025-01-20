package com.airpremia.eosh.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.airpremia.eosh.common.dto.VaultProperties;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(VaultProperties vaultProperties) {
        return DataSourceBuilder.create()
            .url(vaultProperties.getUrl())
            .username(vaultProperties.getUsername())
            .password(vaultProperties.getPassword())
            .build();
    }
}

