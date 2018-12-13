package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		System.out.println("Running SpringBoot application...");
		SpringApplication.run(SpringBootApp.class, args);
	}
}