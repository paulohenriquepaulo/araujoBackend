package app.controller;

import javax.validation.Valid;

import app.dto.clienteDto.ClienteLoginDTO;
import app.exeception.AraujoExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.dto.clienteDto.ClienteRequestDTO;
import app.dto.clienteDto.ClienteResponseDTO;
import app.mapper.ClienteMapper;
import app.model.Cliente;
import app.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ClienteMapper mapper;
	
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody @Valid ClienteRequestDTO dto) {
		Cliente novoCliente = service.cadastarCliente(mapper.toCliente(dto));
		return ResponseEntity.ok(mapper.toClienteResponseDTO(novoCliente));
	}

	@GetMapping("/login")
	public ResponseEntity<ClienteResponseDTO> login(@RequestBody @Valid ClienteLoginDTO dto) {
		ClienteResponseDTO clienteResponseDTO = mapper.toClienteResponseDTO(service.validarLogin(dto));
		if(clienteResponseDTO != null){
			return ResponseEntity.ok(clienteResponseDTO);
		}
		throw new AraujoExeception("Falha ao realizar login", HttpStatus.UNPROCESSABLE_ENTITY);
	}
}


