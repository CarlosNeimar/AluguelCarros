package aluguelcarro.labdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aluguelcarro.labdev.models.Administrador;
import aluguelcarro.labdev.repositories.AdministradorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador createAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Optional<Administrador> findAdministradorById(Long id) {
        return administradorRepository.findById(id);
    }

    public List<Administrador> findAllAdministradores() {
        return administradorRepository.findAll();
    }

    public Administrador updateAdministrador(Long id, Administrador adminDetails) {
        Administrador admin = administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador not found with id " + id));
        admin.setUsername(adminDetails.getUsername());
        admin.setPassword(adminDetails.getPassword());
        return administradorRepository.save(admin);
    }

    public void deleteAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}
