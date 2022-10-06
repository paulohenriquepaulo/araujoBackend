package app.dto.pedidosDto;

import app.model.ItemPedido;

import java.util.List;

public class PedidosRequestDTO {

    private List<ItemPedido> pedidos;

//    private String email;
//    private String senha;
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }

    public List<ItemPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemPedido> pedidos) {
        this.pedidos = pedidos;
    }
}