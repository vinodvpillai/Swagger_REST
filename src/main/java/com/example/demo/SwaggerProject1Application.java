package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main SpringBoot Starter Class
 * @author VPillai
 *
 */
@SpringBootApplication
public class SwaggerProject1Application {

	/**
	 * Main Method to inform SpringBoot to do Auto Configuration as start the Tomcat
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(SwaggerProject1Application.class, args);
	}
}
