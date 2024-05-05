package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


abstract public class RegistrationController {
    @FXML
    private Label registerMessageLabel;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_phone;
    @FXML
    private Button button_signup;
    @FXML
    private Hyperlink button_signin;


    public Label getRegisterMessageLabel() {
        return registerMessageLabel;
    }

    public TextField getTf_name() {
        return tf_name;
    }

    public TextField getTf_username() {
        return tf_username;
    }

    public TextField getTf_password() {
        return tf_password;
    }

    public TextField getTf_phone() {
        return tf_phone;
    }

    public Button getButton_signup() {
        return button_signup;
    }

    public Hyperlink getButton_signin() {
        return button_signin;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {}


//    public void loginButtonOnAction(ActionEvent event) throws SQLException {
//        //loginMessageLabel.setText("You try to login");
//
//
//        if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false ) {
//            validateLogin();
//
//
//        } else {
//            loginMessageLabel.setText("Enter Username and Password");
//        }
//    }

    public void signinButtonOnAction(){
        button_signup.getScene().getWindow().hide();
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

    public void registerButtonOnAction() throws SQLException {
        registerMessageLabel.setText("");

    }

    abstract public void registerUser() throws SQLException;

}
