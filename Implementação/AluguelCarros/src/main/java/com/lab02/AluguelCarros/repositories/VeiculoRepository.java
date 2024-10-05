package com.lab02.AluguelCarros.repositories;

import java.util.Optional;

import com.lab02.AluguelCarros.models.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    @Query("select v from Veiculo v where v.placa = ?1")
    Optional<Veiculo> findByPlaca(String placa);
}
