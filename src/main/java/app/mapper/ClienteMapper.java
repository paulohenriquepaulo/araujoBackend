package app.mapper;

import org.mapstruct.Mapper;

import app.dto.ClienteDTO;
import app.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	Cliente toCliente(ClienteDTO dto);

	ClienteDTO toClienteDTO(Cliente cli);

}
