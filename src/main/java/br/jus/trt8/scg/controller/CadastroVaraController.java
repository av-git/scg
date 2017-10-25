package br.jus.trt8.scg.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trt8.scg.dto.VaraDto;
import br.jus.trt8.scg.model.Vara;
import br.jus.trt8.scg.response.Response;
import br.jus.trt8.scg.service.VaraService;

@RestController //INFORMO QUE E UM END-POINT
@RequestMapping ("/scg/vara-juiz")
@CrossOrigin ( origins = "*" ) // LIBERA ACESSO POR DOMINIOS DISTINTOS 
public class CadastroVaraController {
	
	private static final Logger log = LoggerFactory.getLogger(CadastroVaraController.class);
	
	@Autowired
	private VaraService varaService;

	public CadastroVaraController() {
		super();
	}
	
	/**
	 * 
	 * @param juizDto
	 * @param result
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Response<VaraDto>> cadastrar(@Valid @RequestBody VaraDto varaDto, BindingResult result) {
		
		/* o @Valid ira validar os dados do formulario conforme as anotation dos DTO */
		/* o @RequestBody transforma os dados do formulario e transforma em varaDto */
		/* o BindingResult tera o resultato da validacao do varaDto */
		
		log.info("Cadastrando Vara: {}", varaDto.toString());
		Response<VaraDto> response = new Response<VaraDto>();
		
		validarRegistroDuplicado(varaDto, result);
		Vara vara = this.converterVaraDtoParaVara(varaDto);
		
		if (result.hasErrors()) {
			log.info("Erro na validacao do cadastro da Vara: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response); // retornar um erro 400 com os erros
		}
		
		this.varaService.salvar(vara);
		
		response.setData(this.converterVaraParaDto(vara));
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Convert uma entidade Vara para o DTO
	 * 
	 * @param juiz
	 * @return
	 */
	private VaraDto converterVaraParaDto(Vara vara) {
		
		VaraDto varaDto = new VaraDto();
		varaDto.setNome(vara.getNome());
		
		return varaDto;
	}

	/**
	 * Converte os dados do DTO para entidade {@link Vara}
	 * @param VaraDto
	 * @return
	 */
	private Vara converterVaraDtoParaVara(VaraDto varaDto) {
		Vara vara = new Vara();
		vara.setNome(varaDto.getNome());
		
		return vara;
	}

	/**
	 * Verifica se o Juiz ja foi cadastrado na base de dados
	 * 
	 * @param juizDto
	 * @param result
	 */
	private void validarRegistroDuplicado(VaraDto varaDto, BindingResult result) {
		this.varaService.obterPorNome(varaDto.getNome())
			.ifPresent(juiz -> result.addError(new ObjectError("vara", "vara já cadastrado.")));
		
	}
}
