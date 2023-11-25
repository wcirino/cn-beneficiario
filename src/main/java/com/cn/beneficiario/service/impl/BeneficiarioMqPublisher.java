package com.cn.beneficiario.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.beneficiario.config.MQConfig;
import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.entity.beneficiarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BeneficiarioMqPublisher {

private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	private MQConfig mqserve;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioMqPublisher.class);
	
	public void envioBeneficiario(Beneficiario benef)  throws JsonProcessingException{
		//AgendamentoMQ agend = this.mapperAgendamento(agenda); 
		String json = this.convertIntoJson(benef);
		LOG.info("Enviando dados Beneficiario !!");
		LOG.info(mqserve.queueBenef().getName());
		LOG.info(json);
		rabbitTemplate.convertAndSend(mqserve.queueBenef().getName(),json);
		LOG.info("Enviado beneficiario");
	}
	
	public void envioBeneficiarioAlterar(Beneficiario benef)  throws JsonProcessingException{
		//AgendamentoMQ agend = this.mapperAgendamento(agenda); 
		String json = this.convertIntoJson(benef);
		LOG.info("Enviando dados Beneficiario !!");
		LOG.info(mqserve.queueBenefAlter().getName());
		LOG.info(json);
		rabbitTemplate.convertAndSend(mqserve.queueBenefAlter().getName(),json);
		LOG.info("Enviado beneficiario");
	}
	
	private  String convertIntoJson(Beneficiario benf) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json  = mapper.writeValueAsString(benf);
		return json;
	}
		
}
