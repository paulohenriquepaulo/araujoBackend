package app.mapper;

import app.dto.itensPedidosDto.ItensPedidosRequestDTO;
import app.dto.pedidosDto.PedidosRequestDTO;
import app.dto.pedidosDto.PedidosResponseDTO;
import app.model.ItemPedido;
import app.model.Pedidos;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T14:48:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (IBM Corporation)"
)
@Component
public class PedidosMapperImpl implements PedidosMapper {

    @Override
    public Pedidos toPedidos(PedidosRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pedidos pedidos = new Pedidos();

        pedidos.setItensPedidos( itensPedidosRequestDTOListToItemPedidoList( dto.getPedidos() ) );

        return pedidos;
    }

    @Override
    public PedidosResponseDTO toPedidosResponseDTO(Pedidos ped) {
        if ( ped == null ) {
            return null;
        }

        PedidosResponseDTO pedidosResponseDTO = new PedidosResponseDTO();

        pedidosResponseDTO.setId( ped.getId() );
        pedidosResponseDTO.setValorTotal( ped.getValorTotal() );
        pedidosResponseDTO.setStatus( ped.getStatus() );

        return pedidosResponseDTO;
    }

    protected ItemPedido itensPedidosRequestDTOToItemPedido(ItensPedidosRequestDTO itensPedidosRequestDTO) {
        if ( itensPedidosRequestDTO == null ) {
            return null;
        }

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setQuantidade( itensPedidosRequestDTO.getQuantidade() );

        return itemPedido;
    }

    protected List<ItemPedido> itensPedidosRequestDTOListToItemPedidoList(List<ItensPedidosRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemPedido> list1 = new ArrayList<ItemPedido>( list.size() );
        for ( ItensPedidosRequestDTO itensPedidosRequestDTO : list ) {
            list1.add( itensPedidosRequestDTOToItemPedido( itensPedidosRequestDTO ) );
        }

        return list1;
    }
}
