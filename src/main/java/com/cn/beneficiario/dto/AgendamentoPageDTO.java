package com.cn.beneficiario.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendamentoPageDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<AgendamentoDTO> lista_consulta;
	private Long totalElements;
	private Long totalPages;
	private Long size;
	private Long pageNumber;	
	
}
