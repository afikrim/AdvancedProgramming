package Polymorphism;

public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, String idNum, double weeklySalary) {
        super(name, idNum);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return "Salaried employee: " + super.toString() + "\nweekly salary: " + getWeeklySalary();
    }
}
