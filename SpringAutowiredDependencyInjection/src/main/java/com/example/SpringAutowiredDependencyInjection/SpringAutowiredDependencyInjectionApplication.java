package com.example.SpringAutowiredDependencyInjection;

//Spring Autowired Dependency Injection
//https://www.youtube.com/watch?v=K43qyHJXmWI&list=PLsyeobzWxl7oA8QOlMtQsRT_I7Rx2hoX4&index=4
//Dependency Spring Web

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAutowiredDependencyInjectionApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringAutowiredDependencyInjectionApplication.class, args);
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringAutowiredDependencyInjectionApplication.class, args);
		//context.getBean Can cause error if you dont add @Component before class Alien
		
		Alien a = context.getBean(Alien.class);	
		a.show();
		
		//Alien a1 = context.getBean(Alien.class);	
		//a1.show();
		/*
		Output 
		Object Created
		in show
		in show
		*/
		//The object is created only once. it use singletone patern
	}

}

/*
Error:
Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.demo.Alien' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:343)

Solution:

import org.springframework.stereotype.Component; //<- Add this

@Component //<- add this
public class Alien {	
*/

