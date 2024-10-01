package aluguelcarro.labdev.controllers;

import aluguelcarro.labdev.models.Agente;
import aluguelcarro.labdev.services.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agentes")
public class AgenteController {

    @Autowired
    private AgenteService agenteService;

    @PostMapping
    public Agente createAgente(@RequestBody Agente agente) {
        return agenteService.createAgente(agente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agente> getAgenteById(@PathVariable Long id) {
        Optional<Agente> agente = agenteService.findAgenteById(id);
        return agente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Agente> getAllAgentes() {
        return agenteService.findAllAgentes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agente> updateAgente(@PathVariable Long id, @RequestBody Agente agenteDetails) {
        Agente updatedAgente = agenteService.updateAgente(id, agenteDetails);
        return ResponseEntity.ok(updatedAgente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgente(@PathVariable Long id) {
        agenteService.deleteAgente(id);
        return ResponseEntity.noContent().build();
    }
}
