package com.cn.beneficiario.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExameDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idexame;
	private int idprestador; 
	private int idbenef;
	private Date datasolicitacao; 
	private Date dataconsulta;
	private Integer statusexame;

	
}
