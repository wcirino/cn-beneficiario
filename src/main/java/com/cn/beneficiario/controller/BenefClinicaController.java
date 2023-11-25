package com.cn.beneficiario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api-benef")
public class BenefClinicaController {

	@GetMapping(value = "/")
	public ResponseEntity<?> findBeneficiario2() throws Exception {
	//	LOG.info("iniciando findBeneficiario");
		return new ResponseEntity<>("Novo teste 1",HttpStatus.OK);
	}
	
}
