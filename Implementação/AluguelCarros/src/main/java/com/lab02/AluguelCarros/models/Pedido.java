package com.lab02.AluguelCarros.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lab02.AluguelCarros.models.enums.PedidoStatus;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private PedidoStatus status;

    @ManyToOne
    @JoinColumn(name = "clienteid")
    @NotNull
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculoid")
    @NotNull
    private Veiculo veiculo;

    public Pedido() {
    }

    public Pedido(Integer id, PedidoStatus status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PedidoStatus getStatus() {
        return this.status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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
        if (!(obj instanceof Pedido))
            return false;
        Pedido other = (Pedido) obj;
        if (id == null)
            if (other.id != null)
                return false;
            else if (!id.equals(other.id))
                return false;
        return true;
    }
}
