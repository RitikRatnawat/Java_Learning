package com.challenge.javafxchallenge;

import com.challenge.javafxchallenge.datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DialogController
{
    @FXML
    private TextField fntf;

    @FXML
    private TextField lntf;

    @FXML
    private TextField pntf;

    @FXML
    private TextField nttf;

    public Contact getContact()
    {
        String firstName = fntf.getText();
        String lastName = lntf.getText();
        String phoneNumber = pntf.getText();
        String notes = nttf.getText();

        return new Contact(firstName, lastName, phoneNumber, notes);
    }

    public void editContact(Contact contact)
    {
        fntf.setText(contact.getFirstName());
        lntf.setText(contact.getLastName());
        pntf.setText(contact.getPhoneNumber());
        nttf.setText(contact.getNotes());
    }

    public void updateContact(Contact contact)
    {
        contact.setFirstName(fntf.getText());
        contact.setLastName(lntf.getText());
        contact.setPhoneNumber(pntf.getText());
        contact.setNotes(nttf.getText());
    }
}
