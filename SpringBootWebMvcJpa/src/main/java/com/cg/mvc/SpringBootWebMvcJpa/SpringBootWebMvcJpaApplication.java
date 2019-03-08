package com.cg.mvc.SpringBootWebMvcJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cg")
@SpringBootApplication
@EntityScan("com.cg.mvc.bean")
public class SpringBootWebMvcJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcJpaApplication.class, args);
	}

}
