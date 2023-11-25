package com.cn.beneficiario.feignclients.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.ConsultaDTO;
import com.cn.beneficiario.feignclients.cnAgendamentoExameConsultaFeignClient;
import com.cn.beneficiario.feignclients.dto.ConsultaFeignDTO;

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
	
	public List<ConsultaFeignDTO> findConsultaList(int page,int limit,String carteirinha,Integer codbenef,String startdt,String enddt,Integer idexame,Integer tipoexame) throws Exception {

		//LOG.info("Inicio chamada do microservico findBeneficia Dinamica");
		Optional<List<ConsultaFeignDTO>> obj = (Optional<List<ConsultaFeignDTO>>) Optional.ofNullable(consulta.find_Beneficiario_Consulta(page, limit, carteirinha, codbenef, startdt, enddt, idexame, tipoexame).getBody());
		//LOG.info("Fim findconsultaBetween");
		return  obj.orElseThrow(() -> new Exception());
	}
	
}
