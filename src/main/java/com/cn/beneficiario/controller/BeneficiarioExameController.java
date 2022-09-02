package com.cn.beneficiario.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.beneficiario.dto.ExamePageDTO;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioExameService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "beneficiario Exame", description = "Exame medicas", tags = {"Exame beneficiario EndPoint"})
@RestController
@RequestMapping(value ="/api-beneficiario-exame")
public class BeneficiarioExameController {

	@Autowired
	private BeneficiarioExameService service;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioController.class);
	
	@ApiOperation(value ="exame paginada com beneficiario e sem id all")
	@GetMapping(value = "/exame-beneficiario-page/")
	public ResponseEntity<?> findBeneficiarioExameComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{
		
        LOG.info("exame paginada com beneficiario e seu id all");	
	
		ExamePageDTO exame = service.findExameBetweenIDPage(page, limit, id, startdt, enddt);
		LOG.info("fim exame paginada com beneficiario e seu id all");
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}
	
}
