package br.com.bluebank.configuration;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class for Swagger 2 documentation.
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket greetingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.bluebank"))
          .paths(PathSelectors.regex("/accounts.*"))
          .build()
          .useDefaultResponseMessages(false)
          .globalResponseMessage(RequestMethod.GET,
                  newArrayList(new ResponseMessageBuilder()
                      .code(500)
                      .message("Internal Server Error")
                      .responseModel(new ModelRef("Error"))
                      .build()))
          .globalResponseMessage(RequestMethod.POST,
                  newArrayList(new ResponseMessageBuilder()
                      .code(500)
                      .message("Internal Server Error")
                      .responseModel(new ModelRef("Error"))
                      .build()))
          .globalResponseMessage(RequestMethod.POST,
                  newArrayList(new ResponseMessageBuilder()
                      .code(409)
                      .message("Business violation")
                      .responseModel(new ModelRef("Error"))
                      .build()))
          .apiInfo(apiInfo());
    }
 
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
          "Blue Bank API",
          "This API was built to manage Blue Bank accounts.",
          "1.0",
          "API TOS",
          contact(),
          "License of API",
          "license.html");
        return apiInfo;
    }
 
    private Contact contact() {
        return new Contact("Marcos",
                "https://mr0ger.wordpress.com/",
                "mroger.oliveira@gmail.com");
    }
	
}
