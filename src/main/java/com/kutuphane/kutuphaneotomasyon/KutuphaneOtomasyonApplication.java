package com.kutuphane.kutuphaneotomasyon;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KutuphaneOtomasyonApplication {

	public static void main(String[] args) {
		SpringApplication.run(KutuphaneOtomasyonApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}
