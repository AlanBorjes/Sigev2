package utez.edu.mx.SIGEV.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 150, nullable = false)
    @Size(min = 2, message = "El email debe tener mínimo 2 caracteres")
    @Size(max = 150, message = "El email debe tener máximo 150 caracteres")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;
    @Column(name = "password", nullable = false, length = 255)
    @Size(min = 5, message = "La contraseña debe tener mínimo 5 caracteres")
    @Size(max = 255, message = "La contraseña debe tener máximo 255 caracteres")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
    @OneToOne
    @JoinColumn(name = "person", nullable = false)
    @NotNull(message = "La persona no puede estar vacía")
    private Person person;
    @OneToOne
    @JoinColumn(name = "StateUser", nullable = false)
    @NotNull(message = "La persona no puede estar vacía")
    private State_User state_user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "role"))
    @NotNull(message = "Los roles no pueden estar vacíos")
    private Set<Role> roles;


    public User() {
    }

    public User(Long id, String email, String password, Person person, State_User state_user) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.person = person;
        this.state_user = state_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public State_User getState_user() {
        return state_user;
    }

    public void setState_user(State_User state_user) {
        this.state_user = state_user;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
