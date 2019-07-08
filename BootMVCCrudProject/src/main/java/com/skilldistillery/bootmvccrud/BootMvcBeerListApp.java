package com.skilldistillery.bootmvccrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.jpacrudproject")
public class BootMvcBeerListApp {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcBeerListApp.class, args);
	}
}
