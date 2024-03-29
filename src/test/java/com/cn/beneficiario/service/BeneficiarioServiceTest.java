package com.cn.beneficiario.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.dto.BeneficiarioPageDTO;
import com.cn.beneficiario.feignclients.cnCarteirinhaFeign;
import com.cn.beneficiario.repository.BeneficiarioRepository;
import com.cn.beneficiario.service.impl.BeneficiarioServiceImpl;

@ExtendWith(SpringExtension.class)
public class BeneficiarioServiceTest {

	@InjectMocks
	private BeneficiarioServiceImpl service;
	
	@Mock
	private BeneficiarioRepository repository;
	
	@MockBean
	private cnCarteirinhaFeign carteirinha;
	
	List<Beneficiario> listBenef;
	
	Beneficiario Benef1;
	Beneficiario Benef2;
	Beneficiario Benef5;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.Benef1 = this.criandoObjeto();
		this.Benef2 = this.criandoObjeto();
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
	
	@Test
	public void DeveInserirComSuscessoBeneficiario() throws Exception{
		
		Beneficiario benef = this.Benef1;
		Beneficiario benef3;
		
		benef.setIdbenef(null);
		Benef1.setIdbenef(null);
		
		when(repository.save(benef)).thenReturn(benef);

		benef3 = service.InsertBeneficiario(Benef1);

		assertEquals(benef3,benef);
	}
	
	@Test
	public void DeveUpdateBeneficiarioComSucesso() throws Exception{
		Beneficiario benef = this.Benef1;
		Beneficiario benef3;
		
		when(repository.save(benef)).thenReturn(benef);

		benef3 = service.UpdateBeneficiario(Benef1);

		assertEquals(benef3,benef);
	}

	@Test
	public void deveInserirAgendamentoErroDtoNull() throws Exception{
		Beneficiario benef4;
		
		this.Benef5 = this.criandoObjetoNull();
		benef4 = this.criandoObjetoNull();
		
		
		when(repository.save(Benef5)).thenReturn(benef4);

		Throwable exception = catchThrowable(() -> service.InsertBeneficiario(this.Benef5));
		
		assertThat(Benef5 == null);
		
		assertThat(exception)
        .isInstanceOf(Exception.class)
        .hasMessage("o beneficiario possui Id");
		
		verify(repository,never()).save(Benef5);
	}
	
	@Test
	public void deveInserirAgendamentoErroDtoComID() throws Exception{
		Beneficiario benef4;
		
		this.Benef5 = this.criandoObjeto();
		benef4 = this.criandoObjeto();
		
		
		when(repository.save(Benef5)).thenReturn(benef4);

		Throwable exception = catchThrowable(() -> service.InsertBeneficiario(this.Benef5));
		
		assertThat(Benef5.getIdbenef() != null);
		
		assertThat(exception)
        .isInstanceOf(Exception.class)
        .hasMessage("o beneficiario possui Id");
		
		verify(repository,never()).save(Benef5);
	}

	//O beneficiario não possui Id
	
	@Test
	public void deveUpdateBeneficiarioErroDtoNull() throws Exception{
		Beneficiario benef4;
		
		this.Benef5 = this.criandoObjetoNull();
		benef4 = this.criandoObjetoNull();
		
		
		when(repository.save(Benef5)).thenReturn(benef4);

		Throwable exception = catchThrowable(() -> service.UpdateBeneficiario(this.Benef5));
		
		assertThat(Benef5 == null);
		
		assertThat(exception)
        .isInstanceOf(Exception.class)
        .hasMessage("O beneficiario não possui Id");
				
		verify(repository,never()).save(Benef5);
	}
	
	@Test
	public void deveUpdateBeneficiarioErroDtoNullID() throws Exception{
		Beneficiario benef4;
		
		this.Benef5 = this.criandoObjeto();
		benef4 = this.criandoObjeto();
		
		Benef5.setIdbenef(null);
		benef4.setIdbenef(null);
		
		
		when(repository.save(Benef5)).thenReturn(benef4);

		Throwable exception = catchThrowable(() -> service.UpdateBeneficiario(this.Benef5));
		
		assertThat(Benef5.getIdbenef() == null);
		
		assertThat(exception)
        .isInstanceOf(Exception.class)
        .hasMessage("O beneficiario não possui Id");
		
		verify(repository,never()).save(Benef5);
	}
	
	@Test
	public void DeveBuscarAllBeneficiarioPage() throws Exception{
	
		
		//Page<Company> pagedResponse = new PageImpl(companies);
        Pageable pg = PageRequest.of(0, 10);
        List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
        Page<Beneficiario> pgresponse = new PageImpl<Beneficiario>(beneficiarios);
		when(repository.findAll(pg)).thenReturn(pgresponse);
		
		BeneficiarioPageDTO pgResponse2 = service.findAll_beneficiario_page(pg);
       
		assertThat(pgResponse2.getTotalPages() > 0);
	} 
	
	@Test
	public void DeveGerarCarteirinha() throws Exception{

		String numCart = "123456789";
		String numCart2;
		when(carteirinha.GerarCarteirinha().getBody()).thenReturn(numCart);
		numCart2 = service.gerarCarteirinha();

		assertEquals(numCart,numCart2);
	}
	
	/*
	 * @Test public void DeveGerarCarterinha() { String numCart = "0123456789";
	 * 
	 * }
	 */
	
	/*
	 * private void buildFeignClient(MockClient mockClient) { feignCart =
	 * Feign.builder() .client(mockClient) .encoder(new JacksonEncoder())
	 * .decoder(new JacksonDecoder()) .contract(new SpringMvcContract())
	 * .target(PostClient.class, "localhost:8080"); }
	 */
	
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
