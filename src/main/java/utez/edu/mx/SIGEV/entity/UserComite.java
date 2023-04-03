package utez.edu.mx.SIGEV.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserComite {
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
    
    @Column(name = "username", nullable = false, length = 250, unique = true)
    private String username;
    @OneToOne
    @JoinColumn(name = "person", nullable = false)
    @NotNull(message = "La persona no puede estar vacía")
    private Person person;
    @OneToOne
    @JoinColumn(name = "StateUser", nullable = false)
    @NotNull(message = "La persona no puede estar vacía")
    private State_User state_user;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
    @ManyToMany
    @JoinTable(
            name = "authorities",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private Set<Role> roles = new HashSet<Role>();


    public UserComite() {
    }

    public UserComite(Long id, String email, String password, Person person, State_User state_user) {
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
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setState_user(State_User state_user) {
        this.state_user = state_user;
    }

    public Boolean getEnabled() {
        return enabled;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
