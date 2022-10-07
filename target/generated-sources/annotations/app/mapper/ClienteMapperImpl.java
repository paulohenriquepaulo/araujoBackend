package app.mapper;

import app.dto.clienteDto.ClienteLoginResponseDTO;
import app.dto.clienteDto.ClienteRequestDTO;
import app.dto.clienteDto.ClienteResponseDTO;
import app.dto.enderecoDto.EnderecoRequestDTO;
import app.dto.enderecoDto.EnderecoResponseDTO;
import app.model.Cliente;
import app.model.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T15:56:04-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (IBM Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toCliente(ClienteRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNome( dto.getNome() );
        cliente.setSobrenome( dto.getSobrenome() );
        cliente.setSenha( dto.getSenha() );
        cliente.setTelefone( dto.getTelefone() );
        cliente.setCpf( dto.getCpf() );
        cliente.setEmail( dto.getEmail() );
        cliente.setRg( dto.getRg() );
        cliente.setEnderecos( enderecoRequestDTOListToEnderecoList( dto.getEnderecos() ) );

        return cliente;
    }

    @Override
    public ClienteResponseDTO toClienteResponseDTO(Cliente cli) {
        if ( cli == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setId( cli.getId() );
        clienteResponseDTO.setNome( cli.getNome() );
        clienteResponseDTO.setSobrenome( cli.getSobrenome() );
        clienteResponseDTO.setSenha( cli.getSenha() );
        clienteResponseDTO.setTelefone( cli.getTelefone() );
        clienteResponseDTO.setCpf( cli.getCpf() );
        clienteResponseDTO.setEmail( cli.getEmail() );
        clienteResponseDTO.setRg( cli.getRg() );
        clienteResponseDTO.setEnderecos( enderecoListToEnderecoResponseDTOList( cli.getEnderecos() ) );

        return clienteResponseDTO;
    }

    @Override
    public ClienteLoginResponseDTO toClienteLoginResponseDTO(Cliente cli) {
        if ( cli == null ) {
            return null;
        }

        ClienteLoginResponseDTO clienteLoginResponseDTO = new ClienteLoginResponseDTO();

        clienteLoginResponseDTO.setId( cli.getId() );
        clienteLoginResponseDTO.setNome( cli.getNome() );
        clienteLoginResponseDTO.setSobrenome( cli.getSobrenome() );
        clienteLoginResponseDTO.setSenha( cli.getSenha() );
        clienteLoginResponseDTO.setTelefone( cli.getTelefone() );
        clienteLoginResponseDTO.setCpf( cli.getCpf() );
        clienteLoginResponseDTO.setEmail( cli.getEmail() );
        clienteLoginResponseDTO.setRg( cli.getRg() );

        return clienteLoginResponseDTO;
    }

    protected Endereco enderecoRequestDTOToEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        if ( enderecoRequestDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setCep( enderecoRequestDTO.getCep() );
        endereco.setCidade( enderecoRequestDTO.getCidade() );
        endereco.setBairro( enderecoRequestDTO.getBairro() );
        endereco.setRua( enderecoRequestDTO.getRua() );
        endereco.setUf( enderecoRequestDTO.getUf() );
        endereco.setNumero( enderecoRequestDTO.getNumero() );
        endereco.setComplemento( enderecoRequestDTO.getComplemento() );

        return endereco;
    }

    protected List<Endereco> enderecoRequestDTOListToEnderecoList(List<EnderecoRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Endereco> list1 = new ArrayList<Endereco>( list.size() );
        for ( EnderecoRequestDTO enderecoRequestDTO : list ) {
            list1.add( enderecoRequestDTOToEndereco( enderecoRequestDTO ) );
        }

        return list1;
    }

    protected EnderecoResponseDTO enderecoToEnderecoResponseDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();

        enderecoResponseDTO.setCep( endereco.getCep() );
        enderecoResponseDTO.setCidade( endereco.getCidade() );
        enderecoResponseDTO.setBairro( endereco.getBairro() );
        enderecoResponseDTO.setRua( endereco.getRua() );
        if ( endereco.getUf() != null ) {
            enderecoResponseDTO.setUf( endereco.getUf().name() );
        }
        enderecoResponseDTO.setNumero( endereco.getNumero() );
        enderecoResponseDTO.setComplemento( endereco.getComplemento() );

        return enderecoResponseDTO;
    }

    protected List<EnderecoResponseDTO> enderecoListToEnderecoResponseDTOList(List<Endereco> list) {
        if ( list == null ) {
            return null;
        }

        List<EnderecoResponseDTO> list1 = new ArrayList<EnderecoResponseDTO>( list.size() );
        for ( Endereco endereco : list ) {
            list1.add( enderecoToEnderecoResponseDTO( endereco ) );
        }

        return list1;
    }
}
