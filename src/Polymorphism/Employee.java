package Polymorphism;

public abstract class Employee {

    private String name;
    private String idNum;

    public Employee() {
    }

    public Employee(String name, String idNum) {
        this.name = name;
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return getName() + "\nNo. KTP: " + getIdNum();
    }
}
