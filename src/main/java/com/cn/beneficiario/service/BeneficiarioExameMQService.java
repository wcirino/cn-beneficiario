package com.cn.beneficiario.service;

import java.util.Date;

import com.cn.beneficiario.dto.AgendamentoMQ;
import com.cn.beneficiario.dto.ExameMQ;

public interface BeneficiarioExameMQService {

	public ExameMQ FindAllExamePage(int id, Date dtstart, Date dtend);
	public ExameMQ findAllExamePageTipoExame(int id, Date dtstart, Date dtend,int idtipo);
	public ExameMQ inserirExame(ExameMQ exame)throws Exception;
}
