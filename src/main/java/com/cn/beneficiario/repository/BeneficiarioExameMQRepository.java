package com.cn.beneficiario.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cn.beneficiario.dto.ExameMQ;

@Repository
public interface BeneficiarioExameMQRepository extends JpaRepository<ExameMQ, Integer>{

	Page<ExameMQ> findBydataexameBetweenAndIdexame(Date dt1,Date dt2,int id,Pageable page);
	ExameMQ save(int id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO EXAME (dataexame,idbenef,idexame,idtipoexame) VALUES (:dataexame,:idbenef,:idexame,:idtipoexame)", nativeQuery = true)
	void SaveEmaxeSQL(@Param("dataexame") Date dataexame,
	 				   @Param("idexame") Integer idexame,
	 				   @Param("idbenef") Integer idbenef,
	 				   @Param("idtipoexame") Integer idtipoexame);
	
}
