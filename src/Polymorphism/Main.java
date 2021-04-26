package Polymorphism;

public class Main {

    public static void main(String[] args) {
        Employee employee = new HourlyEmployee("Aziz", "19283192738", 10, 50);

        System.out.println(employee.earnings());
    }

}
