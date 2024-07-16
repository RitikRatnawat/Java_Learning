package com.example.tasks.javafxtasks;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller
{
//    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar pbar;

    @FXML
    private Label pLabel;

    private Service<ObservableList<String>> service;

    public void initialize()
    {
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception
//            {
////                Thread.sleep(1000);
//
//                String[] names = {"Joe Root",
//                                "Shane Watson",
//                                "David Warner",
//                                "Suresh Raina",
//                                "John Andrews",
//                                "Andrew Russell"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
//
//                for(int i=0; i<6; i++)
//                {
//                    employees.add(names[i]);
//                    updateMessage("Added "+names[i]+" to the List");
//                    updateProgress(i + 1, 6);
//                    Thread.sleep(200);
//                }
//
////                Platform.runLater(new Runnable()
////                {
////                    @Override
////                    public void run()
////                    {
////                        listView.setItems(employees);
////                    }
////                });
//
//                return employees;
//            }
//        };

        service = new EmployeeService();
        pbar.progressProperty().bind(service.progressProperty());
        pLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());

//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent)
//            {
//                pbar.setVisible(true);
//                pLabel.setVisible(true);
//            }
//        });
//
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent)
//            {
//                pbar.setVisible(false);
//                pLabel.setVisible(false );
//            }
//        });
//
//        pbar.setVisible(false);
//        pLabel.setVisible(false);

        pbar.visibleProperty().bind(service.runningProperty());
        pLabel.visibleProperty().bind(service.runningProperty());
    }

    @FXML
    public void buttonPressed()
    {
        if(service.getState() == Worker.State.SUCCEEDED)
        {
            service.reset();
            service.start();
        }
        else if(service.getState() == Service.State.READY)
        {
            service.start();
        }
    }

}