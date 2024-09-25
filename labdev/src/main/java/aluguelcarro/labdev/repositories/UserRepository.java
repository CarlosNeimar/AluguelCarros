package aluguelcarro.labdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluguelcarro.labdev.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}
