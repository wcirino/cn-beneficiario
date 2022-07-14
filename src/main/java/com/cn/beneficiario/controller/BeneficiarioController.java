package com.cn.beneficiario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.service.impl.BeneficiarioServiceImpl;

@RestController
@RequestMapping(value = "api-beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceImpl proxyBenef;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioController.class);
	
	@GetMapping(value = "/beneficiario/{id}")
	public ResponseEntity<?> findBeneficiario(@PathVariable int id) throws Exception {
		LOG.info("iniciando findBeneficiario");
		return new ResponseEntity<>(proxyBenef.find_beneficiario_id(id),HttpStatus.OK);
	}
		
	@GetMapping(value = "/beneficiarios")
	public ResponseEntity<?> findAllBeneficiarios() throws Exception{
		LOG.info("iniciando findAllBeneficiarios");
		List<Beneficiario> benef = proxyBenef.findAll_beneficiario();
		LOG.info("fim findAllBeneficiarios");
		return new ResponseEntity<>(benef,HttpStatus.OK);
	}

	
	@PostMapping(value = "/beneficiario")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody Beneficiario dto)throws Exception{
		LOG.info("iniciando InsertBeneficiario");
		return new  ResponseEntity<>(proxyBenef.InsertBeneficiario(dto),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/beneficiario")
	public  ResponseEntity<?> UpdateBeneficiario(@RequestBody Beneficiario dto) throws Exception{
		LOG.info("iniciando InsertBeneficiario");
		return new ResponseEntity<>(proxyBenef.UpdateBeneficiario(dto),HttpStatus.OK);
	}
	
}
