package com.cn.beneficiario.feignclients.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cn.beneficiario.dto.enums.Ativo;
import com.cn.beneficiario.dto.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "beneficiario")
public class BeneficiarioFeignDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idbenef;
	private Integer codbenef;
	private String nome_comp;
	private String cpfcnpj;
	private String RG;
	private Date data_nasc;
	private int idestado;
	private Integer cidade;
	private String telefone;
	private String celular;
	private String carteirinha;
	private Date data_cadas;
	private Sexo sexo;
	private Ativo ativo;
		
}
