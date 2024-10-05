package com.lab02.AluguelCarros.repositories;

import com.lab02.AluguelCarros.models.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
