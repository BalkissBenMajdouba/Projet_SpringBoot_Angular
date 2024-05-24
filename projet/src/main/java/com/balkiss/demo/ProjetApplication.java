package com.balkiss.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.entities.Pc;
import com.balkiss.demo.entities.User;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Pc.class,User.class,Marque.class);
	
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
}
