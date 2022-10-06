package app.repository;

import app.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository  extends JpaRepository<Pedidos, Long> {
}
