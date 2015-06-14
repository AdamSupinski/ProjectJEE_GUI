package org.jeeclasses.movierental.jfxclient.model;

import javafx.beans.property.*;

/**
 *
 * @author Adam
 */
public class ObservableMovie {

    private final LongProperty id;
    private StringProperty title;
    private IntegerProperty releaseYear;
    private MovieStatus status;

    public ObservableMovie(long id, String title, int releaseYear, MovieStatus status) {
        this.id = new SimpleLongProperty(id);
        this.title = new SimpleStringProperty(title);
        this.releaseYear = new SimpleIntegerProperty(releaseYear);
        this.status = status;
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
    }

    public IntegerProperty getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(IntegerProperty releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = new SimpleIntegerProperty(releaseYear);
    }

    public MovieStatus getStatus() {
        return status;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    public StringProperty getStatusAsStringProperty()
    {
        return new SimpleStringProperty(status.toString());
    }







}
