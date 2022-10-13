package app.mapper;

import app.dto.itensPedidosDto.ItensPedidosResponseDTO;
import app.dto.pedidosDto.PedidosRequestDTO;
import app.dto.pedidosDto.PedidosResponseDTO;
import app.model.ItemPedido;
import app.model.Pedidos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidosMapper {

    @Mapping(target = "itensPedidos", source = "pedidos")
    Pedidos toPedidos(PedidosRequestDTO dto);

    PedidosResponseDTO toPedidosResponseDTO(Pedidos ped);

    List<ItensPedidosResponseDTO> toListaPedidosResponseDTO(List<ItemPedido> pedidos);


}
