package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-beans.xml")
class HelloBeanTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	HelloBean hello2;	
	
	@Autowired
	@Qualifier("stringPrinter")
	PrinterBean printer;
	
	@Resource(name="helloBeanCons")
	HelloBeanCons helloCons;
	
	@Test
	void helloBeanCons() {
		System.out.println(helloCons.sayHello());
	}
	
	@Test @Disabled
	void helloBean() {
		System.out.println(hello.sayHello());
		assertEquals(hello.sayHello(), "Hello 어노테이션");
		assertSame(hello, hello2);
	}

}
