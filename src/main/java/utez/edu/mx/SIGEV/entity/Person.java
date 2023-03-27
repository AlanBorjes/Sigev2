package utez.edu.mx.SIGEV.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 150, nullable = false)
    @Size(min = 2, message = "El nombre debe tener mínimo 2 caracteres")
    @Size(max = 150, message = "El nombre debe tener máximo 150 caracteres")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @Column(name = "lastname", length = 150, nullable = false)
    @Size(min = 2, message = "El primer apellido debe tener mínimo 2 caracteres")
    @Size(max = 150, message = "El primer apellido debe tener máximo 150 caracteres")
    @NotBlank(message = "El primer apellido no puede estar vacío")
    private String lastname;

    @Column(name = "surname", length = 150, nullable = true)
    @Size(max = 150, message = "El segundo apellido debe tener máximo 150 caracteres")
    private String surname;
    @Column(name = "phone", nullable = false, length = 10)
    @Size(min = 10, max = 10, message = "El teléfono debe tener mínimo 10 caracteres")
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String phone;
    @Column(name = "email", nullable = false, unique = true, length = 150)
    @Size(min = 7, message = "El correo debe tener mínimo 7 caracteres")
    @Size(max = 150, message = "El correo debe tener máximo 150 caracteres")
    @NotBlank(message = "El correo no puede estar vacío")
    private String email;
    @Column(name = "profilePhoto")
    private String profilePhoto;
    @OneToOne
    @JoinColumn(name = "committee")
    private Committee committee;
    @OneToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    public Person() {
    }

    public Person(Long id, String name, String lastname, String phone, String email, String profilePhoto, Committee committee, Municipality municipality) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.profilePhoto = profilePhoto;
        this.committee = committee;
        this.municipality = municipality;
    }

    public Person(Long id, String name, String lastname, String phone, String email, String profilePhoto, Committee committee) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.profilePhoto = profilePhoto;
        this.committee = committee;
    }

    public Person(Long id, String name, String lastname, String phone, String email, String profilePhoto) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.profilePhoto = profilePhoto;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
}
