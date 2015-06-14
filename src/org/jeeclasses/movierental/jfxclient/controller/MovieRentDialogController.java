package org.jeeclasses.movierental.jfxclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.jeeclasses.movierental.jfxclient.MainApp;
import org.jeeclasses.movierental.jfxclient.model.ObservableMovie;

import java.time.LocalDate;

public class MovieRentDialogController {

    private MainApp mainApp;
    private Stage dialogStage;
    private ObservableMovie movie;

    @FXML
    private DatePicker datePicker;
    @FXML
    private Button rentButton;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMovie(ObservableMovie movie) {
        this.movie = movie;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleRent() {
        LocalDate datePickerValue = datePicker.getValue();

        dialogStage.close();
    }
}
