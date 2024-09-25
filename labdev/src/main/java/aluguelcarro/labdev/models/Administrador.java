package aluguelcarro.labdev.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador extends User {

    public Administrador() {}

    public Administrador(Long id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "Administrador{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }
}
