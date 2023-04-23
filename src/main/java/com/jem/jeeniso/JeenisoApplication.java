package com.jem.jeeniso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JeenisoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeenisoApplication.class, args);
	}

}
