package com.cn.beneficiario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnApplication.class, args);
	}

}
