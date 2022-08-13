package com.cn.beneficiario.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
}
