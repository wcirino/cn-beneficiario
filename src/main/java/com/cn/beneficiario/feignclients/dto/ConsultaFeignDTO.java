package com.cn.beneficiario.feignclients.dto;

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
@Table(name = "consultas")
public class ConsultaFeignDTO {

	private Integer idconsulta;
	private PrestadorFeignDTO codprestador;
	private BeneficiarioFeignDTO codbenef;
	private Date dataconsulta;
	private Date datasolicitacao;
	private TipoConsultaFeignDTO tipoconsulta;
	private  String status;
	
}
