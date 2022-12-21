package app.service;

import app.exeception.AraujoExeception;
import app.model.Categoria;
import app.model.Cliente;
import app.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private ClienteService clienteService;

    @Mock
    private CategoriaRepository categoriaRepository;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
      cliente = new Cliente();
    }

    @Test
    public void deveSubirUmaExceptionQuandoONomeForIgualANull() {
        AraujoExeception exeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> categoriaService.validarCategoria(null)
        );
        Assertions.assertEquals("{mensagem=Categoria não cadastrada!, status=404}", exeception.getErrors().toString());
    }

    @Test
    public void salvarCategoria(){
        Categoria categoria = new Categoria();
        categoria.setNome("Teste");
        when(clienteService.validarLogin(any(), any())).thenReturn(cliente);
        categoriaService.cadastrarCategoria(categoria, "teste", "we");
        when(categoriaRepository.save(any())).thenReturn(categoria);
        verify(clienteService, times(1)).validarLogin(any(), any());
    }
}