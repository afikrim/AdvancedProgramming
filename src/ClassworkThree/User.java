package ClassworkThree;

public class User {

    private String idNum;
    private String name;
    private String address;

    public User() {

    }

    public User(String idNum, String name, String address) {
        this.idNum = idNum;
        this.name = name;
        this.address = address;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
