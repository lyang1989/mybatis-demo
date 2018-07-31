package com.princeli.mybatis.plugins;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 15:55
 **/
@Intercepts({ @Signature(type = ParameterHandler.class, method = "setParameters", args = { PreparedStatement.class}) })
public class ParameterHandlerPlugin implements Interceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        ParameterHandler parameterHandler = (ParameterHandler)invocation.getTarget();
        logger.info(String.format("ParameterHandlerPlugin param=%s",parameterHandler.getParameterObject()));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
