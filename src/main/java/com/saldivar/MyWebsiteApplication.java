package com.saldivar;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyWebsiteApplication {  

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MyWebsiteApplication.class, args);

	}

}
