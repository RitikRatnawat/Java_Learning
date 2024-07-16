package com.css.css_with_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class Controller
{
    @FXML
    private Label lbl;

    @FXML
    private Button btn4;

    @FXML
    private GridPane gridpane;

    public void initialize()
    {
        btn4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseClick()
    {
        lbl.setScaleX(2.0);
        lbl.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit()
    {
        lbl.setScaleX(1.0);
        lbl.setScaleY(1.0);
    }

    @FXML
    public void handleClick()
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

//      DirectoryChooser chooser = new DirectoryChooser();
        List<File> file = chooser.showOpenMultipleDialog(gridpane.getScene().getWindow());
        if(file != null)
        {
            for(int i = 0; i < file.size(); i++)
                System.out.println(file.get(i));
        }
        else
        {
            System.out.println("Dialog is Cancelled");
        }
    }

    @FXML
    public void handleLinkClick()
    {
        try
        {
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(URISyntaxException e)
        {
            e.printStackTrace();
        }
    }
}