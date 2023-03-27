package utez.edu.mx.SIGEV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
@Entity
@Table(name = "StateIncident")
public class State_Incident {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false, length = 150)
    @NotBlank(message="El description no puede estar vacio")
    @Size(min = 2, message="El description debe ser minimo de 2 caracteres")
    @Size(max = 150, message="El description debe ser maximo de 150 caracteres")
    private String description;

    public State_Incident() {
    }

    public State_Incident(Long id, String description) {
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
}
