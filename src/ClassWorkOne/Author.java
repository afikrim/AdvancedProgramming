package ClassWorkOne;

public class Author {
    private String name;
    private String biography;
    private String birthdate;

    public Author() {}

    public Author(String name, String biography, String birthdate) {
        this.name = name;
        this.biography = biography;
        this.birthdate = birthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void display() {
        System.out.println("================================");
        System.out.println("Name\t\t: " + name);
        System.out.println("Biography\t: " + biography);
        System.out.println("Birthdate\t: " + birthdate);
        System.out.println("================================");
    }
}
