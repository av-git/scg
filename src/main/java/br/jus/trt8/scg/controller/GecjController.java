package br.jus.trt8.scg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trt8.scg.dto.GECJDto;
import br.jus.trt8.scg.model.GECJ;
import br.jus.trt8.scg.model.Juiz;
import br.jus.trt8.scg.response.Response;
import br.jus.trt8.scg.service.GecjService;
import br.jus.trt8.scg.service.JuizService;

@RestController //INFORMO QUE E UM END-POINT
@RequestMapping ("/scg/gecj")
@CrossOrigin ( origins = "*" ) // LIBERA ACESSO POR DOMINIOS DISTINTOS 
public class GecjController {
	
	private static final Logger log = LoggerFactory.getLogger(GecjController.class);
	
	@Autowired
	private GecjService gecjService;
	
	@Autowired
	private JuizService juizService;
	
	public GecjController() {
		super();
	}
	
	
	@GetMapping (value = "/cpf/{cpf}")
	public ResponseEntity<Response<GECJDto>> buscarPorCpf( @PathVariable("cpf") String cpf ) {
		
		log.info("Cadastrando Gecj: {}", cpf);
		
		Response<GECJDto> response = new Response<GECJDto>();
		Optional<Juiz> juiz = juizService.obterPorCpf(cpf);
		Optional<List<GECJ>> listaGecj;
		
		if (juiz.isPresent()) {
			listaGecj = gecjService.obterPor(juiz.get().getId());
		} else {
			log.info("Juiz com cpf: {} não encontrado", cpf);
			response.getErrors().add("Juiz com CPF " + cpf +" não encontrado");
			
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterGECJParaDto(listaGecj).get(0));
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Convert uma entidade Vara para o DTO
	 * 
	 * @param juiz
	 * @return
	 */
	private List<GECJDto> converterGECJParaDto(Optional<List<GECJ>> listaGecj) {
		
		List<GECJDto> listaGecjDto = new ArrayList<>();
		
		for (GECJ g : listaGecj.get()) {
			GECJDto gecjDto = new GECJDto();
			
			gecjDto.setAno(g.getAno());
			gecjDto.setAprovado(g.getAprovado());
			gecjDto.setDataCalculo(g.getDataCalculo());
			gecjDto.setDeAcordo(g.getDeAcordo());
			gecjDto.setJustificativa(g.getJustificativa());
			gecjDto.setMes(g.getMes());
			gecjDto.setParecer(g.getParecer());
			
			listaGecjDto.add(gecjDto);
		}
		
		return listaGecjDto;
	}
}
