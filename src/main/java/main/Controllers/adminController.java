package main.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.models.Event;
import main.models.User;
import main.models.UserOnEvent;


public class adminController {
    //userTab
    @FXML
    private TableView<User> userTableView;
    @FXML
    private TableColumn<User, Long> col_user_id;
    @FXML
    private TableColumn<User, String> col_user_login;
    @FXML
    private TableColumn<User, String> col_user_password;
    @FXML
    private TableColumn<User, String> col_user_name;
    @FXML
    private TableColumn<User, String> col_user_surname;
    @FXML
    private TableColumn<User, String> col_user_email;
    @FXML
    private TableColumn<User, String> col_user_permission;

    private ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    private TextField textField_user_id;
    @FXML
    private TextField textField_user_login;
    @FXML
    private TextField textField_user_password;
    @FXML
    private TextField textField_user_name;
    @FXML
    private TextField textField_user_surname;
    @FXML
    private TextField textField_user_email;
    @FXML
    private TextField textField_user_permission;

    @FXML
    private Button button_user_add;
    @FXML
    private Button button_user_modify;
    @FXML
    private Button button_user_delete;
    @FXML
    private Button button_user_clear;
    @FXML
    private Button button_user_resetPassword;
    //eventTab
    @FXML
    private TableView<Event> eventTableView;
    @FXML
    private TableColumn<Event,Long> col_event_id;
    @FXML
    private TableColumn<Event,Long> col_event_name;
    @FXML
    private TableColumn<Event,Long> col_event_date;

    private ObservableList<Event> events = FXCollections.observableArrayList();

    @FXML
    private TextArea textArea_event_agenda;
    @FXML
    private DatePicker datePicker_event_date;
    @FXML
    private TextField textField_event_id;
    @FXML
    private TextField textField_event_name;
    @FXML
    private TextField textField_event_organizer;

    @FXML
    private Button button_event_add;
    @FXML
    private Button button_event_modify;
    @FXML
    private Button button_event_clear;
    @FXML
    private Button button_event_delete;



    //userOnEventTab
    @FXML
    private Button button_userEvent_accept;
    @FXML
    private Button button_userEvent_discard;


    @FXML
    private TableView<UserOnEvent> userEventTab;
    @FXML
    private TableColumn<UserOnEvent,Long> col_userEvent_id;
    @FXML
    private TableColumn<UserOnEvent,User> col_userEvent_user;
    @FXML
    private TableColumn<UserOnEvent,Boolean> col_userEvent_confirmed;

    private ObservableList<UserOnEvent> userOnEvents = FXCollections.observableArrayList();

    public void initialize(){

    }

    @FXML private void add_user_btn(){
        //TODO}
    }
    @FXML private void modify_user_btn(){
        //TODO}
    }
    @FXML private void delete_user_btn(){
        //TODO}
    }
    @FXML private void clear_user_btn(){
        //TODO}
    }
    @FXML private void reset_user_btn(){
        //TODO}
    }

    @FXML private void add_event_btn(){
        //TODO}
    }
    @FXML private void modify_event_btn(){
        //TODO}
    }
    @FXML private void delete_event_btn(){
        //TODO}
    }
    @FXML private void clear_event_btn(){
        //TODO}
    }
    @FXML private void accept_userEvent_btn(){
        //TODO}
    }
    @FXML private void discard_userEvent_btn(){
        //TODO}
    }
}
