package project.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Daniel Shchepetov on 19.04.2016.
 */

@Entity
@Table(name = "town")
public class Town implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private String town;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
