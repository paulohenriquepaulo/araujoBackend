package app.dto.itensPedidosDto;

import javax.validation.constraints.NotNull;

public class ItensPedidosRequestDTO {


    private Long codProduto;
    private Integer quantidade;

    public Long getId_produto() {
        return codProduto;
    }

    public void setId_produto(Long id_produto) {
        this.codProduto = id_produto;
    }


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
