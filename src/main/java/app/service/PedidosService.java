package app.service;

import app.exeception.AraujoExeception;
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
    private ProdutoRepository produtoRepository;


//    public Pedidos cadastrarPedidos(Pedidos pedidos){
//        for (int i = 0; i<pedidos.getItensPedidos().size(); i++){
//            validarProduto(pedidos.getItensPedidos().get(i).getId();
//        }
//        Pedidos p = new Pedidos();
//        p.setDataTransacao(LocalDate.now());
//        p.setItensPedidos(pedidos.getItensPedidos());
//        p.setStatus(StatusPedido.PROCESSANDO);
//        p.setTransacao(); // em andamento
//    }

    public void validarProduto(Long id) {
        if(!produtoRepository.existsById(id)){
            throw new AraujoExeception("Produto não encontrado!", HttpStatus.NO_CONTENT);
        }
    }
}

