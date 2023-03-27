package utez.edu.mx.SIGEV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "colorMain")
    private String colorMain;
    @Column(name = "colorSecundary")
    private String colorSecundary;
    @Column(name = "colorText")
    private String colorText;
    @Column(name = "colorTitle")
    private String colorTitle;

    public Color() {
    }

    public Color(Long id, String colorMain, String colorSecundary, String colorText, String colorTitle) {
        this.id = id;
        this.colorMain = colorMain;
        this.colorSecundary = colorSecundary;
        this.colorText = colorText;
        this.colorTitle = colorTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorMain() {
        return colorMain;
    }

    public void setColorMain(String colorMain) {
        this.colorMain = colorMain;
    }

    public String getColorSecundary() {
        return colorSecundary;
    }

    public void setColorSecundary(String colorSecundary) {
        this.colorSecundary = colorSecundary;
    }

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public String getColorTitle() {
        return colorTitle;
    }

    public void setColorTitle(String colorTitle) {
        this.colorTitle = colorTitle;
    }
}
