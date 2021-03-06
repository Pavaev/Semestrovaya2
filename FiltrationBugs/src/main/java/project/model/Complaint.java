package project.model;


import org.hibernate.validator.constraints.*;


import javax.persistence.*;
import java.util.Objects;


/**
 * Created by Daniel Shchepetov on 02.04.2016.
 */
@Entity
@Table(name="complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Length(max = 100)
    @Column(nullable = false)
    private String company = "Мяу Meow";


    @Length(max = 255)
    @URL
    @Column
    private String imageURI = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Flatland_cover.jpg/200px-Flatland_cover.jpg";


    @Length(max = 255)
    @Column(nullable = false)
    private String post;


    @Length(max = 100)
    @Column(nullable = false)
    private String header;

    @Column
    private int user_id;

    @Column
    private String date;

    public Complaint() {
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.company);
        hash = 41 * hash + Objects.hashCode(this.imageURI);
        hash = 41 * hash + Objects.hashCode(this.post);
        hash = 41 * hash + Objects.hashCode(this.header);
        hash = 41 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complaint other = (Complaint) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.imageURI, other.imageURI)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.header, other.header)) {
            return false;
        }
        return true;
    }


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
