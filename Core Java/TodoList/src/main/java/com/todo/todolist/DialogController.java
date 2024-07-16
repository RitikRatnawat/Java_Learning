package com.todo.todolist;

import com.todo.todolist.datamodel.TodoData;
import com.todo.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController
{
    @FXML
    private TextField sd;

    @FXML
    private TextArea ld;

    @FXML
    private DatePicker dl;

    public TodoItem processResults()
    {
        String shortDescription = sd.getText().trim();
        String longDescription = ld.getText().trim();
        LocalDate deadline = dl.getValue();

        TodoItem newItem = new TodoItem(shortDescription, longDescription, deadline);
        TodoData.getObj().addTodoItem(newItem);
        return newItem;
    }
}
