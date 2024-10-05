package com.lab02.AluguelCarros.repositories;

import javax.transaction.Transactional;

import com.lab02.AluguelCarros.models.Cliente;

@Transactional
public interface ClienteRepository extends UsuarioRepository<Cliente> {
}
