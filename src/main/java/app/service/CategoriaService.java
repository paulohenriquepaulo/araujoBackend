package app.service;

import app.model.Categoria;
import app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ClienteService service;

    public Categoria cadastrarCategoria(Categoria categoria, String email, String senha){
        service.validarLogin(email, senha);
        return repository.save(categoria);
    }
}
