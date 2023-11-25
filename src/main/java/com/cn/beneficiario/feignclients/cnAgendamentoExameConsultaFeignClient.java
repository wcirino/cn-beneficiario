package com.cn.beneficiario.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.beneficiario.dto.ConsultaDTO;
import com.cn.beneficiario.feignclients.dto.ConsultaFeignDTO;

@Component
@FeignClient(contextId = "consulta-benf",value = "cn-agendamento-exame-consulta", path ="/api-consulta")
public interface cnAgendamentoExameConsultaFeignClient {

	@GetMapping(value = "/consulta-all")
	ResponseEntity<List<ConsultaDTO>> findAllConsultas() throws Exception;

	@GetMapping(value = "/consulta-id/{id}")
	public ResponseEntity<ConsultaDTO> findIDConsultas(@PathVariable int id) throws Exception;
	
	
	@GetMapping(value = "/consulta-beneficiario")
	public ResponseEntity<List<ConsultaFeignDTO>> find_Beneficiario_Consulta(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idconsulta,
			@RequestParam(required = false) Integer tipoConsuilta
	) throws Exception;
	

}
