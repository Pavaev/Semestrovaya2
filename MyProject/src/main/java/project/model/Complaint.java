package project.model;

/**
 * Created by Daniel Shchepetov on 02.04.2016.
 */
public class Complaint {
    private String name;
    private String imageURI;
    private String text;
    private String header;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


        public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
