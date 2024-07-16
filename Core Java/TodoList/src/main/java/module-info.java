module com.todo.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.todo.todolist to javafx.fxml;
    exports com.todo.todolist;
}