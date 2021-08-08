package com.syscho.boot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(info = @Info(title = "${info.title}",
        description = "${info.description}",
        contact = @Contact(email = "Test@tst.com",
                name = "${info.contact..name}",
                url = "${info.contact.url}")))
@SpringBootApplication
@ComponentScan(basePackages = {"com.syscho.boot.*"})
@EnableJpaRepositories(basePackages = "com.syscho.boot.repository")
@EntityScan("com.syscho.boot.model")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}























