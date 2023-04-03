package utez.edu.mx.SIGEV.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 150)
    @NotBlank(message="El nombre no puede estar vacio")
    @Size(min = 2, message="El mensaje debe ser minimo de 2 caracteres")
    @Size(max = 150, message="El mensaje debe ser maximo de 150 caracteres")
    private String description;

    @Column(name = "dateResgister", nullable = false)
    @NotNull(message = "La fecha de registro no puede estar vacía")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateResgister;
    @ManyToOne
    @JoinColumn(name = "state_incident", nullable = false)
    @NotNull(message="Este campo no puede estar vacio")
    private State_Incident stateIncident;
    @OneToOne
    @JoinColumn(name = "category", nullable = false)
    @NotNull(message="Este campo no puede estar vacio")
    private Category category;
    @OneToOne
    @JoinColumn(name = "committee", nullable = false)
    @NotNull(message="Este campo no puede estar vacio")
    private Committee committee;

    public Incident() {
    }

    public Incident(Long id, String description, Date dateResgister, State_Incident state_incident, Category category, Committee committee) {
        this.id = id;
        this.description = description;
        this.dateResgister = dateResgister;
        this.stateIncident = state_incident;
        this.category = category;
        this.committee = committee;
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

    public Date getDateResgister() {
        return dateResgister;
    }

    public void setDateResgister(Date dateResgister) {
        this.dateResgister = dateResgister;
    }

    public State_Incident getStateIncident() {
        return stateIncident;
    }

    public void setStateIncident(State_Incident state_incident) {
        this.stateIncident = state_incident;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }
}
