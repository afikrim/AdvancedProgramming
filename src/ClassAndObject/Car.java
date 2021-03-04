package ClassAndObject;

/**
 * Properties:
 * * name
 * * color
 * * speed
 * * manufacture
 */
public class Car {
    private String name;
    private String color;
    private Manufacture manufacture;
    private float speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String stringify() {
        return "Name\t\t: " + name
                + "\nColor:\t\t: " + color
                + "\nManufacture\t: " + manufacture.getName()
                + "\nSpeed\t\t: " + speed + "km/h";
    }
}
