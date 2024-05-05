//package com.company;
//
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        // write your code here
//        Scanner in  = new Scanner(System.in);
//
//        admin a = new admin();
//
//        do{
//            System.out.print("press 1 to sign up as customer\n" +
//                    "press 2 to sign up as rider\n" +
//                    "press 0 to cancel\n" +
//                    "->");
//            byte check = in.nextByte();
//
//            System.out.print("enter name: ");
//            String name = in.next();
//            System.out.print("enter user name: ");
//            String username = in.next();
//            System.out.print("enter password: ");
//            String password = in.next();
//            System.out.print("enter phone number: ");
//            int phone = in.nextInt();
//
//            if (check == 1) {
//                System.out.print("enter address: ");
//                String address = in.next();
//                System.out.print("enter account no: ");
//                int acc = in.nextInt();
//
//                customer cust = new customer(name,username,phone,password,address,acc);
//                a.addCustomer(cust);
//            }
//            else if(check == 2 ){
//                System.out.print("enter vehicle type \n" +
//                        "Car with AC\n" +
//                        "Car without AC\n" +
//                        "Rickshaw\n" +
//                        "Bike");
//                String vehicle = in.next();
//
//                System.out.print("enter availability: ");
//                boolean tf = in.hasNext();
//
//                rider rider = new rider(name,username,phone,password,vehicle,tf);
//                a.addRider(rider);
//
//            }
//            else if (check == 0) break;
//            else continue;
//
//        }while (true);
//
//        do {
//            System.out.print("sign in as: \n" +
//                    "press 1 for customer\n" +
//                    "press 2 for rider\n" +
//                    "press 3 for admin\n" +
//                    "->  ");
//            byte check = in.nextByte();
//            System.out.print("enter username: ");
//            String username = in.next();
//            System.out.println("enter password: ");
//            String password = in.next();
//            System.out.println("---------------------------\n");
//
//            if (check == 1){
//                for (int i = 0; i<a.getCustomers().size();i++){
//                    if (a.getCustomers().get(i).getUsername().equals(username) && a.getCustomers().get(i).getPassword().equals(password)){
//
//                        System.out.print("Press 1 to edit profile\n"+
//                                "Press 2 to view details\n" +
//                                "Press 3 to book cab\n" +
//                                "->   ");
//                        byte opt = in.nextByte();
//
//                        if (opt == 3){
//                            bookcab cab = new bookcab();
//                            for (int j=0; j < a.getRiders().size(); j++){
//                                if (cab.getVehicle().equals(a.getRiders().get(j)) && a.getRiders().get(j).getisAvailable()) {
//                                    cab.addCustomerDetail(a.getCustomers().get(i));
//                                    cab.addRiderDetail(a.getRiders().get(j));
//
//                                    System.out.print("Press 0 to view rider details\n" +
//                                            "Press 1 to update ride\n" +
//                                            "Press 2 to cancel ride\n" +
//                                            "->   ");
//                                    byte o = in.nextByte();
//                                    if (o == 0) System.out.println(cab.displayRiderDetail());
//                                    break;
//                                }
//                            }
//                        }
//                        else if (opt == 1){
//                            a.getCustomers().get(i).editProfile();
//                        }
//                        else if (opt == 2){
//                            System.out.println(a.getCustomers().get(i).toString());
//                        }
//                        break;
//                    }
//                }
//            }
//
//            else if (check == 2){
//                for (int i = 0; i<a.getRiders().size();i++){
//                    if (a.getRiders().get(i).getUsername().equals(username) && a.getRiders().get(i).getPassword().equals(password)){
//
//
//
//
//                        break;
//                    }
//
//                }
//
//            }
//            else if (check == 3){
//                if (username.equals("Ashar") && password.equals("123")){
//                    System.out.println("press 1 to view customers \n" +
//                            "press 2 to view 2 to view riders \n" +
//                            "->  ");
//                    byte opt = in.nextByte();
//                    if (opt == 1) System.out.println(a.displayCustomers()+"\n");
//                    else if (opt == 2 ) System.out.println(a.displayRiders()+"\n");
//                    else continue;
//                }
//                else System.out.println("wrong username or password!!! \n");
//            }
//
//            else if (check == 0) break;
//
//            else continue;
//
//        }while (true);
//
//
//
//
//    }
//
//}
//
//
//
