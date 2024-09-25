package aluguelcarro.labdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluguelcarro.labdev.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
  
}
