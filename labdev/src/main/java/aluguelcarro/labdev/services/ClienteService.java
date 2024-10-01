package aluguelcarro.labdev.services;

import aluguelcarro.labdev.models.Cliente;
import aluguelcarro.labdev.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente); // Asegure-se de que o cliente tem um userType definido
    }
}
