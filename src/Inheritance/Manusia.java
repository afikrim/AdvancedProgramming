package Inheritance;

public class Manusia {

    private String name;
    private boolean gender;
    private String idNum;
    private boolean married;

    public Manusia(String name, boolean gender, String idNum, boolean married) {
        this.name = name;
        this.gender = gender;
        this.idNum = idNum;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public double getTunjangan() {
        if (married) {
            if (gender) {
                return 25;
            }
            return 20;
        }
        return 15;
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    @Override
    public String toString() {
        return "nama\t\t: " + name
                + "\nnik\t\t: " + idNum
                + "\njenisKelamin\t: " + (gender ? "Laki-laki" : "Perempuan")
                + "\npendapatan\t: " + getPendapatan();
    }

}
