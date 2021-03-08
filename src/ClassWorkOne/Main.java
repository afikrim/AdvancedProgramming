package ClassWorkOne;

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
        Author authorA = new Author("Author A", "Biography", "1985-09-13");
        Author[] authors = {authorA};

        Book a = new Book("Book A", "Description of Book A", 2000, 0, Arrays.asList(authors));
        Book b = new Book("Book B", "Description of Book B", 2000, 0, Arrays.asList(authors));

        books.add(a);
        books.add(b);

        System.out.println(compareBook(a, b) + " %");
    }

    private static float compareBook(Book x, Book y) {
        String titleX = x.getTitle();
        String titleY = y.getTitle();

        int yangsama = 0;
        float percentage = 0;

        if (titleX.length() > titleY.length()) {
            for (int i = 0; i < titleY.length(); i++) {
                if (titleX.charAt(i) == titleY.charAt(i)) {
                    yangsama += 1;
                }
            }

            percentage = (float)yangsama / titleY.length() * 100;
        } else {
            for (int i = 0; i < titleX.length(); i++) {
                if (titleX.charAt(i) == titleY.charAt(i)) {
                    yangsama += 1;
                }
            }

            percentage = (float)yangsama / titleX.length() * 100;
        }

        return percentage;
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

        // TODO: insert author
        // System.out.println("Author(s) [Separate using comma (,) if more than one]: ");
        // in.nextLine();
        // String[] authors = in.nextLine().split(",");
        // x.setAuthors(Arrays.asList(authors));

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
