package com.cn.beneficiario.dto;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idcidade")
	private int idcidade;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "idestado")
	private int idestado;
	
}
