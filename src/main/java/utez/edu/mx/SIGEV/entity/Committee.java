package utez.edu.mx.SIGEV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "committee")
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "colony", nullable = false)
    @NotNull(message = "La colonia no puede estar vacía")
    private Colony colony;

    public Committee() {
    }

    public Committee(Long id, Colony colony) {
        this.id = id;
        this.colony = colony;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colony getColony() {
        return colony;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }
}
