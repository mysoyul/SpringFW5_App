package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.student.dao.mapper.StudentMapper;
import myspring.student.vo.StudentVO;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired 
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentMapper studentMapper;
	
	@Test
	void student() {
		List<StudentVO> stuList = 
				studentMapper.selectStudentCourseStatus();
	}
	
	@Test
	void service() {
		UserVO user = userService.getUser("gildong");
		System.out.println(user);
	}
	
	@Test
	void mapper() {
		UserVO user = userMapper.selectUserById("dooly");
		System.out.println(user);
	}
	
	
	@Test @Disabled
	void user_sql() {
		UserVO user = 
				sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
	@Test
	public void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB URL = " + metaData.getURL());
			System.out.println("DB Username = " + metaData.getUserName());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
