package com.lab02.AluguelCarros.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario {
    private static final long serialVersionUID = 1L;

    private String nome;
  
    // @JsonIgnore // Caso não queira retornar os pedidos do cliente
    @OneToMany(mappedBy = "cliente") // Quer dizer que na classe Pedido, este cliente esta mapeado pelo atributo cliente
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String login, String senha) {
        super(id, login, senha);
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
