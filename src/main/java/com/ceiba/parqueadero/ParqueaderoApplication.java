package com.ceiba.parqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ParqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParqueaderoApplication.class, args);
	}
}
