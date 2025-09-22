package com.Babu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.Babu")
public class BabuFoodBackendApplication {

	public static void main(String[] args) {
        SpringApplication.run(BabuFoodBackendApplication.class, args);
	}

}
