package com.lab02.AluguelCarros.dto;

public class PedidoNovoDTO {
    private Integer veiculoid;
    private Integer clienteid;
    private String status; // Adicione esta linha

    // Getters e Setters
    public Integer getVeiculoid() {
        return veiculoid;
    }

    public void setVeiculoid(Integer veiculoid) {
        this.veiculoid = veiculoid;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getStatus() { // Adicione este método
        return status;
    }

    public void setStatus(String status) { // Adicione este método
        this.status = status;
    }
}
