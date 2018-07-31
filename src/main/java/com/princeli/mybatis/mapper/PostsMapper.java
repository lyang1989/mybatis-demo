package com.princeli.mybatis.mapper;

import com.princeli.mybatis.beans.Posts;

public interface PostsMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Posts record);

    int insertSelective(Posts record);

    Posts selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKey(Posts record);
}