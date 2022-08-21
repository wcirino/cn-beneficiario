package com.cn.beneficiario.service;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.repository.BeneficiarioRepository;
import com.cn.beneficiario.service.impl.BeneficiarioServiceImpl;

@ExtendWith(SpringExtension.class)
public class BeneficiarioServiceTest {

	@InjectMocks
	private BeneficiarioServiceImpl service;
	
	@Mock
	private BeneficiarioRepository repository;
	
	List<Beneficiario> listBenef;
	
	Beneficiario Benef1;
	Beneficiario Benef2;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.Benef1 = this.criandoObjeto();
		this.listBenef = this.criandoListObjeto();
	}
	
	@Test
	public void devePesquisarTodosBeneficiarios() throws Exception{
		
		List<Beneficiario> listabeneficiario = this.criandoListObjeto();
		when(repository.findAll()).thenReturn(listabeneficiario);
		List<Beneficiario> lista =  service.findAll_beneficiario();
		 		
		assertTrue(lista.size() > 0);
		
	}
	
	@Test
	public void devePesquisarPorIDBeneficiario() throws Exception {
		int id = 1;
		Beneficiario dto = this.criandoObjeto();
		when(repository.findByIdbenef(id)).thenReturn(dto);
		Beneficiario obj = service.find_beneficiario_id(id);
		
		assertEquals(dto,obj);
	}
	
	private Beneficiario criandoObjeto() {
		return Beneficiario.builder()
				.ativo("S")
				.carteirinha("1111111111111111111")
				.celular("11-1111111111")
				.cidade(25)
				.cpfcnpj("11111111111")
				.data_cadas(null)
				.data_nasc(null)
				.idbenef(1)
				.idestado(1)
				.nome_comp("Nome")
				.RG("111111111111111111")
				.sexo(1)
				.telefone("111111111111111").build();
	}
				
	private Beneficiario criandoObjetoNull() {
		return null;
	}
	
	
	private List<Beneficiario> criandoListObjeto() {
		return asList(Beneficiario.builder().ativo("S").carteirinha("1111111111111111111").celular("11-1111111111")
				.cidade(25).cpfcnpj("11111111111").data_cadas(null).data_nasc(null).idbenef(1).idestado(1)
				.nome_comp("Nome").RG("111111111111111111").sexo(1).telefone("111111111111111").build(),
				Beneficiario.builder().ativo("S").carteirinha("1111111111111111111").celular("11-1111111111")
				.cidade(25).cpfcnpj("11111111111").data_cadas(null).data_nasc(null).idbenef(1).idestado(1)
				.nome_comp("Nome").RG("111111111111111111").sexo(1).telefone("111111111111111").build(),
				Beneficiario.builder().ativo("S").carteirinha("1111111111111111111").celular("11-1111111111")
				.cidade(25).cpfcnpj("11111111111").data_cadas(null).data_nasc(null).idbenef(1).idestado(1)
				.nome_comp("Nome").RG("111111111111111111").sexo(1).telefone("111111111111111").build(),
				Beneficiario.builder().ativo("S").carteirinha("1111111111111111111").celular("11-1111111111")
				.cidade(25).cpfcnpj("11111111111").data_cadas(null).data_nasc(null).idbenef(1).idestado(1)
				.nome_comp("Nome").RG("111111111111111111").sexo(1).telefone("111111111111111").build());
	}	
}
