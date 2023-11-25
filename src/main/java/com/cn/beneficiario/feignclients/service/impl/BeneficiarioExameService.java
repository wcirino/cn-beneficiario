package com.cn.beneficiario.feignclients.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.ExameDTO;
import com.cn.beneficiario.dto.ExamePageDTO;
import com.cn.beneficiario.feignclients.cnExamefeignClient;
import com.cn.beneficiario.feignclients.dto.ExameFeignDTO;

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
	
	public Page<ExameFeignDTO> findExamePage(int page,int limit,String carteirinha,Integer codbenef,String startdt,String enddt,Integer idexame,Integer tipoexame) throws Exception {

		LOG.info("Inicio chamada do microservico findBeneficia Dinamica");
		Page<ExameFeignDTO> obj = (Page<ExameFeignDTO>) service.findBeneficiarioExame(page, limit, carteirinha, codbenef, startdt, enddt, idexame, tipoexame);
		LOG.info("Fim findconsultaBetween");
		return obj;// obj.orElseThrow(() -> new Exception());
	}
	
	public List<ExameFeignDTO> findExameList(int page,int limit,String carteirinha,Integer codbenef,String startdt,String enddt,Integer idexame,Integer tipoexame) throws Exception {

		LOG.info("Inicio chamada do microservico findBeneficia Dinamica");
		Optional<List<ExameFeignDTO>> obj = (Optional<List<ExameFeignDTO>>) Optional.ofNullable(service.findBeneficiarioExameAll(page, limit, carteirinha, codbenef, startdt, enddt, idexame, tipoexame).getBody());
		LOG.info("Fim findconsultaBetween");
		return  obj.orElseThrow(() -> new Exception());
	}
	
}
