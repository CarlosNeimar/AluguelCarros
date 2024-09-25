package aluguelcarro.labdev.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = User.TABLE_NAME)
public abstract class User {
    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 60)
    private String password;

    // Construtor padrão
    public User() {}

    // Construtor com parâmetros (Long, String, String)
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) 
               && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
