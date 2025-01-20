package com.airpremia.eosh.config.mybatis.parameterinjection;

import java.util.Set;

import org.apache.ibatis.mapping.SqlCommandType;

import com.airpremia.eosh.config.SpringContext;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;
import com.airpremia.esmsfos.core.config.mybatis.interfaces.MybatisInjectionParameter;

public class MybatisInjectionParameterLoginId extends MybatisInjectionParameter<String> {
    public MybatisInjectionParameterLoginId(Set<SqlCommandType> commandTypes) {
        super(commandTypes);
    }

    public MybatisInjectionParameterLoginId() {
        super();
    }

    @Override
    public String injectDataParameter() {
        UserTokenService userTokenService = SpringContext.getBean(UserTokenService.class);

        try {
            UserTokenDto userToken = userTokenService.getUserToken();
            return userToken.getEmpNo();
        } catch (RuntimeException ex) {
            return "NO-LOGIN";
        }
    }
}
