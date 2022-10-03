package app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

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
    private Integer quantidade;

    @Column(name= "valor unitario")
    @NotBlank(message="O campo valor unitário não pode ser vazio")
    private float valorUnitario;

    @Column(name="descricao")
    @NotBlank(message = "O campo descrição não pode ser nulo ou vazio!")
    private String descricao;

    @Column(name="imagem")
    @NotBlank(message = "O campo imagem não pode ser nulo ou vazio!")
    private String imagemProduto;

    @Column(name="disponibilidade")
    private DisponibilidadeProduto disponibilidade;

    // Getters and setters


    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

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
