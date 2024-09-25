package aluguelcarro.labdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluguelcarro.labdev.models.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
  
}
