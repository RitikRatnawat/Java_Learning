package com.rp.events;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller
{
    @FXML
    private TextField tf1;
    @FXML
    private Button HelloBtn;
    @FXML
    private Button ByeBtn;
    @FXML
    private CheckBox cb1;
    @FXML
    private Label lb1;

    @FXML
    public void initialize()
    {
        HelloBtn.setDisable(true);
        ByeBtn.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e)
    {
        if(e.getSource().equals(HelloBtn))
            System.out.println("Hello, "+tf1.getText()+"!");

        if(e.getSource().equals(ByeBtn))
            System.out.println("Bye, "+tf1.getText()+"!");

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try
                {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("Sleeping on "+s);

                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("Updating "+s);
                            lb1.setText("We did Something");
                        }
                    });
                }
                catch (InterruptedException ev) {}
            }
        };

        new Thread(task).start();

        if(cb1.isSelected())
        {
            tf1.clear();
            HelloBtn.setDisable(true);
            ByeBtn.setDisable(true);
        }
    }

    @FXML
    public void handleKeyPressed()
    {
        String text = tf1.getText();
        boolean state = text.isEmpty() || text.trim().isEmpty();
        HelloBtn.setDisable(state);
        ByeBtn.setDisable(state);
    }

    @FXML
    public void handleChange()
    {
        System.out.println("The CheckBox is "+(cb1.isSelected()?"checked":"not checked"));
    }
}