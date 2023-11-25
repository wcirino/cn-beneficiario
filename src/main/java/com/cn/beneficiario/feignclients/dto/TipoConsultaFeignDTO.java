package com.cn.beneficiario.feignclients.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoConsultaFeignDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idtipoconsulta; 
	private String nome_consulta;
	private Date datainsert;
	private float valor;
	
}
