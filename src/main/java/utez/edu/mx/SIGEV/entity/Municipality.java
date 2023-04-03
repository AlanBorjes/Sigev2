package utez.edu.mx.SIGEV.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;
@Entity
@Table(name = "municipality")
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 150, nullable = false)
    @Size(min = 2, message = "El nombre debe contener mínimo 2 caracteres")
    @Size(max = 150, message = "El nombre debe contener máximo 150 caracteres")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    public Municipality() {
    }

    public Municipality(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
