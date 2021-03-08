package ClassWorkOne;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String description;
    private int year;
    private int categoryIndex;
    private ArrayList<String> authors = new ArrayList<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setAuthors(List<String> authors) {
        this.authors = new ArrayList<String>(authors);
    }

    public void addAuthor(String author) {
        this.authors.add(author);
    }

    public void removeAuthor(int authorIndex) {
        this.authors.remove(authorIndex);
    }

    private String prepareAuthors() {
        StringBuilder authors = new StringBuilder();

        for (String author: this.authors) {
            authors.append("\n\t- ");
            authors.append(author);
        }

        return authors.toString();
    }

    public void display(ArrayList<String> categories) {
        System.out.println("================================");
        System.out.println("Title\t\t: " + title);
        System.out.println("Description\t: " + description);
        System.out.println("Category\t: " + categories.get(categoryIndex));
        System.out.println("Year\t\t: " + year);
        System.out.println("Authors\t\t: " + prepareAuthors());
        System.out.println("================================");
    }
}
