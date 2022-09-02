package com.cn.beneficiario.repository;

import java.util.Date;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cn.beneficiario.dto.AgendamentoMQ;

@Repository
public interface BeneficiarioAgendamentoMQRepository extends JpaRepository<AgendamentoMQ, Integer> {

	Page<AgendamentoMQ> findBydataagendamentoBetweenAndIdagendamento(Date dt1,Date dt2,int id,Pageable page);
	AgendamentoMQ save(int id);
}
