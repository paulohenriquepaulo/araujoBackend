package app.dto.clienteDto;

import java.util.List;

import app.dto.enderecoDto.EnderecoResponseDTO;

public class ClienteResponseDTO {


	private Long id;
	private String nome;
	private String sobrenome;
	private String senha;
	private String telefone;
	private String cpf;
	private String email;
	private String rg;
	private List<EnderecoResponseDTO> enderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<EnderecoResponseDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoResponseDTO> enderecos) {
		this.enderecos = enderecos;
	}
}
