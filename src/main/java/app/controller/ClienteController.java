package app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


