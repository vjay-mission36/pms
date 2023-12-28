package com.mission42;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ServiceParishApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceParishApplication.class, args);
	}




}
