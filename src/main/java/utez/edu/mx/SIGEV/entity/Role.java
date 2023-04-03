package utez.edu.mx.SIGEV.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "authority", nullable = false, length = 150)
    @Size(min = 2, message = "El rol debe tener mínimo 2 caracteres")
    @Size(max = 150, message = "El rol debe tener máximo 150 caracteres")
    @NotBlank(message = "El rol no puede estar vacío")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserComite> users;

    public Role() {
    }

    public Role(Long id, String name) {
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
