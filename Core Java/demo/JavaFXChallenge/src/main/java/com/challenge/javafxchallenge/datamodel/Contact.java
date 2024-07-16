package com.challenge.javafxchallenge.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class Contact
{
    private final SimpleStringProperty firstName = new SimpleStringProperty("");
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
    private final SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    private final SimpleStringProperty notes = new SimpleStringProperty("");

    public Contact()
    {
    }

    public Contact(String fn, String ln, String pn, String nts)
    {
        this.firstName.set(fn);
        this.lastName.set(ln);
        this.phoneNumber.set(pn);
        this.notes.set(nts);
    }

    public String getFirstName()
    {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }

    public String getLastName()
    {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber()
    {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber.set(phoneNumber);
    }

    public String getNotes()
    {
        return notes.get();
    }

    public SimpleStringProperty notesProperty()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes.set(notes);
    }

    @Override
    public String toString()
    {
        return "Contact{" +
                "firstname = "+firstName +
                ", lastname = "+lastName+
                ", phonenumber = "+phoneNumber+
                ", notes = "+notes+
                "}";
    }
}
