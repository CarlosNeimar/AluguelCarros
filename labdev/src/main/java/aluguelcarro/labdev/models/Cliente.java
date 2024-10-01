package aluguelcarro.labdev.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente extends User {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    public Cliente() {
        super();
        this.setUserType(UserType.CLIENT); // Define o tipo de usuário como CLIENT
    }

    public Cliente(Long id, String username, String password, List<Pedido> pedidos) {
        super(id, username, password, UserType.CLIENT); // Define o tipo de usuário como CLIENT
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", pedidos='" + getPedidos() + "'" +
            "}";
    }
}
