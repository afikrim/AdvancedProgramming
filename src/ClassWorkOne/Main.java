package ClassWorkOne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> books = new ArrayList<>();
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

    private static void initBooks() {
        Book a = new Book();
        Book b = new Book();
        Book c = new Book();
        Book d = new Book();
        Book e = new Book();
        Book f = new Book();
        Book g = new Book();

        a.setTitle("Book A");
        a.setDescription("Description of Book A");
        a.setYear(2000);
        a.setCategoryIndex(0);
        a.addAuthor("Author A");

        b.setTitle("Book B");
        b.setDescription("Description of Book B");
        b.setYear(2000);
        b.setCategoryIndex(1);
        b.addAuthor("Author B");

        c.setTitle("Book C");
        c.setDescription("Description of Cook C");
        c.setYear(2000);
        c.setCategoryIndex(2);
        c.addAuthor("Author C");

        d.setTitle("Book D");
        d.setDescription("Description of Dook D");
        d.setYear(2000);
        d.setCategoryIndex(3);
        d.addAuthor("Author D");
        d.addAuthor("Author A");

        e.setTitle("Book E");
        e.setDescription("Description of Eook E");
        e.setYear(2000);
        e.setCategoryIndex(4);
        e.addAuthor("Author E");

        f.setTitle("Book F");
        f.setDescription("Description of Fook F");
        f.setYear(2000);
        f.setCategoryIndex(5);
        f.addAuthor("Author F");

        g.setTitle("Book G");
        g.setDescription("Description of Gook G");
        g.setYear(2000);
        g.setCategoryIndex(6);
        g.addAuthor("Author E");
        g.addAuthor("Author F");
        g.addAuthor("Author G");

        books.add(a);
        books.add(b);
        books.add(c);
        books.add(d);
        books.add(e);
        books.add(f);
        books.add(g);
    }

    private static void newCategory() {
        printCategories();

        System.out.print("Name\t: ");
        in.nextLine();
        String x = in.nextLine();

        categories.add(x);
    }

    private static void newBook() {
        Book x = new Book();

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

        System.out.println("Author(s) [Separate using comma (,) if more than one]: ");
        in.nextLine();
        String[] authors = in.nextLine().split(",");
        x.setAuthors(Arrays.asList(authors));

        x.display(categories);

        books.add(x);
    }

    private static void printCategories() {
        System.out.println("================================");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        System.out.println("================================");
    }

    private static void printBooks() {
        System.out.println("================================");
        for (int i = 0; i < books.size(); i++) {
            Book x = books.get(i);

            System.out.println((i + 1) + ". " + x.getTitle()
                + " [" + categories.get(x.getCategoryIndex()) + "]");
        }
        System.out.println("================================");
    }

    private static void printBookDetail(int index) {
        Book x = books.get(index);

        x.display(categories);
    }

    private static void menu() {
        System.out.println("================================");
        System.out.println("      LIBRARY APPLICATION");
        System.out.println("================================");
        System.out.println("1. Show all books");
        System.out.println("2. Show all categories");
        System.out.println("3. Show book detail");
        System.out.println("4. Add new book");
        System.out.println("5. Add new category");
        System.out.println("6. Exit");
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
                printBooks();
                System.out.print("Book number: ");
                int bookIndex = in.nextInt();
                printBookDetail(bookIndex - 1);
                break;
            case 4:
                newBook();
                break;
            case 5:
                newCategory();
                break;
            case 6:
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
        initBooks();

        while (running) {
            menu();
        }
    }
}
