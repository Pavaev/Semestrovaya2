package project.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;


    @Column(nullable = false)
    @Length(max = 100)
    @NotBlank(message = "First Name cannot be empty")
    private String firstName="Иван";

    @Column(nullable = false)
    @Length(max = 100)
    @NotBlank(message = "Last Name cannot be empty")
    private String lastName="Иванов";

    @Column
    private String midName="Иванович";

    @Column
    private String birth;

    @Email(message = "This email is not valid")
    @NotBlank(message = "Email cannot be empty")
    @Column(nullable = false)
    @Length(max=36)
    private String email="28530@mail.ru";

    @NotBlank(message = "Password cannot be empty")
    @Column(nullable = false)
    @Length(max=30)
    private String password="12345";

    @Column
    private String phone="88005553535";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "town", referencedColumnName="id", nullable = false)
    private Town town;


    @Column
    private String sex;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
