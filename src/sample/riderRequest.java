package sample;

import company.bookcab;
import company.customer;
import company.rider;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class riderRequest {

    @FXML
    private Label n;
    @FXML
    private Label ph;
    @FXML
    private Label pl;
    @FXML
    private Label dl;
    @FXML
    private Button button_ok;
    @FXML
    private Button button_cancel;

    private bookcab bookcab;
    private rider rider;
    private int riderId;

    public void dataInit(rider r,int id ,bookcab b){
        bookcab = b;
        rider = r;
        riderId = id;

        n.setText(bookcab.getCustomer_name());
        ph.setText(bookcab.getCustomer_phone());
        pl.setText(bookcab.getPickup_loc());
        dl.setText(bookcab.getDest_loc());

    }

    public void okOnAction() throws SQLException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy / HH:mm:ss ");
        String strDate = formatter.format(date);
        bookcab.setDate(strDate);
        System.out.println(bookcab.getDate());

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();


        String query = "update ride_book set rider_id = "+riderId+", status = 'yes'"+" where cust_id = "+bookcab.getCustomer_id()+";";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);


//            String deleteQuery = "delete from rider_noti where cust_id = "+bookcab.getCustomer_id();
//            statement.executeUpdate(deleteQuery);

            String field = "insert into history (rider_id,cust_id,time) values ";
            String values = "(" + riderId + "," + bookcab.getCustomer_id()+ ",'" +bookcab.getDate()+"');";
            String historyQuery = field + values;
            statement.executeUpdate(historyQuery);

//            String cfield = "insert into cust_history (cust_id,r_name,p_loc,d_loc,vehicle,time) values ";
//            String cvalues = "("+bookcab.getCustomer_id()+",'"+ rider.getName()+ "', '"+ bookcab.getPickup_loc()+"', '"+ bookcab.getDest_loc()+"', '"+bookcab.getVehicleType()+"', '"+bookcab.getDate()+"');";
//            String chistoryQuery = cfield + cvalues;
//            statement.executeUpdate(chistoryQuery);
//
//            String rfield = "insert into rider_history (rider_id,c_name,p_loc,d_loc,vehicle,time) values ";
//            String rvalues = "("+riderId+",'"+ bookcab.getCustomer_name()+ "', '"+ bookcab.getPickup_loc()+"', '"+ bookcab.getDest_loc()+"', '"+bookcab.getVehicleType()+"', '"+bookcab.getDate()+"');";
//            String rhistoryQuery = rfield + rvalues;
//            statement.executeUpdate(rhistoryQuery);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.close();
        }

        Stage v = (Stage)button_ok.getScene().getWindow();
        v.close();
        button_ok.getScene().getWindow().getOnCloseRequest();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("CONGRATS");
        alert.setContentText("Your ride has been booked. Try to reach to the passenger ASAP!");
        alert.showAndWait();


    }

    public void cancelOnAction(){
        button_ok.getScene().getWindow().hide();
    }
}
