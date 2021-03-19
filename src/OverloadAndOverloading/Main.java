package OverloadAndOverloading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DEFAULT_ERROR = "Oops! Something went wrong.";
    private static final String FILE_NOT_FOUND = "File not found, please make sure that the path is right.";
    private static final String SEPARATOR = "================================";
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Author> authors = new ArrayList<>();
    private static ArrayList<String> categories = new ArrayList<>();

    private static boolean running = false;

    private static Scanner in = new Scanner(System.in);

    private static void initCategories() {
        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/OverloadAndOverloading/listCategories.txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                categories.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(DEFAULT_ERROR);
        }
    }

    private static void saveCategories() {
        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/OverloadAndOverloading/listCategories.txt";
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);

            for (String category : categories) {
                bw.write(category);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(DEFAULT_ERROR);
        }
    }

    private static void initAuthors() {
        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/OverloadAndOverloading/listAuthors.txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] authorData = line.split(";");

                authors.add(new Author(authorData[0], authorData[1], authorData[2]));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(DEFAULT_ERROR);
        }
    }

    private static void saveAuthors() {
        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/OverloadAndOverloading/listAuthors.txt";
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Author author : authors) {
                bw.write(author.getName() + ";" + author.getPenName() + ";" + author.getBiography());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(DEFAULT_ERROR);
        }
    }

    private static void initBooks() {
        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/OverloadAndOverloading/listBooks.txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(";");

                List<String> bookDataAuthors = new ArrayList<>(Arrays.asList(bookData[3].split(",")));
                List<Integer> authorIndexes = new ArrayList<>();

                for (int i = 0; i < authors.size(); i += 1) {
                    if (bookDataAuthors.contains(authors.get(i).getName()))
                        authorIndexes.add(i);
                }

                int categoryIndex = 0;

                for (int i = 0; i < categories.size(); i += 1) {
                    if (categories.get(i).equals(bookData[4]))
                        categoryIndex = i;
                }

                books.add(new Book(bookData[0], bookData[2], Integer.parseInt(bookData[1].replace(" ", "")),
                        categoryIndex, authorIndexes));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(DEFAULT_ERROR);
        }
    }

    private static void saveBooks() {
        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/OverloadAndOverloading/listBooks.txt";
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Book book : books) {
                StringBuilder sb = new StringBuilder(
                        book.getTitle() + ";" + book.getYear() + ";" + book.getDescription() + ";");

                for (int i = 0; i < book.getAuthorIndexes().size(); i += 1) {
                    int authorIndex = book.getAuthorIndexes().get(i);

                    sb.append(i + 1 == book.getAuthorIndexes().size() ? authors.get(authorIndex).getName() + ";"
                            : authors.get(authorIndex).getName() + ",");
                }

                sb.append(categories.get(book.getCategoryIndex()));

                bw.write(sb.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(DEFAULT_ERROR);
        }
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
            System.out.println((i + 1) + ". " + authors.get(i).getName() + " [" + authors.get(i).getPenName() + "]");
        }
        System.out.println(SEPARATOR);
    }

    private static void printBooks() {
        System.out.println(SEPARATOR);
        for (int i = 0; i < books.size(); i++) {
            Book x = books.get(i);

            System.out.println((i + 1) + ". " + x.getTitle() + " [" + categories.get(x.getCategoryIndex()) + "]");
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

        for (String authorIndexString : authorIndexesString) {
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
                if (x.charAt(i) == y.charAt(i))
                    sameChars += 1;
            }

            samePercentage = (float) sameChars / xLen;
        } else {
            for (int i = 0; i < xLen; i += 1) {
                if (x.charAt(i) == y.charAt(i))
                    sameChars += 1;
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
                if (x.charAt(i) == y.charAt(i))
                    sameChars += 1;
            }

            samePercentage = (float) sameChars / xLen;
        } else {
            for (int i = 0; i < xLen; i += 1) {
                if (x.charAt(i) == y.charAt(i))
                    sameChars += 1;
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
            System.out.println("Saving data...");
            saveCategories();
            saveAuthors();
            saveBooks();
            System.out.println("Data saved.");

            running = false;
            break;
        default:
            System.out.println(
                    "We deeply apologize for the inconvenient, but this choice (" + index + ") still not available.");
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {
        running = true;

        initCategories();
        initAuthors();
        initBooks();

        while (running) {
            menu();
        }
    }
}
