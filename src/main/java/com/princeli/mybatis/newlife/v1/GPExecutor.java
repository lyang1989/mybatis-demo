package com.princeli.mybatis.newlife.v1;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 08:43
 **/
public interface GPExecutor {

    public <T> T query(String statement, String parameter);
}
