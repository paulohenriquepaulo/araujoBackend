package app.mapper;

import app.dto.categoriaDto.CategoriaRequestDTO;
import app.dto.categoriaDto.CategoriaResponseDTO;
import app.model.Categoria;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T14:50:09-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (IBM Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toCategoria(CategoriaRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setNome( dto.getNome() );

        return categoria;
    }

    @Override
    public CategoriaResponseDTO toCategoriaResponseDTO(Categoria cat) {
        if ( cat == null ) {
            return null;
        }

        CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO();

        categoriaResponseDTO.setId( cat.getId() );
        categoriaResponseDTO.setNome( cat.getNome() );

        return categoriaResponseDTO;
    }
}
