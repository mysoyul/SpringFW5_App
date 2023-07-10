package myspring.di.annot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:values.properties")
public class HelloBeanConfig {

}
