package com.fitness.spitfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories
public class SpitfireApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpitfireApplication.class, args);
	}
}
