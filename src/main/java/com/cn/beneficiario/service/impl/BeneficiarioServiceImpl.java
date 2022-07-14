package com.cn.beneficiario.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.repository.BeneficiarioRepository;


@Service
public class BeneficiarioServiceImpl {

	@Autowired
	private BeneficiarioRepository repository; 
		
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
		if(!repository.existsById(dto.getIdbenef())) {
			LOG.info("Pegando dados InsertBeneficiario");
			dto.setData_cadas(new Date(System.currentTimeMillis()));
			dto.setCarteirinha("");
			LOG.info("inserindo InsertBeneficiario");
			Beneficiario obj = repository.save(dto);
			LOG.info("retornando InsertBeneficiario");
			return obj;
		}
		else {
			throw new Exception("o beneficiario possui Id");
		}
	}
	
	public Beneficiario UpdateBeneficiario(Beneficiario dto) throws Exception{
		LOG.info("iniciando UpdateBeneficiario");
		if(repository.existsById(dto.getIdbenef())) {
			LOG.info("UpdateBeneficiario");
			Beneficiario obj = repository.save(dto);
			LOG.info("retornando UpdateBeneficiario");
			return obj;
		}
		else {
			throw new Exception("o beneficiario não possui Id");
		}
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
