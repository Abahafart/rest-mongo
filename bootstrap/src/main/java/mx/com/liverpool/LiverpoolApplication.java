package mx.com.liverpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import mx.com.liverpool.application.generic.ServiceApplication;

@SpringBootApplication
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
    ServiceApplication.class})})
public class LiverpoolApplication {

  public static void main(String[] args) {
    SpringApplication.run(LiverpoolApplication.class, args);
  }
}
