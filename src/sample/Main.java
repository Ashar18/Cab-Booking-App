package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("hello to cabz");
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("CABZ");
        primaryStage.setScene(new Scene(root, 512, 397));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
