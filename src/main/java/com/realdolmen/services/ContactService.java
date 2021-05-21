package com.realdolmen.services;

import com.realdolmen.domain.Contact;
import com.realdolmen.repositories.ContactRepository;

import java.sql.SQLException;

public class ContactService {

    private ContactRepository contactRepository = new ContactRepository();

    public void saveContact(Contact newContact) throws SQLException {
        contactRepository.saveContact(newContact);
    }
}
