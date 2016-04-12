package com.mySSM.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import com.mySSM.model.Student;

public class TestMyBatis {
	SqlSession sqlSession=null;
	@Before
	public void before(){
		// 通过配置文件获取数据库连接信息
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			// 通过配置信息构建一个SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// 通过sqlSessionFactory打开一个数据库会话
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return sqlSession;
	}
	
	@Test
	public void Test(){
		List<Student> studentList=sqlSession.selectList("com.mySSM.dao.StudentDao.getStudent");
		System.out.println(studentList);
	}
	
	@After
	public void after(){
		sqlSession.close();
	}
}
