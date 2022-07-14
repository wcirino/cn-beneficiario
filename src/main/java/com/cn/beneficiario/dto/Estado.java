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
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idestado")
	private int idestado;
	
	@Column(name = "estado")
	private String estado;
	
}
