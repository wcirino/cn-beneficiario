package com.cn.beneficiario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cn.beneficiario.dto.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

	List<Cidade> findByIdestado(int id);
	List<Cidade> findAll();
	
	@Query(value = "SELECT * FROM cidade c where c.idestado = :idcid", nativeQuery = true)
	List<Cidade> getcidades(@Param("idcid") Integer idCidade);
	
}
