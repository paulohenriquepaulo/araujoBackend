package app.mapper;

import app.dto.clienteDto.ClienteLoginResponseDTO;
import org.mapstruct.Mapper;

import app.dto.clienteDto.ClienteRequestDTO;
import app.dto.clienteDto.ClienteResponseDTO;
import app.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	Cliente toCliente(ClienteRequestDTO dto);

	ClienteResponseDTO toClienteResponseDTO(Cliente cli);

	ClienteLoginResponseDTO toClienteLoginResponseDTO(Cliente cli);
}
