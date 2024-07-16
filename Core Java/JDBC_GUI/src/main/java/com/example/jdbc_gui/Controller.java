package com.example.jdbc_gui;

import com.example.jdbc_gui.model.Album;
import com.example.jdbc_gui.model.Artist;
import com.example.jdbc_gui.model.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

public class Controller
{
    @FXML
    private TableView artistTable;

    @FXML
    private ProgressBar pbar;

    @FXML
    public void listArtists()
    {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        pbar.progressProperty().bind(task.progressProperty());

        pbar.setVisible(true);
        
        task.setOnSucceeded(e -> pbar.setVisible(false));
        task.setOnFailed(e -> pbar.setVisible(false));

        new Thread(task).start();
    }

    @FXML
    public void listAlbums()
    {
        Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if(artist == null)
         {
            System.out.println("No Artist Selected");
            return;
        }

        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(
                        DataSource.getInstance().queryAlbumsforArtistID(artist.getId())
                );
            }
        };

        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void updateArtist()
    {
        Artist artist = (Artist) artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return DataSource.getInstance().updateArtist("AC/DC", artist.getId());
            }
        };

        task.setOnSucceeded(e -> {
            if(task.valueProperty().get())
            {
                artist.setName("AC/DC");
                artistTable.refresh();
            }
        });

        new Thread(task).start();
    }
}

class GetAllArtistsTask extends Task
{
    @Override
    protected ObservableList<Artist> call()
    {
        return FXCollections.observableArrayList(
                DataSource.getInstance().queryArtist(DataSource.ORDER_BY_ASC));
    }
}