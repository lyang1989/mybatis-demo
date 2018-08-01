package com.princeli.mybatis.main;

import com.princeli.mybatis.beans.Posts;
import com.princeli.mybatis.mapper.PostsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

/**
 * @program: mybatis-demo
 * @description: ${description}
 * @author: ly
 * @create: 2018-07-27 10:57
 **/
public class MyBatisMain {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() throws FileNotFoundException {
        return getSqlSessionFactory().openSession();
    }

    public static SqlSessionFactory getSqlSessionFactory() throws FileNotFoundException {
        String mybatisCfg = "/mybatis/mybatis-config.xml";
        //配置文件
        InputStream configFile = new FileInputStream(MyBatisMain.class.getResource(mybatisCfg).getFile());
        if (null != sqlSessionFactory) {
            return sqlSessionFactory;
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory;
    }

    public static Posts getOne(SqlSession sqlSession, int id) throws SQLException {
        PostsMapper postsMapper = sqlSession.getMapper(PostsMapper.class);
        long start = System.currentTimeMillis();
        Posts posts = postsMapper.selectByPrimaryKey(id);
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        return posts;
    }


    public static void diffSession() throws Exception {
        SqlSession sqlSession1 = getSqlSessionFactory().openSession();
        SqlSession sqlSession2 = getSqlSessionFactory().openSession();
        SqlSession sqlSession3 = getSqlSessionFactory().openSession();
        getOne(sqlSession1, 1);
        sqlSession1.commit();
        sqlSession1.close();
        getOne(sqlSession2, 1);
        sqlSession2.commit();
        sqlSession2.close();
        getOne(sqlSession3, 1);
        sqlSession3.commit();
        sqlSession3.close();
    }

    /**
     * 缓存验证
     */
    public static void cacheVerify() throws Exception {
        SqlSession sqlSession =getSqlSession();
        PostsMapper postsMapper = sqlSession.getMapper(PostsMapper.class);
        Posts posts1 = postsMapper.selectByPrimaryKey(2);
        System.out.println("posts1:"+posts1);
        Posts posts2 = postsMapper.selectByPrimaryKey(2);
        System.out.println("posts2:"+posts2);
        System.out.println(posts1.equals(posts2));
    }


    public static void main(String[] args) throws Exception {
            cacheVerify();

//        SqlSession sqlSession =getSqlSession();
//        PostsMapper postsMapper = sqlSession.getMapper(PostsMapper.class);
//        Posts posts1 = postsMapper.selectByPrimaryKey(2);
//        System.out.println(posts1);



        //add
//        Posts posts = new Posts();
//        posts.setPostName("test");
//        posts.setBlogId(22);
//        posts.setCreateTime(new Date());
//        postsMapper.insert(posts);
//        sqlSession.commit();



//
//        Posts posts = new Posts();
//        posts.setPid(2);
//        posts.setPostName("test3");
//        posts.setBlogId(22);
//        posts.setCreateTime(new Date());
//        postsMapper.updateByPrimaryKey(posts);
//        //sqlSession.commit();
//        Posts posts2 = postsMapper.selectByPrimaryKey(2);
//        System.out.println(posts2);
//
//        System.out.println(posts1.equals(posts2));
//        diffSession();
    }
}
