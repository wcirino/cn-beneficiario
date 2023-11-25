package com.cn.beneficiario.feignclients.dto;

import javax.persistence.Entity;

import com.cn.beneficiario.dto.enums.SexoPrestador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorFeignDTO {
	
	private int idPrest;
	private String nome;
	private SexoPrestador sexo;
	private int cidade;
	private int estados;
	private String statusPrest;	
	
}
