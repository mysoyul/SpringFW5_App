package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + " Default Constructor Called..");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + " Overloading Constructor Called..");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() Method Called.." + name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("setprinter() Method Called.." + printer);
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
