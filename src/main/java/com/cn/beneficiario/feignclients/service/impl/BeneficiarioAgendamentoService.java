package com.cn.beneficiario.feignclients.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.AgendamentoPageDTO;
import com.cn.beneficiario.feignclients.cnAgendamentoFeignClient;


@Service
public class BeneficiarioAgendamentoService {

	@Autowired(required = true)
	private cnAgendamentoFeignClient service;

	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioAgendamentoService.class);
	
	public AgendamentoPageDTO findAgendamentoBetweenComIDPage(int page, int limit, int id ,String start, String end)
			throws Exception {

		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<AgendamentoPageDTO> obj = Optional.ofNullable(service.findBeneficiarioAgendamentoComIdDataSolicitacao_page(page,limit,id,start,end).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}
	
}
