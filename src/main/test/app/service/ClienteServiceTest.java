package app.service;

import app.exeception.AraujoExeception;
import app.model.Cliente;
import app.model.Endereco;
import app.model.Transacao;
import app.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        cliente.setNome("teste");
        cliente.setEmail("teste@gmail.com");
        cliente.setSenha("teste123");
        cliente.setSobrenome("teste");
        cliente.setTransacao(new Transacao());
        cliente.setRg("MG-2021");
        cliente.setCpf("86231764990");
        cliente.setTelefone("11111111");
        cliente.setEnderecos(new ArrayList<>());
        clienteRepository.save(cliente);
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        cliente.setEnderecos(enderecos);
    }


    @Test
    public void deveSubirUmaExeceptionQuandoNaoExistirEmailCadastrado() {
        when(clienteRepository.existsByEmail(any())).thenReturn(false);
        AraujoExeception araujoExeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> clienteService.validarLogin("teste", any())
        );
        Assertions.assertEquals("Login ou senha invalido", araujoExeception.getErrors().get("mensagem"));
        Assertions.assertEquals(String.valueOf(HttpStatus.UNAUTHORIZED.value()), araujoExeception.getErrors().get("status"));
    }

    @Test
    public void deveSubirUmaExeceptionQuandoASenhaForDiferenteDaSenhaCadastrada() {
        when(clienteRepository.existsByEmail(any())).thenReturn(true);
        when(clienteRepository.getSenhaByEmail(any())).thenReturn("senhaErrada");
        AraujoExeception araujoExeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> clienteService.validarLogin(any(), "senhaCerta")
        );
        Assertions.assertEquals("Login ou senha invalido", araujoExeception.getErrors().get("mensagem"));
        Assertions.assertEquals(String.valueOf(HttpStatus.UNAUTHORIZED.value()), araujoExeception.getErrors().get("status"));
    }

    @Test
    public void deveRetornarUmCLienteQuandoLoguinEstiverCorreto() {
        cliente = new Cliente();
        when(clienteRepository.existsByEmail(any())).thenReturn(true);
        when(clienteRepository.getSenhaByEmail(any())).thenReturn("senhaCerta");
        clienteService.validarLogin("teste@gmail.com", "senhaCerta");
        when(clienteRepository.getByEmail(any())).thenReturn(cliente);
        Assertions.assertNotNull(clienteService.validarLogin("teste@gmail.com", "senhaCerta"));
    }

    @Test
    public void cadastrarClienteComSucesso() {
        clienteService.cadastarCliente(cliente);
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Assertions.assertNotNull(clienteService.cadastarCliente(cliente));
    }

    @Test
    public void deveSubirExeceptionQuandoCPFEstiverCadastrado() {
        when(clienteRepository.existsByCpf(any())).thenReturn(true);
        AraujoExeception araujoExeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> clienteService.cadastarCliente(cliente)
        );
        Assertions.assertEquals("CPF já cadastrado", araujoExeception.getErrors().get("mensagem"));
        Assertions.assertEquals(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()), araujoExeception.getErrors().get("status"));
    }

    @Test
    public void deveSubirExeceptionQuandoRGEstiverCadastrado() {
        when(clienteRepository.existsByCpf(any())).thenReturn(true);
        when(clienteRepository.existsByCpf(any())).thenReturn(false);
        when(clienteRepository.existsByRg(any())).thenReturn(true);
        AraujoExeception araujoExeception = Assertions.assertThrows(
                AraujoExeception.class,
                () -> clienteService.cadastarCliente(cliente)
        );
        Assertions.assertEquals("RG já cadastrado", araujoExeception.getErrors().get("mensagem"));
        Assertions.assertEquals(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()), araujoExeception.getErrors().get("status"));
    }


}
