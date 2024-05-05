package sample;

import company.customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class customerHistory  {

    @FXML
    private Button button_profile;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_history;
    @FXML
    private Button button_back;

    @FXML
    private TableView<history> table;
    @FXML
    private TableColumn<history,String> col_name;
    @FXML
    private TableColumn<history,String> col_ploc;
    @FXML
    private TableColumn<history,String> col_dloc;
    @FXML
    private TableColumn<history,String> col_vehicle;
    @FXML
    private TableColumn<history,String> col_time;

    private int userId;
    private company.customer customer;

    ObservableList<history> history = FXCollections.observableArrayList();

    public void dataInit(customer c, int id) {

        customer = c;
        userId = id;
        System.out.println("userID in customerhistory == " + userId);


        databaseconnector connectDB = new databaseconnector();
        Connection connection = connectDB.getConnection();

        try {

            String query = "select * from history " +
                    "inner join customer on history.cust_id = customer.cust_id " +
                    "inner join rider on history.rider_id = rider.rider_id " +
                    "where history.cust_id = "+userId +";";

            ResultSet rs = connection.createStatement().executeQuery(query);

            while (rs.next()){

                history.add(new history(rs.getInt("h_id"),rs.getString("rider_name"), rs.getString("pickup_location"), rs.getString("dest_location"), rs.getString("vehicle"), rs.getString("time") ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        col_name.setCellValueFactory(new PropertyValueFactory<history,String>("name"));
        col_ploc.setCellValueFactory(new PropertyValueFactory<history,String>("ploc"));
        col_dloc.setCellValueFactory(new PropertyValueFactory<history,String>("dloc"));
        col_vehicle.setCellValueFactory(new PropertyValueFactory<history,String>("vehicle"));
        col_time.setCellValueFactory(new PropertyValueFactory<history,String>("time"));

        table.setItems(history);
        System.out.println(table.getScene());
    }



    public void historyOnAction() {

    }

    public void profileOnAction() {
        button_profile.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerEdit.fxml"));
            Parent root = loader.load();
            customerEdit ce =loader.getController();
            ce.dataInit(customer,userId);

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