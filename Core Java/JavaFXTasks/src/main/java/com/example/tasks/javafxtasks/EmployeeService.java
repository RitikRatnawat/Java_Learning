package com.example.tasks.javafxtasks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>>
{
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<>() {
            @Override
            protected ObservableList<String> call() throws Exception
            {
                String[] names = {"Joe Root",
                        "Shane Watson",
                        "David Warner",
                        "Suresh Raina",
                        "John Andrews",
                        "Andrew Russell"};

                ObservableList<String> employees = FXCollections.observableArrayList();

                for(int i=0; i<6; i++)
                {
                    employees.add(names[i]);
                    updateMessage("Added "+names[i]+" to the List");
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                }

                return employees;
            }
        };
    }
}
