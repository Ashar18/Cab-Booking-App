package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class signupController {
    @FXML
    private RadioButton radio_customer;
    @FXML
    private RadioButton radio_rider;
    @FXML
    private Button button_next;


    public void next(){
        button_next.getScene().getWindow().hide();

        ToggleGroup toggleGroup = new ToggleGroup();
        radio_customer.setToggleGroup(toggleGroup);
        radio_rider.setToggleGroup(toggleGroup);

        String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

        if (toggleName.equals("Customer")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("CustomerRegister.fxml"));
                Stage registerStage = new Stage();
                registerStage.setTitle("CABZ");
                registerStage.setScene(new Scene(root, 600, 550));
                registerStage.show();

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        else if (toggleName.equals("Rider")){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("rider.fxml"));
                Stage registerStage = new Stage();
                registerStage.setTitle("CABZ");
                registerStage.setScene(new Scene(root, 600, 550));
                registerStage.show();

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }

    }

}


