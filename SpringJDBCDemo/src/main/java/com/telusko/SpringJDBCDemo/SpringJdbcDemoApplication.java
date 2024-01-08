package com.telusko.SpringJDBCDemo;

//JDBC using jdbctemplate
//https://www.youtube.com/watch?v=Nc9NmS5kEjU&list=PLsyeobzWxl7oA8QOlMtQsRT_I7Rx2hoX4&index=6
/*
 * Dependency needed
 * JDBC API
 * H2 Database
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.SpringJDBCDemo.model.Alien;
import com.telusko.SpringJDBCDemo.repo.AlienRepo;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(11);
		alien1.setName("Navin");
		alien1.setTech("Java");
		
		//JDBC Steps
		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);
		
		System.out.println(repo.findAll());
	}

}
