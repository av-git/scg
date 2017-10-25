package br.jus.trt8.scg.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trt8.scg.dto.JuizDto;
import br.jus.trt8.scg.model.Juiz;
import br.jus.trt8.scg.response.Response;
import br.jus.trt8.scg.service.JuizService;

@RestController //INFORMO QUE E UM END-POINT
@RequestMapping ("/scg/juiz")
@CrossOrigin ( origins = "*" ) // LIBERA ACESSO POR DOMINIOS DISTINTOS 
public class CadastroJuizController {
	
	private static final Logger log = LoggerFactory.getLogger(CadastroJuizController.class);
	
	@Autowired
	private JuizService juizService;

	public CadastroJuizController() {
		super();
	}
	
	@GetMapping (value = "/cpf/{cpf}")
	public ResponseEntity<Response<JuizDto>> buscarPorCpf( @PathVariable("cpf") String cpf ) {
		
		log.info("Cadastrando Juiz: {}", cpf);
		
		Response<JuizDto> response = new Response<JuizDto>();
		Optional<Juiz> juiz = juizService.obterPorCpf(cpf);
		
		if (!juiz.isPresent()) {
			log.info("Juiz com cpf: {} não encontrado", cpf);
			response.getErrors().add("Juiz com CPF " + cpf +" não encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterJuizParaDto(juiz.get()));
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * 
	 * @param juizDto
	 * @param result
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Response<JuizDto>> cadastrar(@Valid @RequestBody JuizDto juizDto, BindingResult result) {
		
		/* o @Valid ira validar os dados do formulario conforme as anotation dos DTO */
		/* o @RequestBody transforma os dados do formulario e transforma em juizDto */
		/* o BindingResult tera o resultato da validacao do juizDto */
		
		log.info("Cadastrando Juiz: {}", juizDto.toString());
		Response<JuizDto> response = new Response<JuizDto>();
		
		validarRegistroDuplicado(juizDto, result);
		Juiz juiz = this.converterJuizDtoParaJuiz(juizDto);
		
		if (result.hasErrors()) {
			log.info("Erro na validacao do cadastro do Juiz: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response); // retornar um erro 400 com os erros
		}
		
		this.juizService.salvar(juiz);
		
		response.setData(this.converterJuizParaDto(juiz));
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Convert uma entidade Juiz para o DTO
	 * 
	 * @param juiz
	 * @return
	 */
	private JuizDto converterJuizParaDto(Juiz juiz) {
		
		JuizDto juizDto = new JuizDto();
		juizDto.setCpf(juiz.getCpf());
		juizDto.setEmail(juiz.getEmail());
		juizDto.setNome(juiz.getNome());
		juizDto.setId(juiz.getId());
		
		return juizDto;
	}

	/**
	 * Converte os dados do DTO para entidade {@link Juiz}
	 * @param juizDto
	 * @return
	 */
	private Juiz converterJuizDtoParaJuiz(JuizDto juizDto) {
		Juiz juiz = new Juiz();
		juiz.setCpf(juizDto.getCpf());
		juiz.setEmail(juizDto.getEmail());
		juiz.setNome(juizDto.getNome());
		
		return juiz;
	}

	/**
	 * Verifica se o Juiz ja foi cadastrado na base de dados
	 * 
	 * @param juizDto
	 * @param result
	 */
	private void validarRegistroDuplicado(JuizDto juizDto, BindingResult result) {
		this.juizService.obterPorCpf(juizDto.getCpf())
			.ifPresent(juiz -> result.addError(new ObjectError("juiz", "Juiz já cadastrado.")));
		
	}
}
