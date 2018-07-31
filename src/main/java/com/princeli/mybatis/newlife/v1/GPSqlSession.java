package com.princeli.mybatis.newlife.v1;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 08:43
 **/
public class GPSqlSession {

    private GPConfiguration configuration;

    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }


    /**
     *
     * @param clazz
     */
    public <T> T getMapper(Class<T> clazz){
       return configuration.getMapper(clazz,this);

    }


    /**
     *
     * @param statement
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statement,String parameter){
        return executor.query(statement,parameter);
    }
}
