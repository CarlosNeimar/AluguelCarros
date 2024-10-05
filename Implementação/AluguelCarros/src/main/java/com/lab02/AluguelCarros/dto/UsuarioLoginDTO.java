package com.lab02.AluguelCarros.dto;

public class UsuarioLoginDTO {
    
    private String login;
    private String senha;

    public UsuarioLoginDTO() {
    }

    public UsuarioLoginDTO(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.login == null) ? 0 : this.login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UsuarioLoginDTO))
            return false;
        UsuarioLoginDTO other = (UsuarioLoginDTO) obj;
        if (login == null)
            if (other.login != null)
                return false;
        else if (!login.equals(other.login))
            return false;
        return true;
    }

}
