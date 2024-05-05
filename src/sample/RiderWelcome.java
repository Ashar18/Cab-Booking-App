package sample;

import company.bookcab;
import company.customer;
import company.rider;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RiderWelcome  {

    @FXML
    private Button button_profile;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_ok;
    @FXML
    private Button button_history;
    @FXML
    private MenuButton loc;
    @FXML
    private MenuItem nk;
    @FXML
    private MenuItem nn;
    @FXML
    private MenuItem bf;
    @FXML
    private MenuItem gi;

    private  int userId;
    private rider rider;
    private String vehicle;             //using for checking
    private int count;                  // using for checking

    private bookcab bookcab = null;


    public void dataInitH(rider r, int id) {
        userId = id;
        rider = r;
    }

    public void dataInit(rider r, int id) {
        userId = id;
        rider = r;


        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "select * from ride_book inner join customer on ride_book.cust_id = customer.cust_id where pickup_location = '"+rider.getLocation()+"' and select_vehicle = '"+rider.getVehicleType()+"' ;";
        String checkQuery = "select count(id) from ride_book inner join customer on ride_book.cust_id = customer.cust_id where pickup_location = '"+rider.getLocation()+"' and select_vehicle = '"+rider.getVehicleType()+"';";
        String status = "";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){

                vehicle = resultSet.getString("select_vehicle");
                bookcab = new bookcab(id,resultSet.getInt("cust_id"),resultSet.getString("cust_name"),resultSet.getString("c_phone"),resultSet.getString("pickup_location"),resultSet.getString("dest_location"),resultSet.getString("select_vehicle"));
                status = resultSet.getString("status");
            }
            ResultSet a = statement.executeQuery(checkQuery);
            while (a.next())  id = a.getInt(1);

        } catch (SQLException throwables) {
            throwables.getCause();
            throwables.printStackTrace();
        }

        if (id != 0 && status == null) {
            if (rider.getLocation().equals(bookcab.getPickup_loc()) && vehicle.equals(rider.getVehicleType())) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("riderRequest.fxml"));
                    Parent root = loader.load();
                    riderRequest rr = loader.getController();
                    rr.dataInit(rider, userId, bookcab);

                    Stage registerStage = new Stage();
                    registerStage.setTitle("CABZ");
                    registerStage.setScene(new Scene(root, 492, 295));
                    registerStage.show();

                } catch (IOException e) {
                    e.getCause();
                }

            }

        }

    }

    public void nkOnAction(){
        loc.setText(nk.getText());
    }
    public void nnOnAction(){
        loc.setText(nn.getText());
    }
    public void bfOnAction(){
        loc.setText(bf.getText());
    }
    public void giOnAction(){
        loc.setText(gi.getText());
    }


    public void refreshOnAction() {

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();
        String status = "";
        // String query = "select * from rider_noti where p_loc = '"+rider.getLocation()+"' and vehicle = '"+rider.getVehicleType()+"';";
        String query = "select * from ride_book inner join customer on ride_book.cust_id = customer.cust_id where pickup_location = '"+rider.getLocation()+"' and select_vehicle = '"+rider.getVehicleType()+"';";


        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                vehicle = resultSet.getString("select_vehicle");
                bookcab = new bookcab(id,resultSet.getInt("cust_id"),resultSet.getString("cust_name"),resultSet.getString("c_phone"),resultSet.getString("pickup_location"),resultSet.getString("dest_location"),resultSet.getString("select_vehicle"));
                status = resultSet.getString("status");
            }
            // String checkQuery = "select count(id) from ride_book inner join customer on ride_book.cust_id = customer.cust_id where pickup_location = '"+rider.getLocation()+"' and select_vehicle = '"+rider.getVehicleType()+"';";

            ResultSet r = statement.executeQuery("select count(id) from ride_book inner join customer on ride_book.cust_id = customer.cust_id where pickup_location = '"+rider.getLocation()+"' and select_vehicle = '"+rider.getVehicleType()+"';");
            while (r.next()){
                count = r.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.getCause();
            throwables.printStackTrace();
        }


        if (count != 0 && status == null){

            if (rider.getLocation().equals(bookcab.getPickup_loc()) && vehicle.equals(rider.getVehicleType())) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("riderRequest.fxml"));
                    Parent root = loader.load();
                    riderRequest rr =loader.getController();
                    rr.dataInit(rider,userId,bookcab);

                    Stage registerStage = new Stage();
                    registerStage.setTitle("CABZ");
                    registerStage.setScene(new Scene(root, 492, 295));
                    registerStage.show();

                } catch (IOException e) {
                    e.getCause();
                }

            }
        }
        else System.out.println("sorry no rides available");
    }

    public void profileOnAction(){
        button_profile.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("riderEdit.fxml"));
            Parent root = loader.load();
            riderEdit re =loader.getController();
            re.dataInit(rider,userId);

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

    public void okOnAction(){

        rider.setLocation(loc.getText());

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "update rider set location = '"+loc.getText()+"' where rider_id = "+userId+";";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throwables.getCause();
        }
    }
    public void historyOnAction(){
        button_history.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("riderHistory.fxml"));
            Parent root = loader.load();
            riderHistory rh = loader.getController();
            rh.dataInit(rider, userId);
            System.out.println("riderid "+userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 774, 532));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}