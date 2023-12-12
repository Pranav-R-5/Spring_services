package com.quinbay.springboottraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class SpringboottrainingApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringboottrainingApplication.class, args);
	}

}
