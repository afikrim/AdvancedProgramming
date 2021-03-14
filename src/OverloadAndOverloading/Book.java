package OverloadAndOverloading;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String description;
    private int year;
    private int categoryIndex;
    private ArrayList<Integer> authorIndexes = new ArrayList<>();

    public Book() {}

    /**
     * Constructor to init book object
     * 
     * @param title
     * @param description
     * @param year
     * @param categoryIndex
     * @param authorIndexes
     */
    public Book(String title, String description, int year, int categoryIndex, List<Integer> authorIndexes) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.categoryIndex = categoryIndex;
        this.authorIndexes = new ArrayList<>(authorIndexes);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the categoryIndex
     */
    public int getCategoryIndex() {
        return categoryIndex;
    }

    /**
     * @param categoryIndex the categoryIndex to set
     */
    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    /**
     * @return the authors
     */
    public List<Integer> getAuthorIndexes() {
        return authorIndexes;
    }

    /**
     * @param authorIndexes the author indexes to set
     */
    public void setAuthorIndexes(List<Integer> authorIndexes) {
        this.authorIndexes = new ArrayList<>(authorIndexes);
    }

    /**
     * @param authorIndex the author index to add
     */
    public void addAuthorIndex(int authorIndex) {
        this.authorIndexes.add(authorIndex);
    }

    private String prepareAuthors(List<Author> authors) {
        StringBuilder authorsString = new StringBuilder();

        for (int i = 0; i < authors.size(); i += 1) {
            if (!authorIndexes.contains(i)) continue;
            Author author = authors.get(i);

            authorsString.append("\n\t- ");
            authorsString.append(author.getName());
            authorsString.append(" [");
            authorsString.append(author.getPenName());
            authorsString.append("]");
        }

        return authorsString.toString();
    }

    public void display(List<String> categories, List<Author> authors) {
        System.out.println("================================");
        System.out.println("Title\t\t: " + title);
        System.out.println("Description\t: " + description);
        System.out.println("Category\t: " + categories.get(categoryIndex));
        System.out.println("Year\t\t: " + year);
        System.out.println("Authors\t\t: " + prepareAuthors(authors));
        System.out.println("================================");
    }
}
