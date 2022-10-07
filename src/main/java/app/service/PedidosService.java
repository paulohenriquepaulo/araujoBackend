package app.service;

import app.dto.pedidosDto.PedidosRequestDTO;
import app.exeception.AraujoExeception;
import app.model.Cliente;
import app.model.Pedidos;
import app.model.enums.StatusPedido;
import app.repository.PedidosRepository;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoRepository produtoRepository;

    // Alterações sendo feitas
//    public Pedidos cadastrarPedidos(PedidosRequestDTO pedidos, String email, String senha) {
//        Cliente cliente = clienteService.validarLogin(email, senha);
//        for (int i = 0; i < pedidos.getPedidos().size(); i++) {
//            validarProduto(pedidos.getPedidos().get(i).getCodProduto());
//        }
//        Pedidos p = new Pedidos();
//        p.setDataTransacao(LocalDate.now());
//        p.setItensPedidos(pedidos.getPedidos().);
//        p.setStatus(StatusPedido.PROCESSANDO);
//        p.setTransacao(cliente.getTransacao());
//
//        Double valorTotalPedidos = 0.0;
//        for (int i = 0; i < pedidos.getItensPedidos().size(); i++) {
//            pedidos.getItensPedidos().get(i).setValorTotal(pedidos.getItensPedidos().get(i).getValorUnitario() * pedidos.getItensPedidos().get(i).getQuantidade());
//            valorTotalPedidos += pedidos.getItensPedidos().get(i).getValorTotal();
//        }
//        p.setValorTotal(valorTotalPedidos);
//        return pedidosRepository.save(p);
//    }

    public void validarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new AraujoExeception("Produto não encontrado!", HttpStatus.NO_CONTENT);
        }
    }
}

