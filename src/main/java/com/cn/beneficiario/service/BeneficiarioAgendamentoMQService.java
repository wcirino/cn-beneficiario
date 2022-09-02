package com.cn.beneficiario.service;

import java.util.Date;

import com.cn.beneficiario.dto.AgendamentoMQ;

public interface BeneficiarioAgendamentoMQService {

	public AgendamentoMQ FindAllAgendamentoPage(int id, Date dtstart, Date dtend);
	public AgendamentoMQ findAllAgendamentoPageTipoAgendamento(int id, Date dtstart, Date dtend,int idtipo);
	public AgendamentoMQ inserirAgendamento(AgendamentoMQ agenda) throws Exception;
}
