package app.model;

import app.model.enums.DisponibilidadeProduto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {


    // codProduto, nome, quantidade,valor, descricao, imagemProduto, disponivel

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;

    @Column(name="Nome")
    @Size(max=100, message="O campo nome deve conter no máximo 100 caracteres!")
    @NotBlank(message = "O campo Nome não pode ser nulo ou vazio!")
    private String nome;

    @Column(name="quantidade")
    @Size(min=1, message="O campo nome deve conter no máximo 100 caracteres!")
    @NotBlank(message = "O campo quantidade não pode ser nulo ou vazio!")
    private String quantidade;

    @Column(name="descricao")
    @NotBlank(message = "O campo descrição não pode ser nulo ou vazio!")
    private String descricao;

    @Column(name="imagem")
    @NotBlank(message = "O campo imagem não pode ser nulo ou vazio!")
    private String imagemProduto;

    @Column(name="disponibilidade")
    private DisponibilidadeProduto disponibilidade;

}
