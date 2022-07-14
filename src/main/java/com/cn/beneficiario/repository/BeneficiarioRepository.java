package com.cn.beneficiario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cn.beneficiario.dto.Beneficiario;

public interface BeneficiarioRepository extends  JpaRepository<Beneficiario, Integer> {

	Beneficiario findByIdbenef(int id);
	Beneficiario save(int id);
}
