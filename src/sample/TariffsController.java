package sample;

import company.customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TariffsController {
    @FXML
    private Button button_back;

    private int userId;
    private customer customer;

    public void dataInit(customer c,int id){
        userId = id;
        customer = c;
    }

    public void backOnAction(){
        button_back.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookRide.fxml"));
            Parent root = loader.load();
            bookRideController br =loader.getController();
            br.dataInit(customer,userId);

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
