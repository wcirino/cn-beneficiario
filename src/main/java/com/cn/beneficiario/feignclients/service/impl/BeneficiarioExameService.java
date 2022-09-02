package com.cn.beneficiario.feignclients.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.ExamePageDTO;
import com.cn.beneficiario.feignclients.cnExamefeignClient;

@Service
public class BeneficiarioExameService {

	@Autowired
	private cnExamefeignClient service;
		
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioExameService.class);
	
	public ExamePageDTO findExameBetweenIDPage(int page,int limit, int id, String start, String end) throws Exception{	
		
		LOG.info("Inicio chamada do microservico findconsultaBetween");
		Optional<ExamePageDTO> obj = Optional.ofNullable(service.findBeneficiarioExameComIdDataSolicitacao_page(page, limit,id,start,end).getBody());
		LOG.info("Fim findconsultaBetween");
		return obj.orElseThrow(() -> new Exception());
	}
	
	
}
