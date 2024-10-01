package aluguelcarro.labdev.controllers;

import aluguelcarro.labdev.models.Cliente;
import aluguelcarro.labdev.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        // Aqui, a instância de cliente deve incluir um userType definido
        Cliente novoCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }
}
