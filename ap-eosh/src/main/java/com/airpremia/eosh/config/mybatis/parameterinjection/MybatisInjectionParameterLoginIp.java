package com.airpremia.eosh.config.mybatis.parameterinjection;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;

import org.apache.ibatis.mapping.SqlCommandType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.airpremia.esmsfos.core.config.mybatis.interfaces.MybatisInjectionParameter;

public class MybatisInjectionParameterLoginIp extends MybatisInjectionParameter<String> {
    public MybatisInjectionParameterLoginIp(Set<SqlCommandType> commandTypes) {
        super(commandTypes);
    }

    public MybatisInjectionParameterLoginIp() {
        super();
    }

    @Override
    public String injectDataParameter() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return "Unknown IP";
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0].trim();
        }
        return ipAddress;
    }
}
