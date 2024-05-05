package sample;

import company.customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class customerController extends RegistrationController {
    @FXML
    private Label registerMessageLabel;
    @FXML
    private TextField tf_address;
    @FXML
    private TextField tf_accno;

    int userId;
    customer customer = null;

    public TextField getTf_address() {
        return tf_address;
    }

    public TextField getTf_accno() {
        return tf_accno;
    }

    public void registerUser() throws SQLException {
        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        if (!getTf_username().getText().isEmpty() && !getTf_name().getText().isEmpty() && !getTf_password().getText().isEmpty() && !getTf_phone().getText().isEmpty()){
        String insertFields = "insert into customer (cust_name,username,password,c_phone,address,account_no) values ('";
        String insertValues = getTf_name().getText()+"','"+getTf_username().getText()+"','"+getTf_password().getText()+"','"+getTf_phone().getText()+"','"+tf_address.getText()+"','"+tf_accno.getText()+"')";

        String query = insertFields + insertValues;

        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            getRegisterMessageLabel().setText("You have registered successfully !");
            getButton_signup().getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 512, 397));
            registerStage.show();


            } catch (Exception e) {
                getRegisterMessageLabel().setText("Username already exist");
                e.getCause();

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
