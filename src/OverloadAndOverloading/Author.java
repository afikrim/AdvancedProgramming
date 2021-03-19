package OverloadAndOverloading;

public class Author {
    private String name;
    private String penName;
    private String biography;

    public Author() {}

    /**
     * Constructor
     * 
     * @param name
     * @param penName
     * @param biography
     */
    public Author(String name, String penName, String biography) {
        this.name = name;
        this.penName = penName;
        this.biography = biography;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the penName
     */
    public String getPenName() {
        return penName;
    }

    /**
     * @param penName the penName to set
     */
    public void setPenName(String penName) {
        this.penName = penName;
    }

    /**
     * @return the biography
     */
    public String getBiography() {
        return biography;
    }

    /**
     * @param biography the biography to set
     */
    public void setBiography(String biography) {
        this.biography = biography;
    }

    /**
     * Method to display author details.
     * 
     * @param books
     * @param categories
     */
    public void display() {
        System.out.println("================================");
        System.out.println("Name\t\t: " + name);
        System.out.println("Pen Name\t: " + penName);
        System.out.println("Biography\t: " + biography);
        System.out.println("================================");
    } 
}
