package com.princeli.mybatis.newlife.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 08:43
 **/
public class GPConfiguration {

    public <T> T getMapper(Class<T> clazz,GPSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new GPMapperProxy(sqlSession));
    }


    /**
     * xml解析
     */
    static class TestMapperXml{
        public static final String namespace="com.princeli.mybatis.newlife.v1.TestMapper";
        public static final Map<String,String> methodSqlMapping = new HashMap<>();

        static {
            methodSqlMapping.put("selectByPrimaryKey","select * from test where id = %d");
        }
    }



}



