package utez.edu.mx.SIGEV.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

@Entity
@Table(name = "StateUser")
public class State_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "desription", length = 150, nullable = false)
    @Size(min = 2, message = "El desription debe tener mínimo 2 caracteres")
    @Size(max = 150, message = "El desription debe tener máximo 150 caracteres")
    @NotBlank(message = "El desription no puede estar vacío")
    private String description;

    public State_User() {
    }

    public State_User(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "State_User{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
