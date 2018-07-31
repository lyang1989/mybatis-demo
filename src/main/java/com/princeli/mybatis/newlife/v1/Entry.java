package com.princeli.mybatis.newlife.v1;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 09:47
 **/
public class Entry {
    public static void main(String[] args) {
        GPSqlSession sqlSession = new GPSqlSession(new GPConfiguration(),
                new GPSimpleExecutor());
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        Test test = mapper.selectByPrimaryKey(2);
        System.out.println(test);
    }
}
