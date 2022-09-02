package com.cn.beneficiario.dto;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="consulta")
public class ConsultaMQ {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	Integer id ;
	
	@Column(name = "idconsulta")
	Integer idconsulta;
	
	@Column(name = "idtipoconsulta")
	Integer idtipoconsulta;
	
	@Column(name = "idbenef")
	Integer idbenef;
	
	@Column(name = "dataconsulta")
	Date dataconsulta;
	
}
