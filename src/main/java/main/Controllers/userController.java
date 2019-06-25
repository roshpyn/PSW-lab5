package main.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import main.models.Event;
import main.models.FoodType;

public class userController {

    @FXML
    private ComboBox<Event> comboBox_event;
    @FXML
    private ComboBox<FoodType> comboBox_food;
    @FXML
    private Button button;
    @FXML
    private Label label_date;


    private ObservableList<Event> events = FXCollections.observableArrayList();

    @FXML
    private void signup(){

    }
    @FXML
    private void check_combobox_event(){

    }
    @FXML
    private void check_combobox_food(){

    }



}
