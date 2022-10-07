package app.service;

import app.model.Produto;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ClienteService service;

    public Produto cadastrarProduto(Produto produto, String email, String senha) {
        service.validarLogin(email, senha);
        Produto p = new Produto();
        p = produto;
        return repository.save(p);
    }
}
