package com.cn.beneficiario.feignclients.dto;

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
public class AgendamentoFeignDTO {

	private Integer idagendamento;
	private TipoAgendamentoFeignDTO idtipoagendamento;
	private PrestadorFeignDTO prestador;
	private BeneficiarioFeignDTO idbenef;
	private Date datasolicitacao;
	private Date dataconsulta;
	private String statusAgendamento;
	
}
