package com.princeli.mybatis.newlife.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 09:13
 **/
public class GPMapperProxy implements InvocationHandler {

    private GPSqlSession sqlSession;

    public GPMapperProxy(GPSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(GPConfiguration.TestMapperXml.namespace)){
            String sql = GPConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
