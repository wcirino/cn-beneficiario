package com.cn.beneficiario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.ConsultaDTO;
import com.cn.beneficiario.feignclients.cnAgendamentoExameConsultaFeignClient;

@Service
public class BeneficiarioConsultaService {

	@Autowired
	private cnAgendamentoExameConsultaFeignClient consulta;
	
	public List<ConsultaDTO> BuscaConsultasAllService() throws Exception {
		List<ConsultaDTO> dto = consulta.findAllConsultas().getBody();
		return dto;
	}
	
	public ConsultaDTO BuscaConsultasIDService(int id) throws Exception {
		ConsultaDTO dto = consulta.findIDConsultas(id).getBody();
		return dto;
	}
}
