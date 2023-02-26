package com.mybank.transactions.config;

// import java.util.Arrays;
// import java.util.HashSet;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.Contact;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration
// @EnableSwagger2
public class SwaggerConfig {
  // private Contact contact() {
  // return new Contact(
  // "MyBank",
  // "https://www.mybank.com",
  // "email@myemail.com");
  // }

  // private ApiInfoBuilder apiInfo() {
  // return new ApiInfoBuilder()
  // .title("MyBank Transactions API")
  // .description("MyBank Transactions API")
  // .version("1.0.0")
  // .termsOfServiceUrl("Terms of Use: Open Source")
  // .contact(contact());
  // }

  // @Bean
  // public Docket api() {
  // return new Docket(DocumentationType.SWAGGER_2)
  // .select()
  // .apis(RequestHandlerSelectors.basePackage("com.mybank.transactions.controller"))
  // .paths(PathSelectors.any())
  // .build()
  // .apiInfo(apiInfo().build())
  // .consumes(new HashSet<>(Arrays.asList("application/json")))
  // .produces(new HashSet<>(Arrays.asList("application/json")));
  // }
}