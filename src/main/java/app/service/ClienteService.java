package app.service;

import app.model.Endereco;
import app.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import app.exeception.AraujoExeception;
import app.model.Cliente;
import app.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente cadastarCliente(Cliente cliente) {
		validarCpf(cliente.getCpf());
		validarRg(cliente.getRg());
		Transacao transacao = new Transacao();
		transacao.setCliente(cliente);
		cliente.setTransacao(transacao);
		return repository.save(cliente);
	}
	
	private void validarCpf(String cpf) {
		if (repository.existsByCpf(cpf)) {
			throw new AraujoExeception("CPF já cadastrado", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	private void validarRg(String rg) {
		if (repository.existsByRg(rg)) {
			throw new AraujoExeception("RG já cadastrado", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
