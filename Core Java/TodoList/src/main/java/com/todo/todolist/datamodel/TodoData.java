package com.todo.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData
{
    private static TodoData obj = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter df;

    private TodoData()
    {
        df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static TodoData getObj()
    {
        return obj;
    }

    public ObservableList<TodoItem> getTodoItems()
    {
        return todoItems;
    }

    public void addTodoItem(TodoItem item)
    {
        todoItems.add(item);
    }

    public void deleteTodoItem(TodoItem item)
    {
        todoItems.remove(item);
    }

    public void loadTodoItems() throws IOException
    {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try
        {
            input = br.readLine();

            while(input != null)
            {
                String itemPieces[] = input.split("\t");

                String sd = itemPieces[0];
                String ld = itemPieces[1];
                LocalDate dl = LocalDate.parse(itemPieces[2], df);

                TodoItem item = new TodoItem(sd, ld, dl);
                todoItems.add(item);
                input = br.readLine();
            }
        }
        finally
        {
            if(br != null)
                br.close();
        }
    }

    public void storeTodoItems() throws IOException
    {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try
        {
            Iterator<TodoItem> iter = todoItems.iterator();

            while(iter.hasNext())
            {
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getLongDescription(),
                        item.getDeadline().format(df)));
                bw.newLine();
            }
        }
        finally
        {
            if(bw != null)
                bw.close();
        }
    }
}
