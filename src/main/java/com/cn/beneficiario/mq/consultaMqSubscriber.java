package com.cn.beneficiario.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.cn.beneficiario.dto.ConsultaMQ;
import com.cn.beneficiario.service.impl.BeneficiarioConsultaMQServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class consultaMqSubscriber {

	@Autowired
	private BeneficiarioConsultaMQServiceImpl service;
	
	private static final Logger LOG = LoggerFactory.getLogger(consultaMqSubscriber.class);
	
	
	@RabbitListener(queues = "${mq.queues.cn-consulta}")
	public void recebendoSolicitacaoConsulta(@Payload String payload) throws Exception {
		LOG.info("recebendo dados dados consulta!!");
		ObjectMapper mapper = new ObjectMapper();
		//ConsultaDTO dados = mapper.readValue(payload, ConsultaDTO.class);
		ConsultaMQ dados = mapper.readValue(payload, ConsultaMQ.class);
		service.InserirConsultaMQ(dados);
		LOG.info(dados.toString());
	}
	
}
