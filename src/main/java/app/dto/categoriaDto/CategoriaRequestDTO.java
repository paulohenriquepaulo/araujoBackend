package app.dto.categoriaDto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

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


