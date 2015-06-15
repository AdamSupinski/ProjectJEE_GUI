package org.jeeclasses.movierental.jfxclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.jeeclasses.movierental.jfxclient.MainApp;


public class RegisterViewController {

    @FXML
    private Button registerButton;
    @FXML
    private Button returnButton;
    @FXML
    private Label registerErrorLabel;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField postcodeTextField;
    @FXML
    private TextField cityTextField;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleRegister() {
        if (isDataValid()) {
            //TODO create customer here && add him to DB

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Zakończono dodawanie użytkownika");
            alert.setHeaderText(null);
            alert.setContentText("Pomyślnie zarejestrowano użytkownika!");

            alert.showAndWait();

            //return to LoginView
            mainApp.showLoginView();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd tworzenia użytkownika");
            alert.setHeaderText(null);
            alert.setContentText("Wprowadzono niepoprawne dane");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleReturn() {
        mainApp.showLoginView();
    }

    public boolean isDataValid() {
        return passwordTextField.getText().equals(confirmPasswordTextField.getText())
                && !emailTextField.getText().equals("")
                && !passwordTextField.getText().equals("")
                && !nameTextField.getText().equals("")
                && !addressTextField.getText().equals("")
                && !postcodeTextField.getText().equals("")
                && !cityTextField.getText().equals("");
    }

}
