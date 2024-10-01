package aluguelcarro.labdev.controllers;

import aluguelcarro.labdev.models.Cliente;
import aluguelcarro.labdev.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = userRepository.save(cliente);
        return ResponseEntity.ok(savedCliente);
    }
}
