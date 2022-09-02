package com.cn.beneficiario.repository;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cn.beneficiario.dto.ConsultaMQ;

@Repository
public interface BeneficiarioConsultaMQRepository extends JpaRepository<ConsultaMQ, Integer>{

	Page<ConsultaMQ> findBydataconsultaBetweenAndIdconsulta(Date dt1,Date dt2,int id,Pageable page);
	ConsultaMQ save(int id);
}
