package com.cn.beneficiario.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.beneficiario.dto.ExameDTO;
import com.cn.beneficiario.dto.ExamePageDTO;

@Component
@FeignClient(contextId = "exame-benef",value = "cn-agendamento-exame-consulta", path ="/api-exame")
public interface cnExamefeignClient {

	@GetMapping(value = "/exame-beneficiario-page/")
	public ResponseEntity<ExamePageDTO> findBeneficiarioExameComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception;
	
	@GetMapping(value = "/exame-beneficiario")
	public ResponseEntity<Page<ExameDTO>> findBeneficiarioExame(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idexame,
			@RequestParam(required = false) Integer tipoexame
	) throws Exception;
	
	@GetMapping(value = "/exame-beneficiario-all")
	public ResponseEntity<?> findBeneficiarioExameAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idexame,
			@RequestParam(required = false) Integer tipoexame
	) throws Exception;
	
}
