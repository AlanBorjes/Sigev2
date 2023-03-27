package utez.edu.mx.SIGEV.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "contentApp")
public class ContentApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "imageLogin")
    private String imageLogin;
    @Column(name = "logo1", nullable = false)
    private String logo1;
    @Column(name = "logo2", nullable = false)
    private String logo2;
    @OneToOne
    @JoinColumn(name = "color", nullable = false)
    @NotNull(message = "La color no puede estar vacía")
    private Color color;

    public ContentApp() {
    }

    public ContentApp(Long id, String imageLogin, String logo1, String logo2, Color color) {
        this.id = id;
        this.imageLogin = imageLogin;
        this.logo1 = logo1;
        this.logo2 = logo2;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageLogin() {
        return imageLogin;
    }

    public void setImageLogin(String imageLogin) {
        this.imageLogin = imageLogin;
    }

    public String getLogo1() {
        return logo1;
    }

    public void setLogo1(String logo1) {
        this.logo1 = logo1;
    }

    public String getLogo2() {
        return logo2;
    }

    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
