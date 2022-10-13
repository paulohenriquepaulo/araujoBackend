package app.mapper;

import app.dto.pedidosDto.PedidosRequestDTO;
import app.dto.pedidosDto.PedidosResponseDTO;
import app.model.Pedidos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidosMapper {

    @Mapping(target = "itensPedidos", source = "pedidos")
   // @Mapping(target = "itensPedidos.produto.codProduto", source = "pedidos.codProduto")
    Pedidos toPedidos(PedidosRequestDTO dto);

    PedidosResponseDTO toPedidosResponseDTO(Pedidos ped);


}
