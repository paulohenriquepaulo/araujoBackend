package app.mapper;

import app.dto.categoriaDto.CategoriaRequestDTO;
import app.dto.categoriaDto.CategoriaResponseDTO;
import app.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    Categoria toCategoria(CategoriaRequestDTO dto);

    CategoriaResponseDTO toCategoriaResponseDTO(Categoria cat);


}
