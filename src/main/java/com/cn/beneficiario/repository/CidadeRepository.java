package com.cn.beneficiario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cn.beneficiario.dto.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

	List<Cidade> findByIdestado(int id);
	
}
