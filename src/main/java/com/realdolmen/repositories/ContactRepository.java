package com.realdolmen.repositories;

import com.realdolmen.domain.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactRepository {

    public void saveContact(Contact newContact) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into contacts (contact_name , contact_email , contact_message) values(?,?,?)");
            preparedStatement.setString(1, newContact.getName());
            preparedStatement.setString(2, newContact.getEmail());
            preparedStatement.setString(3, newContact.getMessage());
            preparedStatement.execute();

        } catch (Exception e) {
            throw e;
        }
    }

}
