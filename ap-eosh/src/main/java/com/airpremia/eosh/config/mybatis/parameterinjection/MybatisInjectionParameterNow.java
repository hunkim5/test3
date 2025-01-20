package com.airpremia.eosh.config.mybatis.parameterinjection;

import java.time.LocalDateTime;
import java.util.Set;

import org.apache.ibatis.mapping.SqlCommandType;

import com.airpremia.esmsfos.core.config.mybatis.interfaces.MybatisInjectionParameter;

public class MybatisInjectionParameterNow extends MybatisInjectionParameter<LocalDateTime> {
    public MybatisInjectionParameterNow(Set<SqlCommandType> commandTypes) {
        super(commandTypes);
    }

    public MybatisInjectionParameterNow() {
        super();
    }

    @Override
    public LocalDateTime injectDataParameter() {
        return LocalDateTime.now();
    }

}
