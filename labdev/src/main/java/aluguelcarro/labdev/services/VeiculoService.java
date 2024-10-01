package aluguelcarro.labdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aluguelcarro.labdev.models.Veiculo;
import aluguelcarro.labdev.repositories.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo createVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> findVeiculoById(Long id) {
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> findAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo updateVeiculo(Long id, Veiculo veiculoDetails) {
        Veiculo veiculo = veiculoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Veiculo not found with id " + id));

        veiculo.setMarca(veiculoDetails.getMarca());
        veiculo.setModelo(veiculoDetails.getModelo());
        veiculo.setMotor(veiculoDetails.getMotor());
        veiculo.setPotencia(veiculoDetails.getPotencia());
        veiculo.setAno(veiculoDetails.getAno());
        veiculo.setImagem(veiculoDetails.getImagem());
        return veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
