package com.skilldistillery.bootmvccrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("com.skilldistillery.jpacrudproject")
public class BootMvcBeerListApp extends SpringBootServletInitializer{
	
	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(BootMvcBeerListApp.class);
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcBeerListApp.class, args);
	}
}
