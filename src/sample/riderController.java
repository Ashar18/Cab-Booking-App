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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class riderController extends RegistrationController {

    @FXML
    private Label registerMessageLabel;
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
    @FXML
    private RadioButton radio_standard;
    @FXML
    private RadioButton radio_buisness;
    @FXML
    private RadioButton radio_vip;
    @FXML
    private RadioButton radio_van;

    int userId;
    rider rider = null;


    public MenuButton getLoc() {
        return loc;
    }

    public MenuItem getNk() {
        return nk;
    }

    public MenuItem getNn() {
        return nn;
    }

    public MenuItem getBf() {
        return bf;
    }

    public MenuItem getGi() {
        return gi;
    }

    public RadioButton getRadio_standard() {
        return radio_standard;
    }

    public RadioButton getRadio_buisness() {
        return radio_buisness;
    }

    public RadioButton getRadio_vip() {
        return radio_vip;
    }

    public RadioButton getRadio_van() {
        return radio_van;
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

    public void registerUser() throws SQLException {
        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();


        ToggleGroup toggleGroup2 = new ToggleGroup();
        radio_standard.setToggleGroup(toggleGroup2);
        radio_buisness.setToggleGroup(toggleGroup2);
        radio_vip.setToggleGroup(toggleGroup2);
        radio_van.setToggleGroup(toggleGroup2);
        String toggleVehicle = ((RadioButton) toggleGroup2.getSelectedToggle()).getText();

        if (!getTf_username().getText().isEmpty() && !getTf_name().getText().isEmpty() && !getTf_password().getText().isEmpty() && !getTf_phone().getText().isEmpty()) {
            String insertFields = "insert into rider (rider_name,username,password,r_phone,vehicle,location) values ('";
            String insertValues = getTf_name().getText() + "','" + getTf_username().getText() + "','" + getTf_password().getText() + "','" + getTf_phone().getText() + "','" + toggleVehicle + "','" + loc.getText() + "')";

            String queryRegister = insertFields + insertValues;


            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(queryRegister);

                getButton_signup().getScene().getWindow().hide();


                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Parent root = loader.load();
                Stage registerStage = new Stage();
                registerStage.setTitle("CABZ");
                registerStage.setScene(new Scene(root, 512, 397));
                registerStage.show();

            } catch (Exception e) {
                e.getCause();
                getRegisterMessageLabel().setText("Username already exist");
            } finally {
                connection.close();
            }

        } else {
            System.out.println("enter complete info");
            registerMessageLabel.setText("Enter complete info");
        }
    }

    public void registerButtonOnAction() throws SQLException {
        getRegisterMessageLabel().setText("");
        registerUser();
    }

}


