package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

    public ContactModel convertContact2ContactModel(Contact contact) {
        return ContactModel.builder()
                .id(contact.getId())
                .ci(contact.getCi())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .age(contact.getAge())
                .bloodType(contact.getBloodType())
                .telephone(contact.getTelephone())
                .cellphone(contact.getCellphone())
                .city(contact.getCity())
                .address(contact.getAddress())
                .build();
    }

    public Contact convertContactModel2Contact(ContactModel contactModel) {
        return Contact.builder()
                .id(contactModel.getId())
                .ci(contactModel.getCi())
                .firstName(contactModel.getFirstName())
                .lastName(contactModel.getLastName())
                .age(contactModel.getAge())
                .bloodType(contactModel.getBloodType())
                .telephone(contactModel.getTelephone())
                .cellphone(contactModel.getCellphone())
                .city(contactModel.getCity())
                .address(contactModel.getAddress())
                .build();
    }

}
