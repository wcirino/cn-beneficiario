package com.cn.beneficiario.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.dto.BeneficiarioPageDTO;
import com.cn.beneficiario.feignclients.cnCarteirinhaFeign;
import com.cn.beneficiario.repository.BeneficiarioRepository;


@Service
public class BeneficiarioServiceImpl {

	@Autowired
	private BeneficiarioRepository repository; 
		
	@Autowired
	private cnCarteirinhaFeign carteirinha;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioServiceImpl.class);
	
	public Beneficiario find_beneficiario_id(int id) throws Exception{
		LOG.info("Iniciando find_beneficiario_id");
		Optional<Beneficiario> obj = Optional.ofNullable(repository.findByIdbenef(id));
		LOG.info("Fim find_beneficiario_id");
		return obj.orElseThrow(() -> new Exception("Algo deu errado"));
	}
	
	public List<Beneficiario> findAll_beneficiario() throws Exception{
		LOG.info("iniciando findAll_beneficiario");
		Optional<List<Beneficiario>> obj = Optional.ofNullable(repository.findAll());
		LOG.info("Fim findAll_beneficiario");
		return obj.orElseThrow(() -> new Exception("algo deu errado"));
	}
			
	public Beneficiario InsertBeneficiario(Beneficiario dto) throws Exception{
		LOG.info("iniciando InsertBeneficiario");
		if(dto == null || dto.getIdbenef() != null){
			throw new Exception("o beneficiario possui Id");
		}
		else {
			LOG.info("Pegando dados InsertBeneficiario");
			dto.setData_cadas(new Date(System.currentTimeMillis()));
			dto.setCarteirinha(this.gerarCarteirinha());
			LOG.info("inserindo InsertBeneficiario");
			Beneficiario obj = repository.save(dto);
			LOG.info("retornando InsertBeneficiario");
			return obj;
		}
	}
	
	public Beneficiario UpdateBeneficiario(Beneficiario dto) throws Exception{
		LOG.info("iniciando UpdateBeneficiario");
		if(dto == null || dto.getIdbenef() == null){
			throw new Exception("O beneficiario não possui Id");
		}
		else {
			LOG.info("UpdateBeneficiario");
			Beneficiario obj = repository.save(dto);
			LOG.info("retornando UpdateBeneficiario");
			return obj;
		}
	}
	
	public BeneficiarioPageDTO findAll_beneficiario_page(Pageable page) throws Exception{
		LOG.info("iniciando findAll_beneficiario");
		Optional<Page<Beneficiario>> obj = Optional.ofNullable(repository.findAll(page));
		BeneficiarioPageDTO dto = new BeneficiarioPageDTO(obj.get().getContent(), obj.get().getTotalElements(),
														  obj.get().getTotalPages(), obj.get().getSize(),
				                                          obj.get().getNumberOfElements());
		LOG.info("Fim findAll_beneficiario");
		return dto;
	}
	
    public String gerarCarteirinha() throws Exception {
    	return carteirinha.GerarCarteirinha().getBody();
    }
	
	/*
	 * private benefConsultaDTO beneficiariomodelMapperOne(Beneficiario dto) {
	 * benefConsultaDTO consult = m.map(dto, benefConsultaDTO.class); return
	 * consult; }
	 * 
	 * private List<benefConsultaDTO> beneficiarioModelMapperList(List<Beneficiario>
	 * dto){ return dto.stream().map(obj ->
	 * beneficiariomodelMapperOne(obj)).collect(Collectors.toList()); }
	 */
}
