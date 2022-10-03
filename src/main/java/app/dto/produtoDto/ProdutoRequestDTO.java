package app.dto.produtoDto;

import app.model.enums.DisponibilidadeProduto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoRequestDTO {

    @Size(max=100, message="O campo nome deve conter no máximo 100 caracteres!")
    @NotBlank(message = "O campo Nome não pode ser nulo ou vazio!")
    private String nome;

    @NotNull(message = "O campo quantidade não pode ser nulo ou vazio!")
    private Integer quantidade;


    @NotNull(message="O campo valor unitário não pode ser vazio")
    private float valorUnitario;


    @NotBlank(message = "O campo descrição não pode ser nulo ou vazio!")
    private String descricao;


    @NotBlank(message = "O campo imagem não pode ser nulo ou vazio!")
    private String imagemProduto;

    @Enumerated(EnumType.STRING)
    private DisponibilidadeProduto disponibilidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public DisponibilidadeProduto getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(DisponibilidadeProduto disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}


