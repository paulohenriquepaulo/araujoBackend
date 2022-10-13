package app.mapper;

import app.dto.categoriaDto.CategoriaResponseDTO;
import app.dto.produtoDto.ProdutoRequestDTO;
import app.dto.produtoDto.ProdutoResponseDTO;
import app.model.Categoria;
import app.model.Produto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T14:48:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (IBM Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto toProduto(ProdutoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setCategoria( produtoRequestDTOToCategoria( dto ) );
        produto.setNome( dto.getNome() );
        produto.setQuantidade( dto.getQuantidade() );
        produto.setValorUnitario( dto.getValorUnitario() );
        produto.setDescricao( dto.getDescricao() );
        produto.setImagemProduto( dto.getImagemProduto() );
        produto.setDisponibilidade( dto.getDisponibilidade() );

        return produto;
    }

    @Override
    public ProdutoResponseDTO toProdutoResponseDTO(Produto prod) {
        if ( prod == null ) {
            return null;
        }

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();

        produtoResponseDTO.setCategoria( categoriaToCategoriaResponseDTO( prod.getCategoria() ) );
        produtoResponseDTO.setCodProduto( prod.getCodProduto() );
        produtoResponseDTO.setNome( prod.getNome() );
        produtoResponseDTO.setQuantidade( prod.getQuantidade() );
        produtoResponseDTO.setValorUnitario( prod.getValorUnitario() );
        produtoResponseDTO.setDescricao( prod.getDescricao() );
        produtoResponseDTO.setImagemProduto( prod.getImagemProduto() );
        produtoResponseDTO.setDisponibilidade( prod.getDisponibilidade() );

        return produtoResponseDTO;
    }

    protected Categoria produtoRequestDTOToCategoria(ProdutoRequestDTO produtoRequestDTO) {
        if ( produtoRequestDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( produtoRequestDTO.getCategoria() );

        return categoria;
    }

    protected CategoriaResponseDTO categoriaToCategoriaResponseDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO();

        categoriaResponseDTO.setNome( categoria.getNome() );
        categoriaResponseDTO.setId( categoria.getId() );

        return categoriaResponseDTO;
    }
}
