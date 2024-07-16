package com.todo.todolist;

import com.todo.todolist.datamodel.TodoData;
import com.todo.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;


public class Controller
{
    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea ta;

    @FXML
    private Label dateLabel;

    @FXML
    private BorderPane main_window;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItem> filterlist;

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;

    @FXML
    public void initialize()
    {
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if(t1 != null)
                {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    ta.setText(item.getLongDescription());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dateLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return (todoItem.getDeadline().equals(LocalDate.now()));
            }
        };

        filterlist = new FilteredList<>(TodoData.getObj().getTodoItems(), wantAllItems);

        SortedList<TodoItem> sortedList = new SortedList<>(filterlist,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2)
                    {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });

        //todoListView.setItems(TodoData.getObj().getTodoItems());
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView)
            {
                ListCell<TodoItem> cell = new ListCell<>(){

                    @Override
                    protected void updateItem(TodoItem todoItem, boolean b)
                    {
                        super.updateItem(todoItem, b);
                        if(b)
                            setText(null);
                        else
                        {
                            setText(todoItem.getShortDescription());
                            if(todoItem.getDeadline().isBefore(LocalDate.now().plusDays(1)))
                                setTextFill(Color.RED);
                            else if(todoItem.getDeadline().equals(LocalDate.now().plusDays(1)))
                                setTextFill(Color.BROWN);
                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty)
                                cell.setContextMenu(null);
                            else
                                cell.setContextMenu(listContextMenu);
                        }
                );

                return cell;
            }
        });
    }

    @FXML
    public void showTodoItemDialog()
    {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(main_window.getScene().getWindow());
        dialog.setTitle("Add new Todo Item");
        dialog.setHeaderText("Use this Dialog to add new TodoItem");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("TodoDialog.fxml"));

        try
        {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK)
        {
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
            todoListView.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent event)
    {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();

        if(item != null)
        {
            if(event.getCode().equals(KeyCode.DELETE))
                deleteItem(item);
        }

    }

    @FXML
    public void handleFilterButton()
    {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();

        if(filterToggleButton.isSelected())
        {
            filterlist.setPredicate(wantTodaysItems);

            if(filterlist.isEmpty())
            {
                ta.clear();
                dateLabel.setText("");
            }
            else if(filterlist.contains(selectedItem))
            {
                todoListView.getSelectionModel().select(selectedItem);
            }
            else
            {
                todoListView.getSelectionModel().selectFirst();
            }
        }
        else
        {
            filterlist.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem);
        }
    }

    @FXML
    public void handleExit()
    {
        Platform.exit();
    }

    public void deleteItem(TodoItem item)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete TodoItem");
        alert.setHeaderText("Delete TodoItem : " + item.getShortDescription());
        alert.setContentText("Are You Sure? Press OK to confirm or Cancel");

        Optional<ButtonType> res = alert.showAndWait();

        if(res.isPresent() && res.get() == ButtonType.OK)
        {
            TodoData.getObj().deleteTodoItem(item);
        }
    }
}