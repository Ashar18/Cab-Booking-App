package sample;

import company.bookcab;
import company.customer;
import company.rideInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bookRideController {

    @FXML
    private Button button_profile;
    @FXML
    private Button button_history;
    @FXML
    private Button button_logout;
    @FXML
    private Hyperlink h_tarrif;
    @FXML
    private MenuButton tf_pickup;
    @FXML
    private MenuButton tf_dest;
    @FXML
    private MenuItem pm_nk;
    @FXML
    private MenuItem pm_nn;
    @FXML
    private MenuItem pm_bf;
    @FXML
    private MenuItem pm_gi;
    @FXML
    private MenuItem dm_nk;
    @FXML
    private MenuItem dm_nn;
    @FXML
    private MenuItem dm_bf;
    @FXML
    private MenuItem dm_gi;

    @FXML
    private RadioButton radio_standard;
    @FXML
    private RadioButton radio_buisness;
    @FXML
    private RadioButton radio_vip;
    @FXML
    private RadioButton radio_van;
    @FXML
    private ToggleGroup vehicle;

    private String toggleName;



    private int userId;
    private int custID;
    private customer customer;

    private rideInfo riderInfo = null;



    public void dataInit(customer c ,int id) throws SQLException {
        customer = c;
        userId = id;
        System.out.println("userID in bookride == "+ userId);

    }



    public void pnkOnAction(){
        tf_pickup.setText(pm_nk.getText());
    }
    public void pnnOnAction(){
        tf_pickup.setText(pm_nn.getText());
    }
    public void pbfOnAction(){
        tf_pickup.setText(pm_bf.getText());
    }
    public void pgiOnAction(){
        tf_pickup.setText(pm_gi.getText());
    }

    public void dnkOnAction(){
        tf_dest.setText(dm_nk.getText());
    }
    public void dnnOnAction(){
        tf_dest.setText(dm_nn.getText());
    }
    public void dbfOnAction(){
        tf_dest.setText(dm_bf.getText());
    }
    public void dgiOnAction(){
        tf_dest.setText(dm_gi.getText());
    }


    public void refreshOnAction() throws SQLException {

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "select * from ride_book " +
                "inner join customer on ride_book.cust_id = customer.cust_id "+
                "inner join rider on ride_book.rider_id = rider.rider_id "+
                "where ride_book.cust_id = "+userId +" and customer.pickup_location = '"+customer.getPickup_loc()+"' and customer.dest_location = '"+customer.getDest_loc()+"' and customer.select_vehicle = '"+customer.getVehicleType()+"';";

        System.out.println(query);

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                custID = resultSet.getInt("cust_id");
                customer.setVehicleType(resultSet.getString("select_vehicle"));


                System.out.println(resultSet.getInt("rider_id"));
                riderInfo = new rideInfo(id,custID,resultSet.getInt("rider_id"),resultSet.getString("rider_name"),resultSet.getString("rider_phone"),resultSet.getString("pickup_location"),resultSet.getString("dest_location"),resultSet.getString("vehicle"));
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
        else System.out.println("sorry");
    }

    public void tarrifOnAction(){
        h_tarrif.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Tariffs.fxml"));
            Parent root = loader.load();
            TariffsController tc =loader.getController();
            tc.dataInit(customer,userId);
            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 677, 400));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void confirmOnAction(){


        ToggleGroup toggleGroup = new ToggleGroup();
        radio_standard.setToggleGroup(toggleGroup);
        radio_buisness.setToggleGroup(toggleGroup);
        radio_vip.setToggleGroup(toggleGroup);
        radio_van.setToggleGroup(toggleGroup);

        toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        customer.setVehicleType(toggleName);
        customer.setPickup_loc(tf_pickup.getText());
        customer.setDest_loc(tf_dest.getText());

        databaseconnector connectNow = new databaseconnector();
        Connection connection = connectNow.getConnection();

        String query = "update customer set pickup_location = '"+customer.getPickup_loc()+"', dest_location = '"+customer.getDest_loc()+
                    "', select_vehicle = '"+customer.getVehicleType()+"' where cust_id = "+userId+";";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmRide.fxml"));
            Parent root = loader.load();
            confirmRideController cr =loader.getController();
            cr.dataInit(customer,userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 463, 269));
            registerStage.show();



        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void profileOnAction() {
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



}
