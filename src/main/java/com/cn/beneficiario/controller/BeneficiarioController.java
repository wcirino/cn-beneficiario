package com.cn.beneficiario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.cn.beneficiario.dto.AgendamentoPageDTO;
import com.cn.beneficiario.dto.Beneficiario;
import com.cn.beneficiario.dto.ConsultaDTO;
import com.cn.beneficiario.dto.ExameDTO;
import com.cn.beneficiario.dto.ExamePageDTO;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioAgendamentoService;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioConsultaService;
import com.cn.beneficiario.feignclients.service.impl.BeneficiarioExameService;
import com.cn.beneficiario.service.impl.BeneficiarioServiceImpl;

import io.swagger.annotations.ApiOperation;

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
	
//	@GetMapping(value = "/")
//	public ResponseEntity<?> findAllBeneficiariostest() throws Exception{
//		LOG.info("iniciando findAllBeneficiarios");
//		LOG.info("fim findAllBeneficiarios");
//		return new ResponseEntity<>("Chegou na requisição",HttpStatus.OK);
//	}

	
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
		
		String direction = "desc";
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
	
	@ApiOperation(value ="agendamento paginada com beneficiario e sem id all")
	@GetMapping(value = "/agendamento-beneficiario-id-page")
					  //	 /agendamento-beneficiario-id-page
	public ResponseEntity<?> findBeneficiarioAgendamentoComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) int id,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt
	) throws Exception{

        LOG.info("Consulta paginada com beneficiario e seu id all");
		
		AgendamentoPageDTO agenda = service.findAgendamentoBetweenComIDPage(page, limit, id, startdt, enddt);
		LOG.info("fim Consulta paginada com beneficiario e seu id all");
		return new ResponseEntity<>(agenda,HttpStatus.OK);
	}
	
	@ApiOperation(value ="exame paginada com beneficiario e sem id all")
	@GetMapping(value = "/exame-beneficiario-page/")
	public ResponseEntity<?> findBeneficiarioExameComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{
		
        LOG.info("exame paginada com beneficiario e seu id all");	
	
		ExamePageDTO exameDto = exame.findExameBetweenIDPage(page, limit, id, startdt, enddt);
		LOG.info("fim exame paginada com beneficiario e seu id all");
		return new ResponseEntity<>(exameDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/exame-beneficiario")
	public ResponseEntity<?> findBeneficiarioExame(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(required = false) String carteirinha,
			@RequestParam(required = false) Integer codbenef,
			@RequestParam(required = false) String startdt,
			@RequestParam(required = false) String enddt,
			@RequestParam(required = false) Integer idexame,
			@RequestParam(required = false) Integer tipoexame
	) throws Exception{
		
	    LOG.info("exame paginada com beneficiario e seu id all");	
		
			Page<ExameDTO> exameDto = exame.findExamePage(page, limit, carteirinha, codbenef, startdt, enddt, idexame, tipoexame);
			LOG.info("fim exame paginada com beneficiario e seu id all");
			return new ResponseEntity<>(exameDto,HttpStatus.OK);
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
		
			List<ExameDTO> exameDto = exame.findExameList(page, limit, carteirinha, codbenef, startdt, enddt, idexame, tipoexame);
			LOG.info("fim exame /exame-beneficiario-list");
			return new ResponseEntity<>(exameDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-All-consultas")
	public ResponseEntity<?> FindAllConsulta() throws Exception{
		LOG.info("Buscando na api-cn-Consultas");
		List<ConsultaDTO> consultas = consulta.BuscaConsultasAllService();
		return  new ResponseEntity<>(consultas,HttpStatus.OK);
	}
	
	@GetMapping(value = "/busca-consulta-id/{id}")
	public ResponseEntity<?> FindAIDConsulta(@PathVariable int id) throws Exception{
		LOG.info("Buscando FindAIDConsulta  na  api-cn-Consultas");
		ConsultaDTO consultas = consulta.BuscaConsultasIDService(id);
		return  new ResponseEntity<>(consultas,HttpStatus.OK);
	}
}
