package sample;

import company.customer;
import company.rideInfo;
import company.rider;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class rideMsg {

    @FXML
    private Label rn;
    @FXML
    private Label rp;
    @FXML
    private Label pl;
    @FXML
    private Label dl;
    @FXML
    private Label vt;
    @FXML
    private Button button_cancel;
    @FXML
    private Button button_ok;

    private customer customer;
    private rideInfo rideInfo;



    public void datainit(customer c, rideInfo ri) {
        customer = c;
        rideInfo = ri;
        System.out.println(rideInfo.getDest_loc());

        rn.setText(rideInfo.getRider_name());
        rp.setText(rideInfo.getRider_phone());
        pl.setText(rideInfo.getPickup_loc());
        dl.setText(rideInfo.getDest_loc());
        vt.setText(rideInfo.getVehicleType());

    }

    public void okOnAction() throws SQLException {

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();
        String deleteQuery = "delete from ride_book where rider_id = "+rideInfo.getRider_id();

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteQuery);
            System.out.println(deleteQuery);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.close();
        }

        Stage v = (Stage)button_ok.getScene().getWindow();
        v.close();
    }


}
