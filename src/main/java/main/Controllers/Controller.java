package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.CheckBox;
import main.DAO.DatabaseDAO;
import main.models.User;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    DatabaseDAO dao = new DatabaseDAO();

    User user  = new User();
    @FXML private TextField registerTextFieldName;
    @FXML private TextField registerTextFieldSurname;
    @FXML private TextField registerTextFieldEmail;
    @FXML private TextField registerTextFieldLogin;

    @FXML private TextField registerTextFieldPassword1;
    @FXML private TextField registerTextFieldPassword2;
    @FXML private PasswordField registerPasswordFieldPassword1;
    @FXML private PasswordField registerPasswordFieldPassword2;
    @FXML private CheckBox registerCheckBoxShowPassword;


    @FXML void ShowPasswordOnRegister(){
        boolean visable = registerCheckBoxShowPassword.isSelected();

        registerPasswordFieldPassword1.setVisible(!visable);
        registerPasswordFieldPassword2.setVisible(!visable);
        registerTextFieldPassword1.setVisible(visable);
        registerTextFieldPassword2.setVisible(visable);

        String password1 = (visable)?registerPasswordFieldPassword1.getText():registerTextFieldPassword1.getText();
        String password2 = (visable)?registerPasswordFieldPassword2.getText():registerTextFieldPassword2.getText();

        if(visable){
            registerTextFieldPassword1.setText(password1);
            registerTextFieldPassword2.setText(password2);
            return;
        }
        registerPasswordFieldPassword1.setText(password1);
        registerPasswordFieldPassword2.setText(password2);

    }
    @FXML void registerCheckEmail(){
        if(!checkEmail(registerTextFieldEmail)){
            registerTextFieldEmail.setStyle("-fx-background-color: rgba(255,0,0,0.5); -fx-border-color: rgba(255,0,0,0.75);");
            return;
        }
        registerTextFieldEmail.setStyle("-fx-background-color: rgba(0,255,0,0.5); -fx-border-color: rgba(0,255,0,0.75);");

    }
    @FXML void registerCheckAvailability(){
        //TODO
        registerTextFieldLogin.setStyle("-fx-background-color: rgba(255,0,0,0.5); -fx-border-color: rgba(255,0,0,0.75);");//error
        registerTextFieldLogin.setStyle("-fx-background-color: rgba(0,255,0,0.5); -fx-border-color: rgba(0,255,0,0.75);");
    }

    @FXML void registerSignUp() {
        String name;
        String surname;
        String email;
        String login;
        String password;
        boolean errors = false;

        if (registerTextFieldName.getText().equals("")) {
            errors = true;
            registerTextFieldName.setStyle("-fx-border-color: rgba(255,0,0,0.75);");
        }
        name = registerTextFieldName.getText();

        if (registerTextFieldSurname.getText().equals("")) {
            errors = true;
            registerTextFieldSurname.setStyle("-fx-border-color: rgba(255,0,0,0.75);");
        }
        surname = registerTextFieldSurname.getText();

        if (registerTextFieldLogin.getText().equals("")) {
            errors = true;
            registerTextFieldLogin.setStyle("-fx-border-color: rgba(255,0,0,0.75);");
        }
        login = registerTextFieldName.getText();

        if(!checkEmail(registerTextFieldEmail)){
            errors = true;
            registerTextFieldEmail.setStyle("-fx-border-color: rgba(255,0,0,0.75);");
        }
        email = registerTextFieldEmail.getText();

        if(!getPassword1Text().equals(getPassword2Text())){
            errors = true;
        }
        password = getPassword1Text();


        //Session session = databaseConf.getSessionFactory().openSession();
        System.out.println(checkConnection().toString());
        if (errors) return;
        System.out.println("LOG: "+name+surname+email+login+password);


        //TODO
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setPermission("USER");

        dao.addUser(user);




    }
    String getPassword1Text(){
        return (registerCheckBoxShowPassword.isSelected())?registerPasswordFieldPassword1.getText():registerTextFieldPassword1.getText();
    }
    String getPassword2Text(){
        return (registerCheckBoxShowPassword.isSelected())?registerPasswordFieldPassword2.getText():registerTextFieldPassword2.getText();
    }


    boolean checkEmail(TextField email){

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email.getText());

        return matcher.matches();
    }
    public Boolean checkConnection() {
        boolean isSuccessful = false;
        try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/psw_lab_5_i_6?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            isSuccessful = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return isSuccessful;
        }
    }

}
