package app.service;

import app.model.Categoria;
import app.model.Cliente;
import app.model.Produto;
import app.model.enums.DisponibilidadeProduto;
import app.repository.CategoriaRepository;
import app.repository.ProdutoRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ClienteService clienteService;

    @Mock
    private ProdutoRepository repository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private CategoriaService categoriaService;

    private Produto produto;


    @Before
    public void setUp() {

        produto.setDisponibilidade(DisponibilidadeProduto.DISPONIVEL);
        produto.getCategoria().setNome("teste");
    }

    @Test
    void cadastrarProdutoComSucesso() {
        produto = new Produto();
        Categoria categoria = new Categoria();
        categoria.setNome("Teste");
        categoria.setProduto(new ArrayList<>());
        categoria.setId(1l);
        produto.setCategoria(categoria);
        produtoService.cadastrarProduto(produto, any(), any());

        when(clienteService.validarLogin(any(), any())).thenReturn(new Cliente());
        when(categoriaRepository.getNomeById(1l)).thenReturn("Teste");

        verify(categoriaService, times(1)).validarCategoria(any());
        verify(repository, times(1)).save(produto);

    }

}