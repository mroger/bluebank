package br.com.bluebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 */
@SpringBootApplication(scanBasePackages = { "br.com.bluebank" })
public class BluebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluebankApplication.class, args);
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(BluebankApplication.class);
//	    builder.headless(false).run(args);
	}
}
