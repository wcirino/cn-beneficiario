package com.cn.beneficiario.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaDTO {

	private Integer idconsulta;
	private Integer codprestador;
	private Integer codbenef;
	private Date dataconsulta;
	private Date datasolicitacao;
	private Integer tipoconsulta;
	private String status;
	
}
