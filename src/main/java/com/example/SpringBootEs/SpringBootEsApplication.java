package com.example.SpringBootEs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEsApplication.class, args);
	}

}
