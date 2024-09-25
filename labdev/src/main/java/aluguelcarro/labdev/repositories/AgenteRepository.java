package aluguelcarro.labdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluguelcarro.labdev.models.Agente;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long>{
  
}
