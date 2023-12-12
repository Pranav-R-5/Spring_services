package com.quinbay.springboottraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringboottrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottrainingApplication.class, args);
	}

}
