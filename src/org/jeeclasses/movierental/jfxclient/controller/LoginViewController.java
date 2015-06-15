package org.jeeclasses.movierental.jfxclient.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.jeeclasses.movierental.jfxclient.MainApp;
import org.jeeclasses.movierental.jfxclient.model.Customer;
import org.jeeclasses.movierental.jfxclient.model.CustomerType;

/**
 * @author Adam
 */
public class LoginViewController {

    private MainApp mainApp;

    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label loginErrorLabel;



    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    @FXML
    private void handleLogin() {
        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        //TODO replace stuff below with searching for user in DB

        Customer customer = new Customer();

        /**
         * Admin
         */
        customer.setType(CustomerType.ADMIN);

        /**
         * User
         */
        //customer.setType(CustomerType.USER);

        /**
         * If in DB exists such customer
         */

        loginErrorLabel.setText("");

        mainApp.setCustomer(customer);

        mainApp.showUserView();

        /**
         * If there is no such customer in DB
         */
        /*
        loginErrorLabel.setText("Wprowadzono niepoprawne dane");
         */
    }

    @FXML
    private void handleRegister() {
        mainApp.showRegisterView();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

}