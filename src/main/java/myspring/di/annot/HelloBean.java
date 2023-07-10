package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("helloBean")
@Scope("singleton")
public class HelloBean {
	@Value("${myName}")
	String name;
	
	@Autowired
	@Qualifier("stringPrinter")
	PrinterBean printer;
	
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + " Default Constructor Called..");
	}


	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
