package sample;

import company.customer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class confirmRideController {
    @FXML
    private Label pl;
    @FXML
    private Label dl;
    @FXML
    private Label vt;
    @FXML
    private Button button_ok;
    @FXML
    private Button button_cancel;

    int riderID;
    private int userId;
    private customer customer;

    public void dataInit(customer c,int id){
        userId = id;
        customer = c;

        pl.setText(customer.getPickup_loc());
        dl.setText(customer.getDest_loc());
        vt.setText(customer.getVehicleType());

    }

    public void okOnAction() throws SQLException {
        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();


        String query = "select * from rider where location = '"+customer.getPickup_loc()+"' and vehicle = '"+customer.getVehicleType()+"';";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                riderID = resultSet.getInt("rider_id");
            }

            String insertFields = "insert into ride_book (cust_id) values ";
            // String insertValue = "("+ userId +", '" + customer.getName() + "','" + customer.getPhone() + "','" + customer.getPickup_loc() + "','" + customer.getDest_loc() + "','" + customer.getVehicleType() + "');";
            String insertValue = "("+ userId +")";

            String rideQuery = insertFields + insertValue;
            System.out.println(rideQuery);

            statement.executeUpdate(rideQuery);

            Stage v = (Stage)button_ok.getScene().getWindow();
            v.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (riderID == 0){
                alert.setHeaderText("Sorry...");
                alert.setContentText("No Riders available near your location...");
                alert.showAndWait();

                String deleteQuery = "delete from ride_book where cust_id = "+userId+"; ";
                statement.executeUpdate(deleteQuery);


            }
            else {
                alert.setHeaderText("Searching...");
                alert.setContentText("We are looking for your rides, wait for few minutes.");
                alert.showAndWait();
            }

        } catch (SQLException throwables) {
            throwables.getCause();
            throwables.printStackTrace();
        }finally {
            connection.close();
        }



    }

    public void cancelOnAction(){
        Stage v = (Stage)button_cancel.getScene().getWindow();
        v.close();
    }






}
