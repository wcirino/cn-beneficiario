package com.cn.beneficiario.service;

import java.util.Date;

import org.springframework.data.domain.Pageable;
import com.cn.beneficiario.dto.ConsultaMQ;

public interface BeneficiarioConsultaMQService {

	public ConsultaMQ FindAllConsultaPage(int id, Date dtstart, Date dtend, Pageable page);
	public ConsultaMQ findAllConsultaPageTipoConsulta(int id, Date dtstart, Date dtend,int idtipo);
	public ConsultaMQ InserirConsultaMQ(ConsultaMQ dto) throws Exception;
	
}
