package app.service;

import app.dto.clienteDto.ClienteLoginDTO;
import app.exeception.AraujoExeception;
import app.model.Cliente;
import app.model.Transacao;
import app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

	public Cliente validarLogin(ClienteLoginDTO dto){
		Cliente cliente = null;
		if(repository.existsByEmail(dto.getEmail())){
			String senha = repository.getSenhaByEmail(dto.getEmail());
			if(dto.getSenha().equals(senha)){
				cliente = repository.getByEmail(dto.getEmail());
			}
		}
		return cliente;
	}
}
