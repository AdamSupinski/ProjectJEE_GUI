package org.jeeclasses.movierental.jfxclient.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.jeeclasses.movierental.jfxclient.MainApp;
import org.jeeclasses.movierental.jfxclient.model.CustomerType;
import org.jeeclasses.movierental.jfxclient.model.MovieStatus;
import org.jeeclasses.movierental.jfxclient.model.ObservableMovie;

import javax.naming.NamingException;


/**
 * @author Adam
 */
public class UserViewController {

    private ObservableList<ObservableMovie> moviesList = FXCollections.observableArrayList();

    private MainApp mainApp;

    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button detailsButton;
    @FXML
    private Button rentButton;
    @FXML
    private Button logoutButton;

    @FXML
    private TableView<ObservableMovie> moviesTable;
    @FXML
    private TableColumn<ObservableMovie, String> titleColumn;
    @FXML
    private TableColumn<ObservableMovie, Integer> releaseYearColumn;
    @FXML
    private TableColumn<ObservableMovie, String> statusColumn;

    public UserViewController() {

    }

    @FXML
    private void initialize() {
        moviesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitle());
        releaseYearColumn.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear().asObject());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusAsStringProperty());

    }

    public void setMainApp(MainApp mainApp) throws NamingException {
        this.mainApp = mainApp;

        if (mainApp.getCustomer().getType() == CustomerType.USER) {
            addButton.setDisable(true);
            editButton.setDisable(true);
            removeButton.setDisable(true);
        }

        //TODO put on movieList data from DB in form of ObservableMovies

        long id = 0;
        String title = "Sample Title";
        int releaseYear = 2000;

        for (int i = 0; i < 14; i++) {
            moviesList.add(new ObservableMovie(id + i, title + " " + i, releaseYear + i, MovieStatus.AVAILABLE));
        }

        moviesTable.setItems(moviesList);
    }

    @FXML
    private void handleAdd() {
        mainApp.showMovieAddDialog();
    }

    @FXML
    private void handleEdit() {
        ObservableList<ObservableMovie> selection = moviesTable.getSelectionModel().getSelectedItems();

        if (selection.isEmpty() || selection.equals(null)) {
            // Nothing selected
            showAlertNoMoviesSelected();
            return;
        }

        if (selection.size() != 1) {
            // Selected 2 or more rows
            showAlertTooManyMoviesSelected();
            return;
        }

        mainApp.showMovieEditDialog(selection.get(0));
    }

    @FXML
    private void handleRemove() {
        ObservableList<ObservableMovie> selection = moviesTable.getSelectionModel().getSelectedItems();

        if (selection.isEmpty() || selection.equals(null)) {
            // Nothing selected
            showAlertNoMoviesSelected();
            return;
        }

        moviesTable.getItems().removeAll(selection);

        //TODO remove also from DB
    }

    @FXML
    private void handleDetails() {
        ObservableList<ObservableMovie> selection = moviesTable.getSelectionModel().getSelectedItems();

        if (selection.isEmpty() || selection.equals(null)) {
            // Nothing selected
            showAlertNoMoviesSelected();
            return;
        }

        if (selection.size() != 1) {
            // Selected 2 or more rows
            showAlertTooManyMoviesSelected();
            return;
        }

        mainApp.showMovieDetailsDialog(selection.get(0));
    }

    @FXML
    private void handleRent() {
        ObservableList<ObservableMovie> selection = moviesTable.getSelectionModel().getSelectedItems();

        if (selection.isEmpty() || selection.equals(null)) {
            // Nothing selected
            showAlertNoMoviesSelected();
            return;
        }

        if (selection.size() != 1) {
            // Selected 2 or more rows
            showAlertTooManyMoviesSelected();
            return;
        }

        mainApp.showMovieRentDialog(selection.get(0));

    }

    @FXML
    private void handleLogout() {
        mainApp.setCustomer(null);
        mainApp.showLoginView();
    }

    public void showAlertNoMoviesSelected() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Nie wybrano filmu");
        alert.setHeaderText("Nie wybrano filmu");
        alert.setContentText("Proszę wybrać film z tabeli.");

        alert.showAndWait();
    }

    public void showAlertTooManyMoviesSelected() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Wybrano zbyt wiele filmów");
        alert.setHeaderText("Wybrano więcej niż jeden wiersz");
        alert.setContentText("Proszę wybrać jeden wiersz z filmem");

        alert.showAndWait();
    }

    public TableView<ObservableMovie> getMoviesTable() {
        return moviesTable;
    }
}
