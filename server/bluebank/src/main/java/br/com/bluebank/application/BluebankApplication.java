package br.com.bluebank.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"br.com.bluebank"
})
public class BluebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluebankApplication.class, args);
	}
}
