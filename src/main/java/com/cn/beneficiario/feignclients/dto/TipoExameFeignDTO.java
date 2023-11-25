package com.cn.beneficiario.feignclients.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoExameFeignDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idtipoexame; 
	private String nome_exame;
	private Date datainsert;
	private float valor;

}
