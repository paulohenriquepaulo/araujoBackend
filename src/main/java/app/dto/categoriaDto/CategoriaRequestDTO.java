package app.dto.categoriaDto;

import app.model.Produto;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class CategoriaRequestDTO {

    @Column(name="nome")
    @NotBlank(message = "O campo Nome não pode ser nulo ou vazio")
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}


