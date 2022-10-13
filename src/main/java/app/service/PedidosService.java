package app.service;

import app.dto.itensPedidosDto.ItensPedidosRequestDTO;
import app.dto.pedidosDto.PedidosRequestDTO;
import app.exeception.AraujoExeception;
import app.model.Cliente;
import app.model.ItemPedido;
import app.model.Pedidos;
import app.model.Produto;
import app.model.enums.DisponibilidadeProduto;
import app.model.enums.StatusPedido;
import app.repository.PedidosRepository;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoRepository produtoRepository;


    public Pedidos cadastrarPedidos(PedidosRequestDTO pedidos, String email, String senha) {

        Pedidos novoPedido = new Pedidos();
        Cliente cliente = clienteService.validarLogin(email, senha);
        List<ItemPedido> itemPedidoList = new ArrayList<>();
        ItemPedido itemPedido = null;

        for (ItensPedidosRequestDTO pedido : pedidos.getPedidos()) {
            Optional<Produto> produtoOptional = produtoRepository.findById(pedido.getId_produto());
            Produto produto = produtoOptional.get();
            if (pedido.getQuantidade() <= produto.getQuantidade()) {
                itemPedido = new ItemPedido();
                itemPedido.setProduto(produto);
                itemPedido.setValorUnitario(converterValor((double) produto.getValorUnitario()));
                itemPedido.setQuantidade(pedido.getQuantidade());
                Double valorTotalItens = (double)(produto.getValorUnitario() * pedido.getQuantidade());
                itemPedido.setValorTotal(converterValor(valorTotalItens));
                validarProduto(produto.getCodProduto());
                produto.setQuantidade(produto.getQuantidade() - pedido.getQuantidade());
                itemPedidoList.add(itemPedido);
                itemPedido.setPedidos(novoPedido);
                if (produto.getQuantidade() == 0) {
                    produto.setDisponibilidade(DisponibilidadeProduto.INDISPONIVEL);
                }
            } else {
                throw new AraujoExeception("Quantidade de produto indisponivel", HttpStatus.UNAUTHORIZED);
            }
        }

        novoPedido.setItensPedidos(itemPedidoList);
        novoPedido.setDataTransacao(LocalDate.now());
        novoPedido.setStatus(StatusPedido.PROCESSANDO);
        novoPedido.setTransacao(cliente.getTransacao());
        Double valorTotal = calcularPedidos(pedidos, novoPedido);
        novoPedido.setValorTotal(converterValor(valorTotal));
        return pedidosRepository.save(novoPedido);
    }

    private static Double calcularPedidos(PedidosRequestDTO dto, Pedidos pedidos) {
        Double valorTotalPedidos = 0.0;
        for (int i = 0; i < dto.getPedidos().size(); i++) {
            valorTotalPedidos += pedidos.getItensPedidos().get(i).getValorTotal();
        }
        return valorTotalPedidos;
    }

    private Double converterValor(Double valor) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(valor);
        String[] part = string.split("[,]");
        String valorConvertido = part[0]+"."+part[1];
        return Double.parseDouble(valorConvertido);
    }

    public void validarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new AraujoExeception("Produto não encontrado!", HttpStatus.NO_CONTENT);
        }
    }
}

