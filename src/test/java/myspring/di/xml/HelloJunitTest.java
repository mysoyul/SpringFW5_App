package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

class HelloJunitTest {
	BeanFactory factory;
	
	@BeforeEach
	public void setup() {
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");		
	}

	@Test
	void helloBean() {
		//1. Container 객체생성하기
		//2. Container에게 Bean을 요청하기
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		//3. Bean이 Singleton 인지 확인하기 위해 주소 비교
		//scope이 prototype이면 주소 같지 않음
		//assertNotSame(hello, hello2);
		
		assertSame(hello, hello2);
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}

}
