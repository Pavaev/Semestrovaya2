package project.model;

/**
 * Created by Daniel Shchepetov on 02.04.2016.
 */
public class Complaint {
    private int id;
    private String company = "Мяу Meow";
    private String imageURI = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Flatland_cover.jpg/200px-Flatland_cover.jpg";
    private String post;
    private String header;
    private int user_id;
    private String date;

    public Complaint() {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
