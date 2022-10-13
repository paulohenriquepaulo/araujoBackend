package app.mapper;

import app.dto.produtoDto.ProdutoRequestDTO;
import app.dto.produtoDto.ProdutoResponseDTO;
import app.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "categoria.id", source = "categoria")
    Produto toProduto(ProdutoRequestDTO dto);

    @Mapping(target = "categoria.nome", source = "categoria.nome")
    ProdutoResponseDTO toProdutoResponseDTO(Produto prod);

}
