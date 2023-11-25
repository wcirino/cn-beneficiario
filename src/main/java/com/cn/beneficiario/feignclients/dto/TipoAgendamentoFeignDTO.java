package com.cn.beneficiario.feignclients.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoAgendamentoFeignDTO {

	private Integer idtipoagendamento; 
	private String nomeagendamento;
	private Date datacriacao;
	private String statusAgendamento;
	private float valor;
	private int tipo;
		
}
