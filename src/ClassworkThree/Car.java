package ClassworkThree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final String SEPARATOR = "================================";
    private static final String DEFAULT_ERROR = "Oops! Something went wrong.";
    private static final String FILE_NOT_FOUND = "File not found, please make sure that the path is right.";
    private String name;
    private String manufacture;
    private String color;
    private String platenumber;
    private boolean available;
    private User user;

    public Car() {

    }

    public Car(String name, String manufacture, String color, String platenumber, boolean available, User user) {
        this.name = name;
        this.manufacture = manufacture;
        this.color = color;
        this.platenumber = platenumber;
        this.available = available;
        this.user = user;
    }

    public static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        try {
            String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/ClassworkThree/listCar.txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("name;manufactures;color;platenumber;available;idNum,name,address"))
                    continue;

                User user = null;
                String[] carData = line.split(";");

                if (!Boolean.parseBoolean(carData[4])) {
                    String[] userData = carData[5].split(",");
                    user = new User(userData[0], userData[1], userData[2]);
                }

                Car car = new Car(carData[0], carData[1], carData[2], carData[3], Boolean.parseBoolean(carData[4]),
                        user);

                cars.add(car);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException ex) {
            System.out.println(DEFAULT_ERROR);
        }

        return cars;
    }

    public static void saveCars(List<Car> cars) throws IOException {
        String path = "/home/azizf/Documents/Colleges/6th Semester/LabAssistant/AdvancedProgramming/Code/src/ClassworkThree/listCar.txt";
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("name;manufactures;color;platenumber;available;idNum,name,address");
        bw.newLine();
        for (Car car : cars) {
            User user = car.getUser();

            String line = car.getName() + ";" + car.getManufacture() + ";" + car.getColor() + ";" + car.getPlatenumber()
                    + ";" + Boolean.toString(car.isAvailable());

            if (!car.isAvailable()) {
                line += ";" + user.getIdNum() + "," + user.getName() + "," + user.getAddress();
            }

            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void printDetail() {
        System.out.println(SEPARATOR);
        System.out.println("Name\t\t: " + name);
        System.out.println("Manufacture\t: " + manufacture);
        System.out.println("Color\t\t: " + color);
        System.out.println("Plate Number\t: " + platenumber);
        System.out.println("Available\t: " + Boolean.toString(available));

        if (!available) {
            System.out.println("\tUser: ");
            System.out.println("\t- Id Num\t: " + user.getIdNum());
            System.out.println("\t- Name\t\t: " + user.getName());
            System.out.println("\t- Address\t: " + user.getAddress());
        }
        System.out.println(SEPARATOR);
    }

}
