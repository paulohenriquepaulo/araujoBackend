package app.dto.carrinhoDto;

import app.model.ItemPedido;
import app.model.Transacao;
import app.model.enums.StatusPedido;

import java.time.LocalDate;
import java.util.List;

public class CarrinhoResponseDTO {

    private Long id;

    private Double valorTotal;

    private StatusPedido status;

    private List<ItemPedido> pedidos;

    private LocalDate dataCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemPedido> pedidos) {
        this.pedidos = pedidos;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

}
