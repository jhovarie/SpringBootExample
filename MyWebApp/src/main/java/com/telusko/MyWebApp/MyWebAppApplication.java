package com.telusko.MyWebApp;

//https://www.youtube.com/watch?v=uxrOX7gLsGw&list=PLsyeobzWxl7oA8QOlMtQsRT_I7Rx2hoX4&index=8

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebAppApplication.class, args);
	}

}

//Add Dependency tomcat jasper
//https://www.youtube.com/watch?v=nLbvzF1-vXY&list=PLsyeobzWxl7oA8QOlMtQsRT_I7Rx2hoX4&index=7
//10:08	
/*
* Open https://mvnrepository.com/
* search for tomcat jasper
* To check which version open your project in eclipse -> Maven Dependencies
* -> look for tomcat-embeded-core-xx-x-xx.jar the version of this must be
* thesame with the-same with tomcat jasper from mvnrepository.com
* Select correct version then select maven and copy
* 
* Go back to your eclipse project -> Edit pom.xml
* 
* <!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper -->
		<dependency>
		    <groupId>org.apache.tomcat</groupId>
		    <artifactId>tomcat-jasper</artifactId>
		    <version>10.1.17</version>
		</dependency>	
* */