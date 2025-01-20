package com.airpremia.eosh.config;

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.airpremia.eosh.config.formatter.LocalDateFormatter;
import com.airpremia.eosh.config.formatter.LocalDateTimeFormatter;
import com.airpremia.eosh.config.mybatis.parameterinjection.MybatisInjectionParameterLoginId;
import com.airpremia.eosh.config.mybatis.parameterinjection.MybatisInjectionParameterLoginIp;
import com.airpremia.eosh.config.mybatis.parameterinjection.MybatisInjectionParameterNow;
import com.airpremia.eosh.config.serializer.LocalDateTimeSerializer;
import com.airpremia.eosh.constant.ConfigurationConstant;
import com.airpremia.esmsfos.core.config.mybatis.interceptors.DefaultInjectionParameterInterceptor;
import com.airpremia.esmsfos.core.config.register.MybatisParameterInjectionRegister;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
@MapperScan(basePackages = {ConfigurationConstant.PROJECT_PACKAGE_ROOT})
@ComponentScan(basePackages = {ConfigurationConstant.PROJECT_PACKAGE_ROOT})
@EnableTransactionManagement
public class BasicConfiguration implements WebMvcConfigurer {
    public BasicConfiguration(ObjectMapper objectMapper) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        objectMapper.registerModule(module);
    }

    @PostConstruct
    public void initial() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDateTime.class, new LocalDateTimeFormatter());
        registry.addFormatterForFieldType(LocalDate.class, new LocalDateFormatter());
    }

    public MybatisParameterInjectionRegister mybatisParameterRegister() {
        MybatisInjectionParameterLoginId loginId = new MybatisInjectionParameterLoginId();
        MybatisInjectionParameterNow now = new MybatisInjectionParameterNow();
        MybatisInjectionParameterLoginIp loginIp = new MybatisInjectionParameterLoginIp();

        return new MybatisParameterInjectionRegister()
            .addParameterInjection("loginUserId", loginId)
            .addParameterInjection("insertUserId", loginId)
            .addParameterInjection("updateUserId", loginId)
            .addParameterInjection("deleteUserId", loginId)
            .addParameterInjection("insertDtm", now)
            .addParameterInjection("updateDtm", now)
            .addParameterInjection("deleteDtm", now)
            .addParameterInjection("insertIp", loginIp)
            .addParameterInjection("updateIp", loginIp)
            .addParameterInjection("deleteIp", loginIp);
    }

    @Bean
    public DefaultInjectionParameterInterceptor defaultInjectionParameterInterceptor() {
        return new DefaultInjectionParameterInterceptor(mybatisParameterRegister().getInjectionMap());
    }
}

