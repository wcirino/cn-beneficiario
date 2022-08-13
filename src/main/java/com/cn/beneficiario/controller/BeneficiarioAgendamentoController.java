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

import com.cn.beneficiario.dto.AgendamentoPageDTO;
import com.cn.beneficiario.service.impl.BeneficiarioAgendamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "beneficiario agendamento", description = "agendamento beneficiario", tags = {"Agendamento beneficiario EndPoint"})
@RestController
@RequestMapping(value ="/api-beneficiario-agendamento")
public class BeneficiarioAgendamentoController {

	@Autowired
	private BeneficiarioAgendamentoService service;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioAgendamentoController.class);
	
	@ApiOperation(value ="agendamento paginada com beneficiario e sem id all")
	@GetMapping(value = "/agendamento-beneficiario-id-page/")
	public ResponseEntity<?> findBeneficiarioAgendamentoComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{

        LOG.info("Consulta paginada com beneficiario e seu id all");
		
		AgendamentoPageDTO agenda = service.findAgendamentoBetweenComIDPage(page, limit, id, startdt, enddt);
		LOG.info("fim Consulta paginada com beneficiario e seu id all");
		return new ResponseEntity<>(agenda,HttpStatus.OK);
	}
	
}
