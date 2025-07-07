package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EazyschoolApplication {

	public static void main(String[] args) {
		System.out.println("ENV URL: " + System.getenv("DB_URL"));

		SpringApplication.run(EazyschoolApplication.class, args);
	}

}
