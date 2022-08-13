package com.cn.beneficiario.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(contextId = "carteirinha-benef", value = "cn-cart-token", path ="/api-carteira")
public interface cnCarteirinhaFeign {

	@GetMapping(value ="/gerar-carteirinha")
	public ResponseEntity<String> GerarCarteirinha() throws Exception;
	
}
