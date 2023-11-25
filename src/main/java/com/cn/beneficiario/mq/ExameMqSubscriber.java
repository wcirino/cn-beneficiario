package com.cn.beneficiario.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.cn.beneficiario.dto.ExameMQ;
import com.cn.beneficiario.service.impl.BeneficiarioExameMQServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExameMqSubscriber {

	@Autowired
	private BeneficiarioExameMQServiceImpl service;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExameMqSubscriber.class);
	
	
	@RabbitListener(queues = "${mq.queues.cn-exame}")
	public void recebendoSolicitacaoConsulta(@Payload String payload) throws Exception {
		LOG.info("recebendo dados dados exame!!");
		ObjectMapper mapper = new ObjectMapper();
		//ConsultaDTO dados = mapper.readValue(payload, ConsultaDTO.class);
		ExameMQ dados = mapper.readValue(payload, ExameMQ.class);
		service.inserirExame(dados);
		LOG.info(dados.toString());
	}
	
}
