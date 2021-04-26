package Inheritance;

public class MahasiswaFILKOM extends Manusia {

    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String name, boolean gender, String idNum, boolean married, String nim, double ipk) {
        super(name, gender, idNum, married);
        this.nim = nim;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getStatus() {
        String digitAngakatan = nim.substring(0, 2);
        char charProdi = nim.charAt(6);

        String status = "";
        switch (charProdi) {
            case '2':
                status = "Teknik Informatika";
                break;
            case '3':
                status = "Teknik Komputer";
                break;
            case '4':
                status = "Sistem Informasi";
                break;
            case '6':
                status = "Pendidikan Teknologi Informasi";
                break;
            case '7':
                status = "Teknologi Informasi";
                break;
            default:
                status = "Unknown";
        }

        return status + ", 20" + digitAngakatan;
    }

    public double getBeasiswa() {
        if (ipk > 3.0) {
            if (ipk > 3.5) {
                return 75;
            }
            return 50;
        }
        return 0;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nnim\t\t: " + nim
                + "\nipk\t\t: " + ipk
                + "\nstatus\t\t: " + getStatus();
    }

}
