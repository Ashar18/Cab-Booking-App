package company;

import java.util.ArrayList;
import java.util.Scanner;

public class customer extends user {

    private String address;
    private String accountno;
    private String vehicleType;
    private String pickup_loc;
    private String dest_loc;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public customer(int user_id, String name, String username, String password, String phone , String address, String accountno) {
        super(user_id,name, username, password, phone);
        this.address = address;
        this.accountno = accountno;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        System.out.println("address changed!!!");
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }



    //    void editProfile() {
//
//        System.out.print("enter 1 to edit name\n" +
//                "enter 2 to edit username\n" +
//                "enter 3 to edit phone number\n" +
//                "enter 4 to edit password\n" +
//                "enter 5 to edit address\n" +
//                "enter 6 to edit account no\n" +
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
//            int num = in.nextInt();
//            this.setPhone(num);
//        }
//        else if (check == 4) {
//            String p = in.next();
//            this.setPassword(p);
//        }
//        else if (check == 5) {
//            String a = in.next();
//            this.setAddress(a);
//        }
//        else if (check == 6) {
//            int acc = in.nextInt();
//            this.setAccountno(acc);
//        }
//    }
//
    @Override
    public String toString(){
        return "Customer name: "+getName()+", user name: "+getUsername()+", phone number : "+getPhone()+", address: "+getAddress()+", account no: "+getAccountno();
    }
//
//
//    @Override
//    void login() {
//
//    }


}
