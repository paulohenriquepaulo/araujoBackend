package app.repository;

import app.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    @Query(value = "select nome from categoria where id = :id", nativeQuery = true)
    String getNomeById(Long id);

    boolean existsByNome(String nome);
}
