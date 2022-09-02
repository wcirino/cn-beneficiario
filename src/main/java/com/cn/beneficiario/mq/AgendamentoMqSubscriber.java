package com.cn.beneficiario.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.cn.beneficiario.dto.AgendamentoMQ;
import com.cn.beneficiario.service.impl.BeneficiarioAgendamentoMQServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AgendamentoMqSubscriber {

	@Autowired
	private BeneficiarioAgendamentoMQServiceImpl service;
	
	private static final Logger LOG = LoggerFactory.getLogger(consultaMqSubscriber.class);
	
	
	@RabbitListener(queues = "${mq.queues.cn-agendamento}")
	public void recebendoSolicitacaoConsulta(@Payload String payload) throws Exception {
		LOG.info("recebendo dados dados !!");
		ObjectMapper mapper = new ObjectMapper();
		//ConsultaDTO dados = mapper.readValue(payload, ConsultaDTO.class);
		AgendamentoMQ dados = mapper.readValue(payload, AgendamentoMQ.class);
		service.inserirAgendamento(dados);
		LOG.info(dados.toString());
	}
	
}
