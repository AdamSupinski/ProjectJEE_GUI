package org.jeeclasses.movierental.jfxclient.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jeeclasses.movierental.jfxclient.MainApp;
import org.jeeclasses.movierental.jfxclient.model.ObservableMovie;

public class MovieEditDialogController {
    private MainApp mainApp;
    private Stage dialogStage;
    private ObservableMovie movie;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField releaseYearTextField;
    @FXML
    private Button saveButton;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setMovie(ObservableMovie movie) {
        this.movie = movie;
    }

    public void setDetails() {
        if(this.movie!=null && this.mainApp!=null && this.mainApp.getCustomer()!=null) {
            titleTextField.setText(movie.getTitle().getValue().toString());
            releaseYearTextField.setText(movie.getReleaseYear().getValue().toString());
        }
    }

    @FXML
    public void handleSave() {
        if(!isInputValid()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Wprowadzono zły rok ");
            alert.setHeaderText("Nie podano poprawnego roku premiery");
            alert.setContentText("Proszę podać poprawne dane");

            alert.showAndWait();
            return;
        }
        this.movie.setTitle(titleTextField.getText());
        this.movie.setReleaseYear(Integer.parseInt(releaseYearTextField.getText()));
        //refreshing TableView to show updated items
        ObservableList<ObservableMovie> list = FXCollections.observableArrayList(mainApp.getUserViewController().getMoviesTable().getItems());

        mainApp.getUserViewController().getMoviesTable().getItems().removeAll(list);

        mainApp.getUserViewController().getMoviesTable().setItems(list);

        //TODO save changes in DB

        dialogStage.close();
    }

    private boolean isInputValid() {
        int year;

        try {
            year = Integer.parseInt(releaseYearTextField.getText());
        } catch (Exception e) {
            return false;
        }

        return !(year <= 1900 || year > 2015);
    }
}
