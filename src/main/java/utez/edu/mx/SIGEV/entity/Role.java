package utez.edu.mx.SIGEV.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "authority", nullable = false, length = 150)
    @Size(min = 2, message = "El rol debe tener mínimo 2 caracteres")
    @Size(max = 150, message = "El rol debe tener máximo 150 caracteres")
    @NotBlank(message = "El rol no puede estar vacío")
    private String ROLE_NAME;

    public Role() {
    }

    public Role(Long id, String ROLE_NAME) {
        this.id = id;
        this.ROLE_NAME = ROLE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }
}
