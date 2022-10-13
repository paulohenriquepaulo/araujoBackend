package app.dto.pedidosDto;

import app.dto.itensPedidosDto.ItensPedidosResponseDTO;
import app.model.enums.StatusPedido;

import java.time.LocalDate;
import java.util.List;

public class PedidosResponseDTO {

    private Long id;

    private Double valorTotal;

    private StatusPedido status;

    private List<ItensPedidosResponseDTO> pedidos;

    private LocalDate dataTransacao;

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

    public List<ItensPedidosResponseDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItensPedidosResponseDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}