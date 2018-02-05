package com.sample.samplespringbatch.configurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sample.samplespringbatch")
public class SamplespringbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamplespringbatchApplication.class, args);
	}

}
