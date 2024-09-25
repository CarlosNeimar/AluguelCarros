package aluguelcarro.labdev.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @Column(name = "status")
    private String status;

    // Relação One-to-Many entre Pedido e Veiculo
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Veiculo> veiculos;

    public Pedido() {}

    public Pedido(Long id, Cliente cliente, List<Veiculo> veiculos) {
        this.id = id;
        this.cliente = cliente;
        this.veiculos = veiculos;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", status='" + status + '\'' +
                ", veiculos=" + veiculos +
                '}';
    }
}
