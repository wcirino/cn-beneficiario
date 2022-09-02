package com.cn.beneficiario.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.cn.beneficiario.dto.AgendamentoMQ;
import com.cn.beneficiario.repository.BeneficiarioAgendamentoMQRepository;
import com.cn.beneficiario.service.BeneficiarioAgendamentoMQService;

public class BeneficiarioAgendamentoMQServiceImpl implements BeneficiarioAgendamentoMQService{
	
	@Autowired
	private BeneficiarioAgendamentoMQRepository repository;

	@Override
	public AgendamentoMQ FindAllAgendamentoPage(int id, Date dtstart, Date dtend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgendamentoMQ findAllAgendamentoPageTipoAgendamento(int id, Date dtstart, Date dtend, int idtipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgendamentoMQ inserirAgendamento(AgendamentoMQ agenda) throws Exception {
		if(agenda !=  null && agenda.getId() == null) {
			return repository.save(agenda);
		}
		else {
			throw new Exception("Erro ao salvar arquivo RabbitMQ");
		}
	}

}
