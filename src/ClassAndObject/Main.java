package ClassAndObject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Case: A car dealership wants some program to make their job easier. In this shop, they have any type of car,
 * and every car has manufacture, name, color, and speed. Your target is to make a program that can help this
 * shop when they want to see all cars that they have and add new cars to the list. They also want to see the
 * detail of a car or it's manufacture
 *
 * Entities:
 * * Car
 * * Manufacture
 *
 * Properties:
 * * Car:
 *   * name
 *   * color
 *   * speed
 *   * manufacture
 *
 * * Manufacture
 *   * name
 *   * description
 */
public class Main {
    /**
     * Define list of manufacture and cars
     */
    private static final ArrayList<Manufacture> manufactures = new ArrayList<>();
    private static final ArrayList<Car> cars = new ArrayList<>();

    /**
     * Define scanner for user input
     */
    private static final Scanner in = new Scanner(System.in);

    /**
     * Define variable that indicate the system is running
     */
    private static boolean running = false;

    /**
     * Method main, method that will be call once the program is started.
     * @param args
     */
    public static void main(String[] args) {
        // Set running indicator to true
        running = true;

        // Init manufactures and cars
        initManufactures();
        initCars();

        // loop the program if running is true
        while (running) {
            menu();
        }
    }

    private static void initManufactures() {
        Manufacture toyota = new Manufacture();
        Manufacture daihatsu = new Manufacture();

        toyota.setName("Toyota");
        toyota.setDescription("Toyota manufacture");

        daihatsu.setName("Daihatsu");
        daihatsu.setDescription("Daihatsu manufacture");

        manufactures.add(toyota);
        manufactures.add(daihatsu);
    }

    private static void initCars() {
        Car a = new Car();
        Car b = new Car();
        Car c = new Car();
        Car d = new Car();
        Car e = new Car();

        a.setName("Avanza");
        a.setColor("Black");
        a.setManufacture(manufactures.get(0));
        a.setSpeed(100);

        b.setName("Xenia");
        b.setColor("Black");
        b.setManufacture(manufactures.get(1));
        b.setSpeed(100);

        c.setName("Rush");
        c.setColor("Black");
        c.setManufacture(manufactures.get(0));
        c.setSpeed(100);

        d.setName("Terios");
        d.setColor("Black");
        d.setManufacture(manufactures.get(1));
        d.setSpeed(100);

        e.setName("Xenia");
        e.setColor("Silver");
        e.setManufacture(manufactures.get(1));
        e.setSpeed(100);

        cars.add(a);
        cars.add(b);
        cars.add(c);
        cars.add(d);
        cars.add(e);
    }

    private static void newCar() {
        Car x = new Car();

        printManufactures();

        System.out.print("Manufacture: ");
        x.setManufacture(manufactures.get(in.nextInt() - 1));
        System.out.print("Name\t: ");
        x.setName(in.next());
        System.out.print("Color\t: ");
        x.setColor(in.next());
        System.out.print("Speed\t: ");
        x.setSpeed(in.nextFloat());

        cars.add(x);
    }

    private static void newManufacture() {
        Manufacture x = new Manufacture();

        printManufactures();

        System.out.print("Name\t: ");
        in.nextLine();
        x.setName(in.nextLine());
        System.out.print("Description\t: ");
        x.setDescription(in.nextLine());

        manufactures.add(x);
    }

    private static void printManufactures() {
        System.out.println("================================");
        for (int i = 0; i < manufactures.size(); i++) {
            System.out.println((i + 1) + ". " + manufactures.get(i).getName()
                    + " [" + manufactures.get(i).getDescription() + "]");
        }
        System.out.println("================================");
    }

    private static void printCars() {
        System.out.println("================================");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + cars.get(i).getName()
                    + " [" + cars.get(i).getManufacture().getName() + "]");
        }
        System.out.println("================================");
    }

    private static void printCarDetail(int index) {
        System.out.println("================================");
        System.out.println(cars.get(index).stringify());
        System.out.println("================================");
    }

    private static void menu() {
        System.out.println("================================");
        System.out.println("       CAR APPLICATION");
        System.out.println("================================");
        System.out.println("1. Show all cars");
        System.out.println("2. Show all manufactures");
        System.out.println("3. Show car detail");
        System.out.println("4. Add new car");
        System.out.println("5. Add new manufactures");
        System.out.println("6. Exit");
        System.out.println("What is your choice? ");
        int index = in.nextInt();

        switchCase(index);
    }

    private static void switchCase(int index) {
        switch (index) {
            case 1:
                printCars();
                break;
            case 2:
                printManufactures();
                break;
            case 3:
                printCars();
                System.out.println("Car number: ");
                int carIndex = in.nextInt();
                printCarDetail(carIndex - 1);
                break;
            case 4:
                newCar();
                break;
            case 5:
                newManufacture();
                break;
            case 6:
                running = false;
                break;
            default:
                System.out.println("We deeply apologize for the inconvenient, but this choice (" + index + ") still not available.");
        }
    }
}
