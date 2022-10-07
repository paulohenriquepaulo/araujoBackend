package app.controller;

import javax.validation.Valid;

import app.dto.clienteDto.ClienteLoginRequestDTO;
import app.dto.clienteDto.ClienteLoginResponseDTO;
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
    public ResponseEntity<ClienteLoginResponseDTO> login(@RequestBody @Valid ClienteLoginRequestDTO dto) {
        Cliente cli = service.validarLogin(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(mapper.toClienteLoginResponseDTO(cli));
    }
}


