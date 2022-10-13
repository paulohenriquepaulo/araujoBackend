package app.service;

import app.model.Produto;
import app.repository.CategoriaRepository;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ClienteService service;

    public Produto cadastrarProduto(Produto produto, String email, String senha) {
        // Validação de login do cliente
        service.validarLogin(email, senha);
        // Buscando nome da categoria e atribuindo a resposta
        String nome = categoriaRepository.getNomeById(produto.getCategoria().getId());
        produto.getCategoria().setNome(nome);

        return repository.save(produto);
    }
}
