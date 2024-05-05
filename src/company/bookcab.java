package company;

import java.util.Date;

//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Scanner;
//
public class bookcab {
    private int id;
    private int customer_id;
    private String customer_name;
    private String customer_phone;
    private String pickup_loc;
    private String dest_loc;
    private String vehicleType;
    private String date;

    public bookcab(int id, int customer_id, String customer_name, String customer_phone, String pickup_loc, String dest_loc, String vehicleType) {
        this.id = id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
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


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

//    Scanner in = new Scanner(System.in);
//    Date date ;
//    private String vehicle;
//    private ArrayList<customer> customerDetail = new ArrayList<>();
//    private ArrayList<rider> riderDetail = new ArrayList<>();
//    private double bill;
//
//
//    public bookcab() {
//        vehicle = chooseVehicle();
//    }
//
//    String chooseVehicle(){
//        System.out.print("Select Vehicle: \n" +
//                "Press 1 for Car with AC\n" +
//                "Press 2 for Car without AC\n" +
//                "Press 3 for Rickshaw\n" +
//                "Press 4 for Bike\n" +
//                "->  ");
//        byte check = in.nextByte();
//        if (check == 1) return "Car with AC";
//        else if (check == 2) return "Car without AC";
//        else if (check == 3) return "Rickshaw";
//        else if (check == 4) return "Bike";
//        return null;
//    }
//
//    public String getVehicle() {
//        return vehicle;
//    }
//
//    public void addCustomerDetail(customer c){
//        customerDetail.add(c);
//    }
//
//    public String displayCustomerDetail() {
//        return customerDetail.toString()+"\n";
//    }
//
//    public ArrayList<customer> getCustomerDetail() {
//        return customerDetail;
//    }
//
//
//    public void addRiderDetail(rider r){
//        riderDetail.add(r);
//    }
//
//    public String displayRiderDetail() {
//        return riderDetail.toString()+"\n";
//    }
//
//    public ArrayList<rider> getRiderDetail() {
//        return riderDetail;
//    }
//
//
//    void rideDetails(){
//
//    }
//
//    void cancelRide(){
//
//    }
//
//    void updateRide(){
//
//    }
//
//    public String toString(){
//        return "vehicle type: "+vehicle;
//    }
//
//
//
//}
