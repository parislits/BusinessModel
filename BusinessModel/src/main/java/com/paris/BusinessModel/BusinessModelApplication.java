package com.paris.BusinessModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BusinessModelApplication implements CommandLineRunner{
	
	@Autowired
	private MyRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BusinessModelApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		repository.create();
		
		
	}
	

	
	
	

}
