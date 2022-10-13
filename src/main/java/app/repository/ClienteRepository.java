package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Cliente;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	boolean existsByCpf(String cpf);

	boolean existsByRg(String rg);

	boolean existsByEmail(String email);

	@Query(value = "SELECT senha FROM TB_CLIENTE WHERE email = :email", nativeQuery = true)
	String getSenhaByEmail(String email);

	Cliente getByEmail(String email);
}
