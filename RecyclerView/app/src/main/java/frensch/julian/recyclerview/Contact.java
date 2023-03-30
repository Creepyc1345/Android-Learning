package frensch.julian.recyclerview;

public class Contact {
    private String Name;
    private String Email;
    private String imageURL;

    public Contact(String name, String email, String imageURL) {
        Name = name;
        this.Email = email;
        this.imageURL = imageURL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
