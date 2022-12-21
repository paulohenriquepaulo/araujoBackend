package app.service;

import app.dto.itensPedidosDto.ItensPedidosRequestDTO;
import app.dto.pedidosDto.PedidosRequestDTO;
import app.exeception.AraujoExeception;
import app.model.*;
import app.model.enums.DisponibilidadeProduto;
import app.repository.PedidosRepository;
import app.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PedidosServiceTest {

    @InjectMocks
    private PedidosService pedidosService;

    @Mock
    private PedidosRepository pedidosRepository;

    @Mock
    private ClienteService clienteService;

    @Mock
    private ProdutoRepository produtoRepository;

    private PedidosRequestDTO pedidosRequestDTO;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        pedidosRequestDTO = new PedidosRequestDTO();

        ItensPedidosRequestDTO itensPedidosRequestDTO = new ItensPedidosRequestDTO();
        itensPedidosRequestDTO.setQuantidade(3);
        itensPedidosRequestDTO.setId_produto(1l);

        List<ItensPedidosRequestDTO> itensPedidosRequestDTOS = new ArrayList<>();
        itensPedidosRequestDTOS.add(itensPedidosRequestDTO);

        pedidosRequestDTO.setPedidos(itensPedidosRequestDTOS);

        produto = new Produto();
        produto.setQuantidade(5);
        produto.setCodProduto(1l);

        Cliente cliente = new Cliente();
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco());
        cliente.setEnderecos(enderecos);
        Transacao transacao = new Transacao();
        cliente.setTransacao(transacao);
        when(clienteService.validarLogin(any(), any())).thenReturn(cliente);

        when(produtoRepository.existsById(1l)).thenReturn(true);
        when(produtoRepository.findById(any())).thenReturn(Optional.of(produto));
    }

    @Test
    public void DeveLancaUmaExeceptionQuandoOProdutoNaoForEncontrado() {
        when(pedidosRepository.existsById(any())).thenReturn(false);
        AraujoExeception araujoExeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> pedidosService.validarProduto(any())
        );
        Assertions.assertEquals("Produto não encontrado!", araujoExeception.getErrors().get("mensagem"));
        Assertions.assertEquals(String.valueOf(HttpStatus.NO_CONTENT.value()), araujoExeception.getErrors().get("status"));
    }

    @Test
    public void cadastrarPedidos() {
        when(pedidosRepository.save(any())).thenReturn(new Pedidos());
        Pedidos pedidos = pedidosService.cadastrarPedidos(pedidosRequestDTO, any(), any());
        Assertions.assertNotNull(pedidos);
        Assertions.assertEquals(Pedidos.class, pedidos.getClass());
        verify(pedidosRepository, times(1)).save(any());
    }

    @Test
    public void DeveLancaUmaExeceptionQuandoAQuantidadeDeProdutoIndiponivel() {
        produto.setQuantidade(0);
        AraujoExeception araujoExeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> pedidosService.cadastrarPedidos(pedidosRequestDTO, any(), any())
        );
        Assertions.assertEquals("Quantidade de produto indisponivel", araujoExeception.getErrors().get("mensagem"));
        Assertions.assertEquals(String.valueOf(HttpStatus.UNAUTHORIZED.value()), araujoExeception.getErrors().get("status"));
    }

    @Test
    public void quandoAQuantidadeDoProdutoForIgualAZeroDeSetaComIndisponviel() {
        produto.setQuantidade(3);
        pedidosService.cadastrarPedidos(pedidosRequestDTO, any(), any());
        Assertions.assertEquals(DisponibilidadeProduto.INDISPONIVEL, produto.getDisponibilidade());
    }

}