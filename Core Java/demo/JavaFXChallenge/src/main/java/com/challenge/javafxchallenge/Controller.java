package com.challenge.javafxchallenge;

import com.challenge.javafxchallenge.datamodel.Contact;
import com.challenge.javafxchallenge.datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.util.Optional;

public class Controller
{
    @FXML
    private BorderPane mainWindow;

    private ContactData data;

    @FXML
    private TableView<Contact> contactsTable;

    public void initialize()
    {
        data = new ContactData();
        data.loadContacts();
        contactsTable.setItems(data.getContacts());
    }

    @FXML
    public void showContactDialogPane()
    {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setHeaderText("Fill in the Information for the new Contact");
        dialog.setTitle("Add a New Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ContactDialog.fxml"));

        try
        {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK)
        {
            DialogController dc = fxmlLoader.getController();
            Contact newContact = dc.getContact();
            data.addContact(newContact);
            data.saveContacts();
        }
    }

    @FXML
    public void showEditContactDialog()
    {
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();

        if(selectedContact == null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select the Contact, You want to edit.");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setHeaderText("Edit the values in the fields");
        dialog.setTitle("Edit the Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ContactDialog.fxml"));

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

        DialogController dc = fxmlLoader.getController();
        dc.editContact(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK)
        {
            dc.updateContact(selectedContact);
            data.saveContacts();
        }
    }

    @FXML
    public void deleteContact()
    {
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();

        if(selectedContact == null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Select a Contact to delete");
            alert.showAndWait();
            return;
        }

        Alert delAlert = new Alert(Alert.AlertType.CONFIRMATION);
        delAlert.setTitle("Delete a Contact");
        delAlert.setHeaderText(null);
        delAlert.setContentText("Do you want to delete the Contact? \n" +
                "First Name : "+selectedContact.getFirstName()+"\n"+
                "Last Name : "+selectedContact.getLastName()+"\n"+
                "Phone Number : "+selectedContact.getPhoneNumber());

        Optional<ButtonType> res = delAlert.showAndWait();

        if(res.isPresent() && res.get() == ButtonType.OK)
        {
            data.deleteContact(selectedContact);
            data.saveContacts();
        }
    }
}