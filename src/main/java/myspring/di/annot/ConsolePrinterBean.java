package myspring.di.annot;

public class ConsolePrinterBean implements PrinterBean {
	public void print(String message) {
		System.out.println(message);
	}
}
