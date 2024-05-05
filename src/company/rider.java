package company;

import java.util.ArrayList;
import java.util.Scanner;

public class rider extends user{

    private String vehicleType;
    private String location;

    public rider(int user_id,String name, String username, String password, String phone, String vehicleType, String location) {
        super(user_id,name, username, password,phone );
        this.vehicleType = vehicleType;
        this.location = location;

    }


    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    //    void editProfile() {
//        Scanner in = new Scanner(System.in);
//        System.out.print("enter 1 to edit name\n" +
//                "enter 2 to edit username\n" +
//                "enter 3 to edit phone number\n" +
//                "enter 4 to edit password\n" +
//                "enter 5 to edit vehicle type\n" +
//                "enter 6 to edit availability\n" +
//                "->  ");
//
//        byte check = in.nextByte();
//        if (check == 1) {
//            String n = in.next();
//            this.setName("n");
//        }
//        else if (check == 2) {
//            String u = in.next();
//            this.setUsername(u);
//        }
//        else if (check == 3) {
//             num = in.nextInt();
//            this.setPhone(num);
//        }
//        else if (check == 4) {
//            String p = in.next();
//            this.setPassword(p);
//        }
//        else if (check == 5) {
//            String v = in.next();
//            this.setVehicleType(v);
//        }
//        else if (check == 6) {
//            String a = in.next();
//            this.setAvailable(a);
//        }
//    }
//
//
    public String toString(){
        return "Rider name: "+getName()+", user name: "+getUsername()+", vehicle: "+getVehicleType()+", phone number: "+getPhone()+", location: "+getLocation();
    }
//
//    @Override
//    void login() {
//
//    }


}
