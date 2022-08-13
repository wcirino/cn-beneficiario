package com.cn.beneficiario.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cn.beneficiario.dto.ConsultaDTO;

@Component
@FeignClient(contextId = "consulta-benf",value = "cn-agendamento-exame-consulta", path ="/api-consulta")
public interface cnAgendamentoExameConsultaFeignClient {

	@GetMapping(value = "/consulta-all")
	ResponseEntity<List<ConsultaDTO>> findAllConsultas() throws Exception;

	@GetMapping(value = "/consulta-id/{id}")
	public ResponseEntity<ConsultaDTO> findIDConsultas(@PathVariable int id) throws Exception;
}
