package br.com.bluebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.bluebank" })
public class BluebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluebankApplication.class, args);
	}
}
