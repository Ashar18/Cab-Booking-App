package sample;

import company.customer;
import company.rider;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class riderEdit extends riderController{

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
    @FXML
    private ToggleGroup a;

    private rider rider;
    private int userId;

    public void nkOnAction(){
        getLoc().setText(getNk().getText());
    }
    public void nnOnAction(){
        getLoc().setText(getNn().getText());
    }
    public void bfOnAction(){
        getLoc().setText(getBf().getText());
    }
    public void giOnAction(){
        getLoc().setText(getGi().getText());
    }

    public void dataInit(rider r, int id) {
        userId = id;
        rider = r;

        header.setText(rider.getName()+"'s Profile");
        getTf_name().setText(rider.getName());
        getTf_username().setText(rider.getUsername());
        getTf_password().setText(rider.getPassword());
        getTf_phone().setText(rider.getPhone());

        if (rider.getVehicleType().equals(getRadio_standard().getText())) getRadio_standard().setSelected(true);
        else if (rider.getVehicleType().equals(getRadio_buisness().getText())) getRadio_buisness().setSelected(true);
        else if (rider.getVehicleType().equals(getRadio_vip().getText())) getRadio_vip().setSelected(true);
        else if (rider.getVehicleType().equals(getRadio_van().getText())) getRadio_van().setSelected(true);
        else System.out.println("no");
        getLoc().setText(rider.getLocation());

    }


    public void resetOnAction(){
        ToggleGroup toggleGroup = new ToggleGroup();
        getRadio_standard().setToggleGroup(toggleGroup);
        getRadio_buisness().setToggleGroup(toggleGroup);
        getRadio_vip().setToggleGroup(toggleGroup);
        getRadio_van().setToggleGroup(toggleGroup);

        RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
        String toggleText = radioButton.getText();

        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        String query = "update rider set rider_name = '"+getTf_name().getText()+"',username = '"+getTf_username().getText()+"',password = '"+getTf_password().getText()+"',r_phone = '"+getTf_phone().getText()+"',vehicle = '"+toggleText+"',location = '"+getLoc().getText()+"' where rider_id = "+userId+";";
        rider.setName(getTf_name().getText());
        rider.setUsername(getTf_username().getText());
        rider.setPassword(getTf_password().getText());
        rider.setPhone(getTf_phone().getText());
        rider.setVehicleType(toggleText);
        rider.setLocation(getLoc().getText());

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



    public void profileOnAction(){

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

    public void historyOnAction(){
        button_history.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("riderHistory.fxml"));
            Parent root = loader.load();
            riderHistory rh = loader.getController();
            rh.dataInit(rider, userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 774, 532));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backOnAction(){
        button_back.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("riderWelcome.fxml"));
            Parent root = loader.load();
            RiderWelcome rc =loader.getController();
            rc.dataInitH(rider,userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 750, 532));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
