package app.dto.produtoDto;

import app.dto.categoriaDto.CategoriaResponseDTO;
import app.model.Categoria;
import app.model.enums.DisponibilidadeProduto;

public class ProdutoResponseDTO {

    private Long codProduto;
    private String nome;
    private Integer quantidade;
    private float valorUnitario;
    private String descricao;
    private String imagemProduto;

    private CategoriaResponseDTO categoria;

    private DisponibilidadeProduto disponibilidade;

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

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }

    public DisponibilidadeProduto getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(DisponibilidadeProduto disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
