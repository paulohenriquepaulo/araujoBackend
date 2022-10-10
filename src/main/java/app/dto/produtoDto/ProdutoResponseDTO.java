package app.dto.produtoDto;

import app.model.Categoria;
import app.model.enums.DisponibilidadeProduto;

public class ProdutoResponseDTO {

    private Long codProduto;
    private String nome;
    private Integer quantidade;
    private float valorUnitario;
    private String descricao;
    private String imagemProduto;

    private Categoria categoria;
    private DisponibilidadeProduto disponibilidade;

    public Long getcodProduto() {
        return codProduto;
    }

    public void setcodProduto(Long id) { this.codProduto = codProduto; }

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

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public DisponibilidadeProduto getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(DisponibilidadeProduto disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
