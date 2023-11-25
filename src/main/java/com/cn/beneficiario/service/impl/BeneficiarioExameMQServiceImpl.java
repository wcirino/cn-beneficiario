package com.cn.beneficiario.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cn.beneficiario.dto.ExameMQ;
import com.cn.beneficiario.repository.BeneficiarioExameMQRepository;
import com.cn.beneficiario.service.BeneficiarioExameMQService;

@Service
public class BeneficiarioExameMQServiceImpl implements BeneficiarioExameMQService{

	private BeneficiarioExameMQRepository repository;
	
	@Override
	public ExameMQ FindAllExamePage(int id, Date dtstart, Date dtend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExameMQ findAllExamePageTipoExame(int id, Date dtstart, Date dtend, int idtipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExameMQ inserirExame(ExameMQ exame) throws Exception {
		if(exame !=  null && exame.getId() == null) {
		// repository.SaveEmaxeSQL(exame.getDataexame(), exame.getIdbenef(), exame.getIdexame(), exame.getIdtipoexame());
		 return exame;
		}
		else {
			throw new Exception("Erro ao salvar arquivo RabbitMQ");
		}
	}

}
