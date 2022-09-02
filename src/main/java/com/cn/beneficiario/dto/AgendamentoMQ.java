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
@Table(name="agendamento")
public class AgendamentoMQ {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	Integer id ;
	
	@Column(name = "idagendamento")
	Integer idagendamento;
	
	@Column(name = "idtipoagendamento")
	Integer idtipoagendamento;
	
	@Column(name = "idbenef")
	Integer idbenef;
	
	@Column(name = "dataagendamento")
	Date dataagendamento;
	
}
