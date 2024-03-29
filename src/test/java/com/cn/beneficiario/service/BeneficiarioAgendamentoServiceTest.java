package com.cn.beneficiario.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cn.beneficiario.dto.AgendamentoPageDTO;
import com.cn.beneficiario.feignclients.cnAgendamentoFeignClient;

@ExtendWith(SpringExtension.class)
public class BeneficiarioAgendamentoServiceTest {

	@InjectMocks
	private com.cn.beneficiario.feignclients.service.impl.BeneficiarioAgendamentoService service;
	
	@Mock
	private cnAgendamentoFeignClient repository;
	
	/*
	 * @Test public void deveBuscarTodosAgendamentosIDData() throws Exception{
	 * 
	 * AgendamentoPageDTO obj = this.preenchendoObjeto();
	 * when(repository.findBeneficiarioAgendamentoComIdDataSolicitacao_page(0, 0, 0,
	 * null, null).getBody()).thenReturn(obj); AgendamentoPageDTO dto =
	 * service.findAgendamentoBetweenComIDPage(0, 0, 0, null, null); assertTrue(dto
	 * == null); }
	 */
	
	public AgendamentoPageDTO preenchendoObjeto() {
		return AgendamentoPageDTO.builder()
		.pageNumber(5L)
		.totalElements(5L)
		.totalPages(5L)
		.lista_consulta(null)
		.build();
	}
	
	public AgendamentoPageDTO preenchendoObjetoNull() {
		return AgendamentoPageDTO.builder()
		.pageNumber(null)
		.totalElements(null)
		.totalPages(null)
		.lista_consulta(null)
		.build();
	}
	
}
