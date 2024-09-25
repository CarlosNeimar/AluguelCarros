package aluguelcarro.labdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluguelcarro.labdev.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
  
}
