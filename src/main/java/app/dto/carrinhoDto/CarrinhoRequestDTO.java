package app.dto.carrinhoDto;

import app.model.ItemPedido;

import java.util.List;

public class CarrinhoRequestDTO {

    private List<ItemPedido> pedidos;


    public List<ItemPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemPedido> pedidos) {
        this.pedidos = pedidos;
    }
}
