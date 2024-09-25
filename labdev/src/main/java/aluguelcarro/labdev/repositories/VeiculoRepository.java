package aluguelcarro.labdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluguelcarro.labdev.models.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
  
}
