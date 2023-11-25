package com.cn.beneficiario.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.beneficiario.dto.AgendamentoDTO;
import com.cn.beneficiario.dto.AgendamentoPageDTO;

@Component
@FeignClient(contextId = "agendamento-benf", value = "cn-agendamento-exame-consulta", path ="/api-agendamento")
public interface cnAgendamentoFeignClient {

	@GetMapping(value = "/agendamento-beneficiario-id-page/")
	public ResponseEntity<AgendamentoPageDTO> findBeneficiarioAgendamentoComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception;
	
	@GetMapping(value = "/agendamento-beneficiario-all")
	public ResponseEntity<List<AgendamentoDTO>> findBeneficiarioAgendamentoAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idagendamento,
			@RequestParam(required = false) Integer idtipoagendamento
	) throws Exception;
	
}
