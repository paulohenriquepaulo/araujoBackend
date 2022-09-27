package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Nome não pode ser vazio!")
	@Column(name = "NOME")
	@Size(max = 100, message = "O Nome deve conter no máximo 100 caracter!")
	private String nome;
	
	@NotBlank(message = "O E-mail não pode ser vazio!")
	@Column(name = "EMAIL")
	@Size(max = 100, message = "O E-mail deve conter no máximo 100 caracter!")
	private String email;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@CPF(message = "CPF inválido!")
	@Column(name = "CPF", unique = true)
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 digitos!")
	private String cpf;
	
	@NotBlank(message = "O RG não pode ser vazio!")
	@Column(name = "RG", unique = true)
	private String rg;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
}
