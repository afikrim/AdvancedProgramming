package Polymorphism;

public class HourlyEmployee extends Employee {

    private double wage; //upah perjam
    private double hours; //jumlah jam

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, String idNum, double wage, double hours) {
        super(name, idNum);
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public double earnings() {
        return getHours() <= 40
                ? getWage() * getHours()
                : 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }

    @Override
    public String toString() {
        return "Hourly employee: " + super.toString() + "\nhourly wage: " + getWage() + "\nhours worked: " + getHours();
    }
}
