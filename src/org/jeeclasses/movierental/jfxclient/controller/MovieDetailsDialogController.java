package org.jeeclasses.movierental.jfxclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jeeclasses.movierental.jfxclient.MainApp;
import org.jeeclasses.movierental.jfxclient.model.CustomerType;
import org.jeeclasses.movierental.jfxclient.model.MovieStatus;
import org.jeeclasses.movierental.jfxclient.model.ObservableMovie;

public class MovieDetailsDialogController {

    private MainApp mainApp;
    private Stage dialogStage;
    private ObservableMovie movie;

    @FXML
    private Label titleLabel;
    @FXML
    private Label releaseYearLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label returnDateLabel;
    @FXML
    private Label customerNameLabel;
    @FXML
    private Button closeButton;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMovie(ObservableMovie movie) {
        this.movie = movie;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showDetails() {
        if(this.movie!=null && this.mainApp!=null && this.mainApp.getCustomer()!=null) {
            titleLabel.setText(movie.getTitle().getValue().toString());
            releaseYearLabel.setText(movie.getReleaseYear().getValue().toString());
            statusLabel.setText(movie.getStatus().toString());

            if(movie.getStatus() == MovieStatus.AVAILABLE) {
                statusLabel.setTextFill(Color.GREEN);
            } else {
                statusLabel.setTextFill(Color.RED);
            }

            //TODO get return date and set in line below
            //returnDateLabel.setText();

            if(mainApp.getCustomer().getType() == CustomerType.ADMIN) {
                //TODO description below
                customerNameLabel.setText("NAME OF CUSTOMER WHO RENT THIS BOOK GOES HERE");
            } else {
                customerNameLabel.setText("Brak uprawnień");
            }
        }
    }



    @FXML
    private void handleClose() {
        this.dialogStage.close();
    }

}
