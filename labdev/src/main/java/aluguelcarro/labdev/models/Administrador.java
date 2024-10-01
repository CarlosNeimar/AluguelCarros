package aluguelcarro.labdev.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador extends User {

    public Administrador() {
        super();
        this.setUserType(UserType.ADMIN);  // Definir o tipo como ADMIN
    }

    public Administrador(Long id, String username, String password) {
        super(id, username, password, UserType.ADMIN);
    }

    @Override
    public String toString() {
        return "Administrador{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", userType='" + getUserType() + "'" +
            "}";
    }
}
