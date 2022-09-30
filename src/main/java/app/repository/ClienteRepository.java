package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	boolean existsByCpf(String cpf);

	boolean existsByRg(String rg);
}
