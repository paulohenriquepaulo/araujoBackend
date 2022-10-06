package app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_ITENS_PEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @NotBlank(message = "O Id do pedido não pode ser vazio")
    @ManyToOne
    @JoinColumn(name = "ID_PEDIDOS")
    private Pedidos pedidos;

    @NotBlank(message = "O Id do produto não pode ser vazio")
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    @NotBlank(message = "A quantidade não pode ser vazia")
    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @NotBlank(message = "O Valor unitário não pode ser vazio!")
    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @NotBlank(message = "O Valor total não pode ser vazio!")
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    public Long getId() {
        return id_pedido;
    }

    public void setId(Long id) {
        this.id_pedido = id;
    }

    public Pedidos getCarrinho() {
        return pedidos;
    }

    public void setCarrinho(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
