package company;

public class rideInfo {

    private int id;
    private int rider_id;
    private int customer_id;
    private String rider_name;
    private String rider_phone;
    private String pickup_loc;
    private String dest_loc;
    private String vehicleType;

    public rideInfo(int id, int customer_id, int rider_id, String rider_name, String rider_phone, String pickup_loc, String dest_loc, String vehicleType) {
        this.id = id;
        this.rider_id = rider_id;
        this.customer_id = customer_id;
        this.rider_name = rider_name;
        this.rider_phone = rider_phone;
        this.pickup_loc = pickup_loc;
        this.dest_loc = dest_loc;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRider_id() {
        return rider_id;
    }

    public void setRider_id(int rider_id) {
        this.rider_id = rider_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getRider_name() {
        return rider_name;
    }

    public void setRider_name(String rider_name) {
        this.rider_name = rider_name;
    }

    public String getRider_phone() {
        return rider_phone;
    }

    public void setRider_phone(String rider_phone) {
        this.rider_phone = rider_phone;
    }

    public String getPickup_loc() {
        return pickup_loc;
    }

    public void setPickup_loc(String pickup_loc) {
        this.pickup_loc = pickup_loc;
    }

    public String getDest_loc() {
        return dest_loc;
    }

    public void setDest_loc(String dest_loc) {
        this.dest_loc = dest_loc;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
