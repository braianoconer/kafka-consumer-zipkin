package com.playground.mcsv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class Mcsv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mcsv2Application.class, args);
	}

}
