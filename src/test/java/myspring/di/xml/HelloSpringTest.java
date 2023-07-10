package myspring.di.xml;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	@Resource(name = "hello")
	Hello myhello;
	
	@Test
	public void helloBean() {
		System.out.println(hello.sayHello());
		System.out.println(myhello.sayHello());
		//assertEquals("Hello 스프링", myhello.sayHello());
		myhello.print();
	}
}
