package app.service;

import app.dto.clienteDto.ClienteLoginDTO;
import app.exeception.AraujoExeception;
import app.model.Cliente;
import app.model.Transacao;
import app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente cadastarCliente(Cliente cliente) {
		validarCpf(cliente.getCpf());
		validarRg(cliente.getRg());
		cliente.getEnderecos().get(0).setCliente(cliente);
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

	public boolean validarLogin(ClienteLoginDTO clienteLoginDTO){
		if(repository.existsByEmail(clienteLoginDTO.getEmail())){
			String senha = repository.getSenhaByEmail(clienteLoginDTO.getEmail());
			if(clienteLoginDTO.getSenha().equals(senha)){
				return true;
			}
		}
		return false;
	}
}
