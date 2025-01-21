package com.boot.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.boot")
public class BootJsonValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJsonValidationApplication.class, args);
	}

}
