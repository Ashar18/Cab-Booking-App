package sample;

import company.customer;
import company.rideInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class welcomeController {

    @FXML
    private Button button_profile;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_book;
    @FXML
    private Button button_history;

    private rideInfo rideInfo = null;
    private int custID;
    private int userId;
    private customer customer;
    private rideInfo riderInfo = null;
    private int check;


    public void dataInit(customer c ,int id) throws SQLException {
        customer = c;
        userId = id;
        System.out.println("userID in customerWelcome == "+ userId);

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "select * from ride_book " +
                "inner join customer on ride_book.cust_id = customer.cust_id " +
                "inner join rider on ride_book.rider_id = rider.rider_id " +
                "where customer.cust_id = "+userId +" and customer.pickup_location = '"+customer.getPickup_loc()+"' and customer.dest_location = '"+customer.getDest_loc()+"' and customer.select_vehicle = '"+customer.getVehicleType()+"' and status = 'yes';";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                id = resultSet.getInt("id");
                custID = resultSet.getInt("cust_id");
                customer.setVehicleType(resultSet.getString("select_vehicle"));


                System.out.println(resultSet.getInt("rider_id"));
                riderInfo = new rideInfo(id,custID,resultSet.getInt("rider_id"),resultSet.getString("rider_name"),resultSet.getString("r_phone"),resultSet.getString("pickup_location"),resultSet.getString("dest_location"),resultSet.getString("vehicle"));
                System.out.println("rider:" + riderInfo.getRider_name());

            }

        } catch (SQLException throwables) {
            throwables.getCause();
            throwables.printStackTrace();
        }finally {
            connection.close();
        }


        if (custID == userId ) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("rideMsg.fxml"));
                Parent root = loader.load();
                rideMsg rm =loader.getController();
                rm.datainit(customer,riderInfo);
                riderInfo.getRider_name();

                Stage registerStage = new Stage();
                registerStage.setTitle("CABZ");
                registerStage.setScene(new Scene(root, 486, 320));
                registerStage.show();

            } catch (IOException e) {
                e.getCause();
            }

        }



    }

    public void bookOnAction(){
        button_book.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookRide.fxml"));
            Parent root = loader.load();
            bookRideController br =loader.getController();
            br.dataInit(customer,userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 750, 532));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void profileOnAction(){
        button_profile.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerEdit.fxml"));
            Parent root = loader.load();
            customerEdit ce =loader.getController();
            ce.dataInit(customer,userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 774, 532));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void logoutOnAction(){
        button_logout.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 512, 397));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    public void refreshOnAction() throws SQLException {

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "select * from ride_book " +
                "inner join customer on ride_book.cust_id = customer.cust_id " +
                "inner join rider on ride_book.rider_id = rider.rider_id " +
                "where ride_book.cust_id = "+userId +" and customer.pickup_location = '"+customer.getPickup_loc()+"' and customer.dest_location = '"+customer.getDest_loc()+"' and rider.vehicle = '"+customer.getVehicleType()+"';";

        String checkQuery = "select count(id) from ride_book " +
                "inner join customer on ride_book.cust_id = customer.cust_id " +
                "where ride_book.cust_id = "+userId +" and pickup_location = '"+customer.getPickup_loc()+"' and dest_location = '"+customer.getDest_loc()+"' and select_vehicle = '"+customer.getVehicleType()+"';";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                custID = resultSet.getInt("cust_id");
                customer.setVehicleType(resultSet.getString("vehicle"));

                rideInfo = new rideInfo(id,custID,resultSet.getInt("rider_id"),resultSet.getString("rider_name"),resultSet.getString("rider_phone"),resultSet.getString("p_loc"),resultSet.getString("d_loc"),resultSet.getString("vehicle"));;

            }
            ResultSet a = statement.executeQuery(checkQuery);
            while (a.next())  check = a.getInt(1);

        } catch (SQLException throwables) {
            throwables.getCause();
            throwables.printStackTrace();
        }finally {
            connection.close();
        }

        if (check != 0) {
            if (custID == userId) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("rideMsg.fxml"));
                    Parent root = loader.load();
                    rideMsg rm = loader.getController();
                    rm.datainit(customer, rideInfo);
                    rideInfo.getRider_name();

                    Stage registerStage = new Stage();
                    registerStage.setTitle("CABZ");
                    registerStage.setScene(new Scene(root, 486, 320));
                    registerStage.show();

                } catch (IOException e) {
                    e.getCause();
                }

            }
        }
        else System.out.println("sorry");
    }

    public void historyOnAction(){
        button_history.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerHistory.fxml"));
            Parent root = loader.load();
            customerHistory ch =loader.getController();
            ch.dataInit(customer,userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 774, 532));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}

