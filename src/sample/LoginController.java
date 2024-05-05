package sample;

import company.customer;
import company.rider;
import company.user;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController {


    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private RadioButton radio_customer;
    @FXML
    private RadioButton radio_rider;
    @FXML
    private Button button_Login;
    @FXML
    private Hyperlink button_Register;


    private int userId;
    public String username;
    public String type;

    private String customer_pickup;            // majboori me attribute use krna pr rha he
    private String customer_dest;              // majboori me attribute use krna pr rha he
    private String customer_vehicle;           // majboori me attribute use krna pr rha he



    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        //loginMessageLabel.setText("You try to login");


        if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false ) {
            validateLogin();
            System.out.println(userId);


        } else {
            loginMessageLabel.setText("Enter Username and Password");
        }
    }
//
//
//
//
    user user = null;

     void validateLogin() throws SQLException {
        ToggleGroup toggleGroup = new ToggleGroup();
        radio_customer.setToggleGroup(toggleGroup);
        radio_rider.setToggleGroup(toggleGroup);

        String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();


        databaseconnector connectNow = new databaseconnector();
        Connection connectDB = connectNow.getConnection();
        Statement statement = connectDB.createStatement();

        if (toggleName.isEmpty()) loginMessageLabel.setText("Invalid Login. Please try again");

        else {

            String verifyLogin = "SELECT * FROM " + toggleName + " WHERE username = '" + usernameTextField.getText() + "' AND password ='" + enterPasswordField.getText() + "'";

            try {

                ResultSet queryResult = statement.executeQuery(verifyLogin);

                int count = 0;
                while (queryResult.next()) {

                    //loginMessageLabel.setText("Congratulation!");

                    if (toggleName.equals("Customer")) {

                        userId = queryResult.getInt("cust_id");
                        user = new customer(userId,queryResult.getString("cust_name"),queryResult.getString("username"),queryResult.getString("password"), queryResult.getString("c_phone"),queryResult.getString("address"),queryResult.getString("account_no"));

                        customer_pickup = queryResult.getString("pickup_location");
                        customer_dest = queryResult.getString("dest_location");
                        customer_vehicle = queryResult.getString("select_vehicle");

                    } else if (toggleName.equals("Rider")) {
                        userId = queryResult.getInt("rider_id");
                        user = new rider(userId,queryResult.getString("rider_name"),queryResult.getString("username"),queryResult.getString("password"), queryResult.getString("r_phone"),queryResult.getString("vehicle"),queryResult.getString("location"));

                    }

                    count++;
                }
                if (count == 1) {
                    if (toggleName.equals("Customer")) {
                        customerUI();
                    }
                    else if (toggleName.equals("Rider")) {
                        riderUI();

                    }
                } else {
                        loginMessageLabel.setText("Invalid login. Please try again");
                }



            }catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();

                } finally {
                    statement.close();
                    connectDB.close();

                }
            }
        user = user;
        }



    public void registerButtonOnAction(){
        button_Login.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 472, 282));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }




    public void customerUI(){
        button_Login.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerWelcome.fxml"));
            Parent root = loader.load();
            welcomeController wc =loader.getController();
            customer customer = (customer) user;

            customer.setPickup_loc(customer_pickup);
            customer.setDest_loc(customer_dest);
            customer.setVehicleType(customer_vehicle);

            wc.dataInit(customer,userId);

            Stage registerStage = new Stage();
            registerStage.setTitle("CABZ");
            registerStage.setScene(new Scene(root, 750, 532));
            registerStage.show();



        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



    public void riderUI(){
        button_Login.getScene().getWindow().hide();
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("RiderWelcome.fxml"));
            Parent root = loader.load();
            RiderWelcome rw =loader.getController();
            rider rider = (rider) user;

            rw.dataInit(rider,userId);


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

