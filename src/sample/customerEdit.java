package sample;

import company.customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class customerEdit extends customerController {

    @FXML
    private Button button_profile;
    @FXML
    private Button button_history;
    @FXML
    private Button button_back;
    @FXML
    private Button button_logout;
    @FXML
    private Label header;

    private customer customer;
    private int userId;


    public void dataInit(customer c , int id){
        customer = c;
        userId = id;
        System.out.println("userID in customeredit == "+ userId);

        header.setText(customer.getName()+"'s Profile");
        getTf_name().setText(customer.getName());
        getTf_username().setText(customer.getUsername());
        getTf_password().setText(customer.getPassword());
        getTf_phone().setText(customer.getPhone());
        getTf_address().setText(customer.getAddress());
        getTf_accno().setText(customer.getAccountno());

    }

    public void resetOnAction(){


        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "update customer set cust_name = '"+getTf_name().getText()+"',username = '"+getTf_username().getText()+"',password = '"+getTf_password().getText()+"',c_phone = '"+getTf_phone().getText()+"',address = '"+getTf_address().getText()+"',account_no = '"+getTf_accno().getText()+"' where cust_id = "+userId+";";
        customer.setName(getTf_name().getText());
        customer.setUsername(getTf_username().getText());
        customer.setPassword(getTf_password().getText());
        customer.setPhone(getTf_phone().getText());
        customer.setAddress(getTf_address().getText());
        customer.setAccountno(getTf_accno().getText());

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throwables.getCause();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Done!");
        alert.showAndWait();
    }

    public void profileOnAction() {
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


    public void backOnAction() {
        button_back.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookRide.fxml"));
            Parent root = loader.load();
            bookRideController br = loader.getController();
            br.dataInit(customer, userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 750, 532));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
