package com.cn.beneficiario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.beneficiario.dto.ConsultaDTO;
import com.cn.beneficiario.service.impl.BeneficiarioConsultaService;

@RestController
@RequestMapping(value = "/api-beneficiario-consulta")
public class BeneficiarioConsultaController {

	@Autowired
	private BeneficiarioConsultaService consulta;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioConsultaController.class);
	
	@GetMapping(value = "/busca-All-consultas")
	public ResponseEntity<?> FindAllConsulta() throws Exception{
		LOG.info("Buscando na api-cn-Consultas");
		List<ConsultaDTO> consultas = consulta.BuscaConsultasAllService();
		return  new ResponseEntity<>(consultas,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-consulta-id/{id}")
	public ResponseEntity<?> FindAIDConsulta(@PathVariable int id) throws Exception{
		LOG.info("Buscando FindAIDConsulta  na  api-cn-Consultas");
		ConsultaDTO consultas = consulta.BuscaConsultasIDService(id);
		return  new ResponseEntity<>(consultas,HttpStatus.OK);
	}
		
}
