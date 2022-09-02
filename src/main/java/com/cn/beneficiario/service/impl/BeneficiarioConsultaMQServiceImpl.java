package com.cn.beneficiario.service.impl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.ConsultaMQ;
import com.cn.beneficiario.repository.BeneficiarioConsultaMQRepository;
import com.cn.beneficiario.service.BeneficiarioConsultaMQService;

@Service
public class BeneficiarioConsultaMQServiceImpl implements BeneficiarioConsultaMQService {

	@Autowired
	private BeneficiarioConsultaMQRepository repository;
	
	@Override
	public ConsultaMQ findAllConsultaPageTipoConsulta(int id, Date dtstart, Date dtend, int idtipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultaMQ FindAllConsultaPage(int id, Date dtstart, Date dtend, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultaMQ InserirConsultaMQ(ConsultaMQ dto) throws Exception{
		if(dto !=  null && dto.getId() == null) {
			return repository.save(dto);
		}
		else {
			throw new Exception("Erro ao salvar arquivo RabbitMQ");
		}
	}

}
