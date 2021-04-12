package ClassworkThree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String SEPARATOR = "================================";
    private static List<Car> cars = new ArrayList<>();

    private static boolean running = false;

    private static Scanner in = new Scanner(System.in);

    private static void showCars() {
        for (int i = 0; i < cars.size(); i += 1) {
            Car car = cars.get(i);

            System.out.println(i + 1 + ". " + car.getName() + " [" + Boolean.toString(car.isAvailable()) + "]");
        }
    }

    private static void showCar(int i) {
        Car car = cars.get(i);
        car.printDetail();
    }

    private static void renting(int i) {
        showCar(i);

        System.out.print("Id Num\t: ");
        in.nextLine();
        String idNum = in.nextLine();
        System.out.print("Name\t: ");
        String name = in.nextLine();
        System.out.print("Address\t: ");
        String address = in.nextLine();

        User user = new User(idNum, name, address);
        Car car = cars.get(i);

        car.setAvailable(false);
        car.setUser(user);

        System.out.println("Berhasil meminjam mobil!");
    }

    private static void returning(int i) {
        showCar(i);

        Car car = cars.get(i);

        car.setAvailable(true);
        car.setUser(null);

        System.out.println("Berhasil mengembalikan mobil!");
    }

    private static void menu() {
        System.out.println(SEPARATOR);
        System.out.println("      RENTAL APPLICATION");
        System.out.println(SEPARATOR);
        System.out.println("1. Show all cars");
        System.out.println("2. Show car detail");
        System.out.println("3. Add new car");
        System.out.println("4. Renting");
        System.out.println("5. Returning");
        System.out.println("0. Exit");
        System.out.print("What is your choice? ");
        int index = in.nextInt();

        switchCase(index);
    }

    private static void switchCase(int index) {
        System.out.println("\n");

        switch (index) {
        case 1:
            // TODO: Show all cars
            System.out.println(SEPARATOR);
            showCars();
            System.out.println(SEPARATOR);
            break;
        case 2:
            // TODO: Show car details
            System.out.println(SEPARATOR);
            showCars();
            System.out.println(SEPARATOR);
            System.out.print("Pilih mobil: ");
            int carIndex = in.nextInt();
            showCar(carIndex - 1);
            break;
        case 3:
            // TODO: Add new car
            break;
        case 4:
            // TODO: Renting
            System.out.println(SEPARATOR);
            showCars();
            System.out.println(SEPARATOR);
            System.out.print("Pilih mobil: ");
            int carIndexRent = in.nextInt();

            if (!cars.get(carIndexRent - 1).isAvailable()) {
                System.out.println("Mobil sudah dipinjam!");
                break;
            }

            renting(carIndexRent - 1);
            break;
        case 5:
            // TODO: Returning
            System.out.println(SEPARATOR);
            showCars();
            System.out.println(SEPARATOR);
            System.out.print("Pilih mobil: ");
            int carIndexReturn = in.nextInt();

            if (cars.get(carIndexReturn - 1).isAvailable()) {
                System.out.println("Mobil belum dipinjam!");
                break;
            }

            returning(carIndexReturn - 1);
            break;
        case 0:
            System.out.println("Saving data...");
            // TODO: Save car data
            try {
                Car.saveCars(cars);
                System.out.println("Data saved.");
            } catch (IOException ex) {
                System.out.println("Error when saving data.");
            }

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

        // TODO: Init cars
        List<Car> tempCars = Car.initCars();
        cars = new ArrayList<>(tempCars);

        while (running) {
            menu();
        }
    }

}
