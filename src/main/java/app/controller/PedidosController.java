package app.controller;

import app.dto.pedidosDto.PedidosRequestDTO;
import app.dto.pedidosDto.PedidosResponseDTO;
import app.mapper.PedidosMapper;
import app.model.Pedidos;
import app.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    private PedidosService service;

    @Autowired
    private PedidosMapper mapper;

    @PostMapping
    public ResponseEntity<PedidosResponseDTO> cadastrarPedido(@RequestBody PedidosRequestDTO dto, @RequestHeader("email") String email,
                                                              @RequestHeader("senha") String senha) {
        Pedidos novoPedido = service.cadastrarPedidos(dto, email, senha);
        PedidosResponseDTO pedidosResponseDTO = mapper.toPedidosResponseDTO(novoPedido);
        pedidosResponseDTO.setPedidos(mapper.toListaPedidosResponseDTO(novoPedido.getItensPedidos()));
        return ResponseEntity.ok(pedidosResponseDTO);

    }


}
