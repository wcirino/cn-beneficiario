package com.cn.beneficiario.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

	@Value("${mq.queues.cn-beneficiario}")
	private String BenefFila;
	
	@Value("${mq.queues.cn-beneficiario-alter}")
	private String BenefFilaAlter;
		
	@Bean
	public Queue queueBenef() {
		return new Queue(BenefFila,true);
	}
	
	@Bean
	public Queue queueBenefAlter() {
		return new Queue(BenefFilaAlter,true);
	}	
}