package com.startup.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class AlgoviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgoviewApplication.class, args);
	}

}
