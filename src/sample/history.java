package sample;

public class history {

    private int id;
    private String name,ploc,dloc,vehicle,time;

    public history(int s_no, String name, String ploc, String dloc, String vehicle, String time) {
        this.id = s_no;
        this.name = name;
        this.ploc = ploc;
        this.dloc = dloc;
        this.vehicle = vehicle;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPloc() {
        return ploc;
    }

    public void setPloc(String ploc) {
        this.ploc = ploc;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
