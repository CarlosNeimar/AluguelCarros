package com.lab02.AluguelCarros.services;

import java.util.List;
import java.util.Optional;

import com.lab02.AluguelCarros.controllers.exceptions.DataIntegrityException;
import com.lab02.AluguelCarros.controllers.exceptions.ObjectNotFoundException;
import com.lab02.AluguelCarros.models.Veiculo;
import com.lab02.AluguelCarros.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    public Veiculo find(Integer id) {
        Optional<Veiculo> obj = repo.findById(id);
        return (Veiculo) obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
    }

    public Veiculo findByPlaca(String placa) {
        Optional<Veiculo> obj = repo.findByPlaca(placa);
        return (Veiculo) obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Placa: " + placa + ", Tipo: " + Veiculo.class.getName()));
    }

    public Veiculo insert(Veiculo obj) {
        obj.setId(null); // Pois se vir com id, vai atualizar ao invés de criar um novo
        return repo.save(obj);
    }

    public Veiculo update(Veiculo obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void deleteById(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um veículo que está associado a algum outro objeto.");
        }
    }

    public List<Veiculo> findAll() {
        return repo.findAll();
    }

}