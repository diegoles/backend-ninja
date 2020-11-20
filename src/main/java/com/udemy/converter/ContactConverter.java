package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

    public ContactModel convertContact2ContactModel(Contact contact) {
        return ContactModel.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .telephone(contact.getTelephone())
                .city(contact.getCity())
                .build();
    }

    public Contact convertContactModel2Contact(ContactModel contactModel) {
        return Contact.builder()
                .id(contactModel.getId())
                .firstName(contactModel.getFirstName())
                .lastName(contactModel.getLastName())
                .telephone(contactModel.getTelephone())
                .city(contactModel.getCity())
                .build();
    }

}
