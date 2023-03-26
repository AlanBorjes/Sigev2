package utez.edu.mx.SIGEV.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "description", nullable = false, length = 150)
    @NotBlank(message="La decription no puede estar vacio")
    @Size(min = 2, message="La decription debe ser minimo de 2 caracteres")
    @Size(max = 150, message="La decription debe ser maximo de 150 caracteres")
    private String description;

    public Category(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    public Category() {
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
