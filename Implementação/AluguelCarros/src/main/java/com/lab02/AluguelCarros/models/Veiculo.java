package com.lab02.AluguelCarros.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.NonNull;

@Entity
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String placa;
    private String marca;
    private String modelo;
    
    @OneToMany(mappedBy = "veiculo")
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(Integer id, String placa, String marca, String modelo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Veiculo))
            return false;
        Veiculo other = (Veiculo) obj;
        if (id == null)
            if (other.id != null)
                return false;
        else if (!id.equals(other.id))
            return false;
        return true;
    }
}
