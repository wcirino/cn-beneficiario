package com.cn.beneficiario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cn.beneficiario.dto.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	List<Estado> findByIdestado(int id);
}
