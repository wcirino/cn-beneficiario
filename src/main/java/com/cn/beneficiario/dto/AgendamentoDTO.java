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
public class AgendamentoDTO {

	private Integer idagendamento;
	private int idprestador;
	private int idbenef;
	private Date datasolicitacao;
	private Date dataconsulta;
	private String statusAgendamento;
	
}
