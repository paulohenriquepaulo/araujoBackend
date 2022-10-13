package app.controller;

import app.dto.categoriaDto.CategoriaRequestDTO;
import app.dto.categoriaDto.CategoriaResponseDTO;
import app.mapper.CategoriaMapper;
import app.model.Categoria;
import app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private CategoriaMapper mapper;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> cadastrarCategoria(@RequestBody @Valid CategoriaRequestDTO dto,
                                                                   @RequestHeader("email") String email,
                                                                   @RequestHeader("senha") String senha) {
        Categoria novaCategoria = service.cadastrarCategoria(mapper.toCategoria(dto), email, senha);
        return ResponseEntity.ok(mapper.toCategoriaResponseDTO(novaCategoria));
    }
}
