package com.hamsoft.springencache3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringEncache3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringEncache3Application.class, args);
	}

}

