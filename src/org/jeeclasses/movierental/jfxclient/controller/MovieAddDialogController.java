package org.jeeclasses.movierental.jfxclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jeeclasses.movierental.jfxclient.MainApp;
import org.jeeclasses.movierental.jfxclient.model.MovieStatus;
import org.jeeclasses.movierental.jfxclient.model.ObservableMovie;


public class MovieAddDialogController {

    private MainApp mainApp;
    private Stage dialogStage;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField releaseYearTextField;
    @FXML
    private Button addButton;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleAdd() {
        if(!isInputValid()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Wprowadzono zły rok ");
            alert.setHeaderText("Nie podano poprawnego roku premiery");
            alert.setContentText("Proszę podać poprawne dane");

            alert.showAndWait();
            return;
        }
        //TODO first add to DB, then retrieve and get ID
        //TODO then insert right ID value into constructor
        ObservableMovie newMovie = new ObservableMovie(0, titleTextField.getText(),
                Integer.parseInt(releaseYearTextField.getText()), MovieStatus.AVAILABLE);

        //TODO remember to add it do DB

        mainApp.getUserViewController().getMoviesTable().getItems().add(newMovie);

        dialogStage.close();
    }

    private boolean isInputValid() {
        int year;

        try {
            year = Integer.parseInt(releaseYearTextField.getText());
        } catch (Exception e) {
            return false;
        }

        if(year<=1900 || year > 2015) return false;
        else
            return true;
    }
}
