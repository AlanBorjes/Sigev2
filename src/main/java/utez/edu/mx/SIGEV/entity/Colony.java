package utez.edu.mx.SIGEV.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "colony")
public class Colony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 150, nullable = false)
    @Size(min = 2, message = "El nombre debe contener mínimo 2 caracteres")
    @Size(max = 150, message = "El nombre debe contener máximo 150 caracteres")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @OneToOne
    @JoinColumn(name = "municipality", nullable = false)
    @NotNull(message = "La municipality no puede estar vacía")
    private Municipality municipality;

    public Colony() {
    }

    public Colony(Long id, String name, Municipality municipality) {
        this.id = id;
        this.name = name;
        this.municipality = municipality;
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

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
}
