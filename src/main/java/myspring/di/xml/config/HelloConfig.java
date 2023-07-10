package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource("classpath:values.properties")
public class HelloConfig {
	
	@Bean
	Printer strPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	Printer conPrinter() {
		return new ConsolePrinter();
	}
	
	
}
