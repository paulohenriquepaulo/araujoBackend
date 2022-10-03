package app.model;

import app.model.enums.StatusPedido;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
//c
@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "O ID do cliente não pode ser vazio!")
    //@JoinColumn(name = "id")
    //private Cliente cliente;

    @NotBlank(message = "A Data não pode ser vazia!")
    @Column(name = "DATA_PEDIDO")
    private LocalDate dataPedido;

    @NotBlank(message = "O valor total não pode ser vazio!")
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @NotBlank(message = "O status total não pode ser vazio!")
//    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusPedido status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Cliente getCliente() {
   //     return cliente;
    //}

   // public void setCliente(Cliente cliente) {
   //     this.cliente = cliente;
   // }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
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
}
