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
@Table(name = "exame")
public class ExameFeignDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idexame;
	private TipoExameFeignDTO idtipoexame;
	private PrestadorFeignDTO idprestador;
	private BeneficiarioFeignDTO idbenef;
	private Date datasolicitacao; 
	private Date dataconsulta;
	private String statusexame;

	
}
