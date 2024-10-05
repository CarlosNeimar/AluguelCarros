package com.lab02.AluguelCarros.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Inheritance
@Entity
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    protected String login;
    @NotNull
    // @JsonIgnore
    protected String senha;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // @JsonIgnore
    public String getSenha() {
        return this.senha;
    }

    @JsonProperty
    public void setSenha(String senha) {
        this.senha = senha;
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
        if (!(obj instanceof Usuario))
            return false;
        Usuario other = (Usuario) obj;
        if (id == null)
            if (other.id != null)
                return false;
        else if (!id.equals(other.id))
            return false;
        return true;
    }
}
