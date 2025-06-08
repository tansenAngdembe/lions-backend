package com.lions_internationals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.lions_internationals")
public class LionsInternationalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LionsInternationalsApplication.class, args);
	}

}
