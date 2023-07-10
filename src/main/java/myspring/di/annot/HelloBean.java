package myspring.di.annot;

import java.util.List;

public class HelloBean {
	String name;
	PrinterBean printer;
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + " Default Constructor Called..");
	}

	public HelloBean(String name, PrinterBean printer) {
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

	public void setPrinter(PrinterBean printer) {
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
