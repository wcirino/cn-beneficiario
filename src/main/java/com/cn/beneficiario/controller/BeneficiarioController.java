package com.cn.beneficiario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.beneficiario.dto.AgendamentoDTO;
import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.dto.ConsultaDTO;
import com.cn.beneficiario.dto.ExameDTO;
import com.cn.beneficiario.feignclients.dto.AgendamentoFeignDTO;
import com.cn.beneficiario.feignclients.dto.ConsultaFeignDTO;
import com.cn.beneficiario.feignclients.dto.ExameFeignDTO;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioAgendamentoService;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioConsultaService;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioExameService;
import com.cn.beneficiario.repository.CidadeRepository;
import com.cn.beneficiario.repository.EstadoRepository;
import com.cn.beneficiario.service.impl.BeneficiarioServiceImpl;

@RestController
@RequestMapping(value = "/api-beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceImpl proxyBenef;
	
	@Autowired
	private BeneficiarioAgendamentoService service;
	
	@Autowired
	private BeneficiarioConsultaService consulta;
	
	@Autowired
	private BeneficiarioExameService exame;
	
	@Autowired
	private EstadoRepository utilEstado;
	
	@Autowired
	private CidadeRepository utilCidade;	
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioController.class);
	
	@GetMapping(value = "/beneficiario/{id}")
	public ResponseEntity<?> findBeneficiario(@PathVariable int id) throws Exception {
		LOG.info("iniciando findBeneficiario");
		return new ResponseEntity<>(proxyBenef.find_beneficiario_id(id),HttpStatus.OK);
	}
		
	@GetMapping(value = "/beneficiarios")
	public ResponseEntity<?> findAllBeneficiarios() throws Exception{
		LOG.info("iniciando findAllBeneficiarios");
		List<Beneficiario> benef = proxyBenef.findAll_beneficiario();
		LOG.info("fim findAllBeneficiarios");
		return new ResponseEntity<>(benef,HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/beneficiario")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody Beneficiario dto)throws Exception{
		LOG.info("iniciando InsertBeneficiario");
		return new  ResponseEntity<>(proxyBenef.InsertBeneficiario(dto),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/beneficiario")
	public  ResponseEntity<?> UpdateBeneficiario(@RequestBody Beneficiario dto) throws Exception{
		LOG.info("iniciando InsertBeneficiario");
		return new ResponseEntity<>(proxyBenef.UpdateBeneficiario(dto),HttpStatus.OK);
	}

	@GetMapping(value = "/beneficiario-dt-page/")
	public ResponseEntity<?> findBeneficiarioConsultaSemIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{
		
		String direction = "asc";
        Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        LOG.info("exame paginada com beneficiario e sem id all");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "idbenef"));
	
		LOG.info("fim Consulta paginada com beneficiario e sem id all");
		return new ResponseEntity<>(proxyBenef.findAll_beneficiario_page(pageable),HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<?> findBeneficiario2() throws Exception {
		LOG.info("iniciando findBeneficiario");
		return new ResponseEntity<>("Novo teste 1",HttpStatus.OK);
	} 
	
	
	@GetMapping(value = "/exame-beneficiario-list")
	public ResponseEntity<?> findBeneficiarioExameList(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idexame,
			@RequestParam(required = false) Integer tipoexame
	) throws Exception{
		
			LOG.info("exame /exame-beneficiario-list");	
		
			List<ExameFeignDTO> exameDto = exame.findExameList(page, limit, carteirinha, codbenef, startdt, enddt, idexame, tipoexame);
			LOG.info("fim exame /exame-beneficiario-list");
			return new ResponseEntity<>(exameDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/consulta-beneficiario")
	public ResponseEntity<?> find_Beneficiario_Consulta(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idconsulta,
			@RequestParam(required = false) Integer tipoConsuilta
	) throws Exception{
		
		LOG.info("chamando consulta-beneficiario");	
		
		List<ConsultaFeignDTO> consultaDto = consulta.findConsultaList(page, limit, carteirinha, codbenef, startdt, enddt, idconsulta, tipoConsuilta);
		LOG.info("fim  /consulta-beneficiario");
		return new ResponseEntity<>(consultaDto,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/agendamento-beneficiario-all")
	public ResponseEntity<?> findBeneficiarioAgendamentoAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idagendamento,
			@RequestParam(required = false) Integer idtipoagendamento
	) throws Exception{
	
		LOG.info("chamando agendamento-beneficiario");	
		List<AgendamentoFeignDTO> consultaDto = service.findConsultaList(page, limit, carteirinha, codbenef, startdt, enddt, idagendamento, idtipoagendamento);
		LOG.info("fim  /agendamento-beneficiario");
		return new ResponseEntity<>(consultaDto,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/beneficiario/estado")
	public ResponseEntity<?> findEstado() throws Exception {
		LOG.info("iniciando find Estado");
		return new ResponseEntity<>(utilEstado.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/beneficiario/cidade")
	public ResponseEntity<?> findCidade(@RequestParam Integer cidade) throws Exception {
		LOG.info("iniciando find Cidade");
		return new ResponseEntity<>(utilCidade.getcidades(23),HttpStatus.OK);
	}
	
}
