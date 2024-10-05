package com.lab02.AluguelCarros.controllers;

import java.util.List;
import java.net.URI;


import com.lab02.AluguelCarros.models.Veiculo;
import com.lab02.AluguelCarros.services.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/veiculos")
@CrossOrigin(origins = "http://localhost:5173")
public class VeiculoController {

    @Autowired
    private VeiculoService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Veiculo obj) {
        obj.setId(null); // Pois se vir com id, vai atualizar ao invés de criar um novo
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(obj.getId()).toUri(); // Para retornar a URL dessa nova Veiculo salva no header
        return ResponseEntity.created(uri).build(); // .created() gerar status 201
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.find(id);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Veiculo> buscar(@PathVariable Integer id) {
        Veiculo obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Veiculo>> buscarTodos() {
        List<Veiculo> veiculos = service.findAll();
        return ResponseEntity.ok().body(veiculos);
    }

}
