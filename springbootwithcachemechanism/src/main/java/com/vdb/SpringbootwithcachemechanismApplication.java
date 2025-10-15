package com.vdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootwithcachemechanismApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithcachemechanismApplication.class, args);
	}

}
