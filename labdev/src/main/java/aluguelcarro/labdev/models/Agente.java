package aluguelcarro.labdev.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "agentes")
public class Agente extends User {

    public Agente() {
        super();
        this.setUserType(UserType.AGENT);  // Definir o tipo como AGENT
    }

    public Agente(Long id, String username, String password) {
        super(id, username, password, UserType.AGENT);
    }

    @Override
    public String toString() {
        return "Agente{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", userType='" + getUserType() + "'" +
            "}";
    }
}
