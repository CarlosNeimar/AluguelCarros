package aluguelcarro.labdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aluguelcarro.labdev.models.Agente;
import aluguelcarro.labdev.repositories.AgenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    public Agente createAgente(Agente agente) {
        return agenteRepository.save(agente);
    }

    public Optional<Agente> findAgenteById(Long id) {
        return agenteRepository.findById(id);
    }

    public List<Agente> findAllAgentes() {
        return agenteRepository.findAll();
    }

    public Agente updateAgente(Long id, Agente agenteDetails) {
        Agente agente = agenteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agente not found with id " + id));

        agente.setUsername(agenteDetails.getUsername());
        agente.setPassword(agenteDetails.getPassword());
        return agenteRepository.save(agente);
    }

    public void deleteAgente(Long id) {
        agenteRepository.deleteById(id);
    }
}
