package com.princeli.mybatis.newlife.v1;

import lombok.Data;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-31 09:27
 **/
@Data
public class Test {
    private Integer id;

    private Integer nums;

    private String name;

    public Test(Integer id, Integer nums, String name) {
        this.id = id;
        this.nums = nums;
        this.name = name;
    }

    public Test() {

    }
}
