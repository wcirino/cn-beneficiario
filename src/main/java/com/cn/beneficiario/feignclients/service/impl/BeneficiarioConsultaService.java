package com.cn.beneficiario.feignclients.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
//	public Page<ConsultaDTO> BeneficiarioConsultaDinamic(Integer page,Integer limit, String carteirinha,
//			Integer codbenef, String startdt, String enddt, Integer idconsulta, Integer tipoConsuilta){
//		
//		
//		ResponseEntity<?> responseEntity = consulta.find_Beneficiario_ConsultaAll(page,limit, carteirinha, codbenef, startdt, enddt, idconsulta, tipoConsuilta).getBody();
//
//	}
}
