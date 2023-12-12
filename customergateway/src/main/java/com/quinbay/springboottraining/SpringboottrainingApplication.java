package com.quinbay.springboottraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringboottrainingApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringboottrainingApplication.class, args);
	}

}
