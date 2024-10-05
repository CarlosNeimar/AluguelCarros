package com.lab02.AluguelCarros.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.LinkedList;
import java.util.List;
import java.net.URI;

import com.lab02.AluguelCarros.dto.UsuarioLoginDTO;
import com.lab02.AluguelCarros.models.Cliente;
import com.lab02.AluguelCarros.models.Usuario;
import com.lab02.AluguelCarros.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {

    @Autowired
    private ClienteService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Cliente obj) {
        obj.setId(null); // Pois se vir com id, vai atualizar ao invés de criar um novo
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(obj.getId()).toUri(); // Para retornar a URL dessa nova Cliente salva no header
        return ResponseEntity.created(uri).build(); // .created() gerar status 201
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable Integer id) {
        obj.setId(id); // Para garantir que o ID da requisição é o mesmo do corpo
        Cliente objProcurado = service.find(id);
        obj.setNome( obj.getNome()!=null ? obj.getNome() : objProcurado.getNome() );
        obj.setLogin( obj.getLogin()!=null ? obj.getLogin() : objProcurado.getLogin() );
        obj.setSenha( obj.getSenha()!=null ? obj.getSenha() : objProcurado.getSenha() );
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.find(id);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Usuario> usuarios = service.findAll();
        List<Cliente> clientes = new LinkedList<Cliente>();
        for (Usuario usuario : usuarios) {
            try {
                clientes.add((Cliente) usuario);
            } catch (Exception e) {
                usuarios.remove(usuario);
            }
        }
        return ResponseEntity.ok().body(clientes);
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:5500") // Permite requisições do LiveServer
    public ResponseEntity<Cliente> login(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        String login = usuarioLoginDTO.getLogin();
        String senha = usuarioLoginDTO.getSenha();
        
        Cliente obj = service.findByLogin(login);

        ResponseEntity<Cliente> entity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if(obj.getSenha().equals(senha))
            entity = new ResponseEntity<Cliente>(obj, HttpStatus.CREATED);
        return entity;
    }

}
