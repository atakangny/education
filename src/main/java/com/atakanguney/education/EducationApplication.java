package com.atakanguney.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.atakanguney.education.repository")
@SpringBootApplication
@EnableAutoConfiguration
public class EducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationApplication.class, args);
	}

}
