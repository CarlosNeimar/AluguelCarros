package com.lab02.AluguelCarros.services;

import java.util.List;
import java.util.Optional;

import com.lab02.AluguelCarros.controllers.exceptions.DataIntegrityException;
import com.lab02.AluguelCarros.controllers.exceptions.ObjectNotFoundException;
import com.lab02.AluguelCarros.models.Cliente;
import com.lab02.AluguelCarros.models.Usuario;
import com.lab02.AluguelCarros.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return (Cliente) obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente findByLogin(String login) {
        Optional<Usuario> obj = repo.findByLogin(login);
        return (Cliente) obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Login: " + login + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null); // Pois se vir com id, vai atualizar ao invés de criar um novo
        return repo.save(obj);
    }

    public Cliente update(Cliente obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void deleteById(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um cliente que está associado a algum outro objeto.");
        }
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

}