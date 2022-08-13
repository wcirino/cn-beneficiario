package com.cn.beneficiario.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeneficiarioPageDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Beneficiario> lista_consulta;
	private long totalElements;
	private long totalPages;
	private long size;
	private long pageNumber;
	
}
