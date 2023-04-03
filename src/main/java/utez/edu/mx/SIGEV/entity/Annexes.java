package utez.edu.mx.SIGEV.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "annexes")
public class Annexes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(name = "data")
    private byte[] data;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "incident", nullable = false)
    @NotNull(message="Este campo no puede estar vacio")
    private Incident incident;

    public Annexes() {
    }

    public Annexes(int id,  byte[] data, String description) {
        this.id = id;
        this.data = data;
        this.description = description;
    }

    public Annexes(int id, byte[] data, String description, Incident incident) {
        this.id = id;
        this.data = data;
        this.description = description;
        this.incident = incident;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  byte[] getData() {
        return data;
    }

    public void setData( byte[] data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
