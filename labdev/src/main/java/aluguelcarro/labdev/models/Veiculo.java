package aluguelcarro.labdev.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", length = 100, nullable = false)
    @NotNull
    @Size(min = 2, max = 100)
    private String marca;

    @Column(name = "modelo", length = 100, nullable = false)
    @NotNull
    @Size(min = 2, max = 100)
    private String modelo;

    @Column(name = "motor", length = 100, nullable = false)
    @NotNull
    @Size(min = 2, max = 100)
    private String motor;

    @Column(name = "potencia", nullable = false)
    @NotNull
    private int potencia; 

    @Column(name = "ano", nullable = false)
    @NotNull
    private int ano;

    @Column(name = "imagem", length = 255)
    private String imagem; 

    // Relação Many-to-One entre Veiculo e Pedido
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    public Veiculo() {}

    public Veiculo(Long id, String marca, String modelo, String motor, int potencia, int ano, String imagem, Pedido pedido) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.potencia = potencia;
        this.ano = ano;
        this.imagem = imagem;
        this.pedido = pedido;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return this.motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", motor='" + motor + '\'' +
                ", potencia=" + potencia +
                ", ano=" + ano +
                ", imagem='" + imagem + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}
