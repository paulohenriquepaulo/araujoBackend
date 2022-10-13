package app.mapper;

import app.dto.pedidosDto.PedidosRequestDTO;
import app.dto.pedidosDto.PedidosResponseDTO;
import app.model.Pedidos;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T10:23:11-0300",
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
}
