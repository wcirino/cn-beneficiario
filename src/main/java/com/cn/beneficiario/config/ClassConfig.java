package com.cn.beneficiario.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassConfig {
	
	@Bean
	public Random random() {
		Random rn = new Random();
		return rn;
	}
	
}
