//
//package com.company;
//
//import java.util.*;
//
//public class admin extends user {
//    final private ArrayList<customer> customers = new ArrayList<>();
//    final private ArrayList<rider> riders = new ArrayList<>();
//
//
//    public admin() {
//        this.setUsername("Ashar");
//        this.setPassword("123");
//    }
//
//
//    void editProfile() {
//        Scanner in = new Scanner(System.in);
//        System.out.print("enter 1 to edit name\n" +
//                "enter 2 to edit password\n" +
//                "->  ");
//        byte check = in.nextByte();
//        if (check == 1) {
//            String n = in.next();
//            this.setName(n);
//        }
//        else if (check == 2) {
//            String p = in.next();
//            this.setPassword(p);
//        }
//    }
//
//
//    public void addRider (rider o){
//        riders.add(o);
//
//    }
//    public void removeRider (rider o) {
//        riders.remove(o);
//    }
//
//    public String displayRiders() {
//        return "riders: "+riders+"\n";
//    }
//
//    public ArrayList<rider> getRiders() {
//        return riders;
//    }
//
//
//    public void addCustomer(customer o){
//        customers.add(o);
//
//    }
//
//    public void removeCustomer(customer o){
//        customers.remove(o);
//    }
//
//    public ArrayList<customer> getCustomers() {
//        return customers;
//    }
//
//    public String displayCustomers() {
//        return "customers: "+customers+"\n";
//    }
//
//
//
//    @Override
//    void login() {
//
//    }
//}
