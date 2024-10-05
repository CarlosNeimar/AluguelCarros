package com.lab02.AluguelCarros.services;

import java.util.List;
import java.util.Optional;

import com.lab02.AluguelCarros.controllers.exceptions.DataIntegrityException;
import com.lab02.AluguelCarros.controllers.exceptions.ObjectNotFoundException;
import com.lab02.AluguelCarros.models.Pedido;
import com.lab02.AluguelCarros.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return (Pedido) obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null); // Pois se vir com id, vai atualizar ao invés de criar um novo
        return repo.save(obj);
    }

    public Pedido update(Pedido obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void deleteById(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um pedido que está associado a algum outro objeto.");
        }
    }

    public List<Pedido> findAll() {
        return repo.findAll();
    }

    

}