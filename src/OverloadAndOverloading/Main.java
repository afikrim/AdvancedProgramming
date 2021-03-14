package OverloadAndOverloading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String SEPARATOR = "================================";
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Author> authors = new ArrayList<>();
    private static ArrayList<String> categories = new ArrayList<>();

    private static boolean running = false;

    private static Scanner in = new Scanner(System.in);

    private static void initCategories() {
        categories.add("Teknologi");
        categories.add("Filsafat");
        categories.add("Sejarah");
        categories.add("Agama");
        categories.add("Psikologi");
        categories.add("Politik");
        categories.add("Fiksi");
    }

    private static void initAuthors() {
        Author a = new Author("Author A", "A", "Biography of author A");
        Author b = new Author("Author B", "B", "Biography of author B");
        Author c = new Author("Author C", "C", "Biography of author C");
        Author d = new Author("Author D", "D", "Biography of author D");
        Author e = new Author("Author E", "E", "Biography of author E");

        authors.add(a);
        authors.add(b);
        authors.add(c);
        authors.add(d);
        authors.add(e);
    }

    private static void initBooks() {
        List<Integer> bookAAuthors = new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> bookBAuthors = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> bookCAuthors = new ArrayList<>(Arrays.asList(3));
        List<Integer> bookDAuthors = new ArrayList<>(Arrays.asList(1, 4));
        List<Integer> bookEAuthors = new ArrayList<>(Arrays.asList(0, 1, 3));
        List<Integer> bookFAuthors = new ArrayList<>(Arrays.asList(2));
        List<Integer> bookGAuthors = new ArrayList<>(Arrays.asList(3));

        Book a = new Book("Book A", "Description of Book A", 2000, 0, bookAAuthors);
        Book b = new Book("Book B", "Description of Book B", 2000, 1, bookBAuthors);
        Book c = new Book("Book C", "Description of Book C", 2000, 2, bookCAuthors);
        Book d = new Book("Book D", "Description of Book D", 2000, 3, bookDAuthors);
        Book e = new Book("Book E", "Description of Book E", 2000, 4, bookEAuthors);
        Book f = new Book("Book F", "Description of Book F", 2000, 5, bookFAuthors);
        Book g = new Book("Book G", "Description of Book G", 2000, 6, bookGAuthors);

        books.add(a);
        books.add(b);
        books.add(c);
        books.add(d);
        books.add(e);
        books.add(f);
        books.add(g);
    }

    private static void printCategories() {
        System.out.println(SEPARATOR);
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        System.out.println(SEPARATOR);
    }

    private static void printAuthors() {
        System.out.println(SEPARATOR);
        for (int i = 0; i < authors.size(); i++) {
            System.out.println((i + 1) + ". " + authors.get(i).getName()
                + " [" + authors.get(i).getPenName() + "]");
        }
        System.out.println(SEPARATOR);
    }

    private static void printBooks() {
        System.out.println(SEPARATOR);
        for (int i = 0; i < books.size(); i++) {
            Book x = books.get(i);

            System.out.println((i + 1) + ". " + x.getTitle()
                + " [" + categories.get(x.getCategoryIndex()) + "]");
        }
        System.out.println(SEPARATOR);
    }

    private static void printBookDetail(int index) {
        Book x = books.get(index);

        x.display(categories, authors);
    }

    private static void printAuthorDetail(int index) {
        Author x = authors.get(index);

        x.display();
    }

    private static void newBook() {
        Book x = new Book();
        List<Integer> authorIndexes = new ArrayList<>();

        printBooks();

        System.out.print("Title\t\t: ");
        in.nextLine();
        x.setTitle(in.nextLine());
        System.out.print("Description\t: ");
        x.setDescription(in.nextLine());
        System.out.print("Year\t\t: ");
        x.setYear(in.nextInt());

        printCategories();

        System.out.print("Category\t: ");
        x.setCategoryIndex(in.nextInt() - 1);

        printAuthors();

        System.out.println("Author(s) [Separate using comma (,) if more than one]: ");
        in.nextLine();
        String[] authorIndexesString = in.nextLine().split(",");

        for (String authorIndexString: authorIndexesString) {
            authorIndexes.add(Integer.parseInt(authorIndexString));
        }

        x.setAuthorIndexes(authorIndexes);

        x.display(categories, authors);

        books.add(x);
    }

    private static void newCategory() {
        printCategories();

        System.out.print("Name\t: ");
        in.nextLine();
        String x = in.nextLine();

        categories.add(x);
    }

    private static void newAuthor() {
        Author x = new Author();

        printAuthors();

        System.out.print("Name\t\t: ");
        in.nextLine();
        x.setName(in.nextLine());
        System.out.print("Pen Name\t: ");
        x.setPenName(in.nextLine());
        System.out.print("Bio\t\t: ");
        x.setBiography(in.nextLine());

        authors.add(x);
    }

    private static float compareBooks(Book x, Book y) {
        float samePercentage = 0;

        // compare book title
        samePercentage += compareBooksTitle(x.getTitle(), y.getTitle());

        // compare book description
        samePercentage += compareBooksDescription(x.getDescription(), y.getDescription());

        // divide sum from samePercentage in compare title and compare description
        samePercentage /= 2;

        // times 10000 to pick 4 characters after comma (,)
        // example: 0.9812124 => 9812.124
        samePercentage *= 10000;

        // round up samePercentage
        // example: 9812.124 => 9812
        samePercentage = Math.round(samePercentage);

        // divide to get in percent
        // example: 9812 => 98.12 === 98.12 %
        samePercentage /= 100;

        // return percentage
        return samePercentage;
    }

    private static float compareBooksTitle(String x, String y) {
        int xLen = x.length();
        int yLen = y.length();

        int sameChars = 0;

        float samePercentage = 0;

        if (xLen > yLen) {
            for (int i = 0; i < yLen; i += 1) {
                if (x.charAt(i) == y.charAt(i)) sameChars += 1;
            }

            samePercentage = (float) sameChars / xLen;
        } else {
            for (int i = 0; i < xLen; i += 1) {
                if (x.charAt(i) == y.charAt(i)) sameChars += 1;
            }

            samePercentage = (float) sameChars / yLen;
        }

        return samePercentage;
    }

    private static float compareBooksDescription(String x, String y) {
        int xLen = x.length();
        int yLen = y.length();

        int sameChars = 0;

        float samePercentage = 0;

        if (xLen > yLen) {
            for (int i = 0; i < yLen; i += 1) {
                if (x.charAt(i) == y.charAt(i)) sameChars += 1;
            }

            samePercentage = (float) sameChars / xLen;
        } else {
            for (int i = 0; i < xLen; i += 1) {
                if (x.charAt(i) == y.charAt(i)) sameChars += 1;
            }

            samePercentage = (float) sameChars / yLen;
        }

        return samePercentage;
    }

    private static void menu() {
        System.out.println(SEPARATOR);
        System.out.println("      LIBRARY APPLICATION");
        System.out.println(SEPARATOR);
        System.out.println("1. Show all books");
        System.out.println("2. Show all categories");
        System.out.println("3. Show all authors");
        System.out.println("4. Show book detail");
        System.out.println("5. Show author detail");
        System.out.println("6. Compare 2 books");
        System.out.println("7. Add new book");
        System.out.println("8. Add new category");
        System.out.println("9. Add new author");
        System.out.println("0. Exit");
        System.out.print("What is your choice? ");
        int index = in.nextInt();

        switchCase(index);
    }

    private static void switchCase(int index) {
        System.out.println("\n");

        switch (index) {
            case 1:
                printBooks();
                break;
            case 2:
                printCategories();
                break;
            case 3:
                printAuthors();
                break;
            case 4:
                printBooks();
                System.out.print("Book number: ");
                int bookIndex = in.nextInt();
                printBookDetail(bookIndex - 1);
                break;
            case 5:
                printAuthors();
                System.out.print("Author number: ");
                int authorIndex = in.nextInt();
                printAuthorDetail(authorIndex - 1);
                break;
            case 6:
                printBooks();
                System.out.print("Book 1: ");
                int xIndex = in.nextInt();
                System.out.print("Book 2: ");
                int yIndex = in.nextInt();
                float samePercentage = compareBooks(books.get(xIndex - 1), books.get(yIndex - 1));
                System.out.println("Same Percentage: " + samePercentage + " %");
                break;
            case 7:
                newBook();
                break;
            case 8:
                newCategory();
                break;
            case 9:
                newAuthor();
                break;
            case 0:
                running = false;
                break;
            default:
                System.out.println("We deeply apologize for the inconvenient, but this choice (" + index + ") still not available.");
        }

        System.out.println("\n");
    }

    public static void main (String[] args) {
        running = true;

        initCategories();
        initAuthors();
        initBooks();

        while (running) {
            menu();
        }
    }
}
