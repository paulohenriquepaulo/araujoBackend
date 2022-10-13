package app.controller;

import app.dto.produtoDto.ProdutoRequestDTO;
import app.dto.produtoDto.ProdutoResponseDTO;
import app.mapper.ProdutoMapper;
import app.model.Produto;
import app.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoMapper mapper;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@RequestBody @Valid ProdutoRequestDTO dto,
                                                               @RequestHeader("email") String email,
                                                               @RequestHeader("senha") String senha) {
        Produto novoProduto = mapper.toProduto(dto);
        service.cadastrarProduto(novoProduto, email, senha);
        return ResponseEntity.ok(mapper.toProdutoResponseDTO(novoProduto));
    }
}
