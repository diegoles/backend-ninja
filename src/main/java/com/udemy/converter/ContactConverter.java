package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public ContactModel convertContact2ContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();

		contactModel.setId(contact.getId());
		contactModel.setFirstName(contact.getFirstName());
		contactModel.setLastName(contact.getLastName());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());

		return contactModel;
	}

	public Contact convertContactModel2Contact(ContactModel contactModel) {
		Contact contact = new Contact();

		contact.setId(contactModel.getId());
		contact.setFirstName(contactModel.getFirstName());
		contact.setLastName(contactModel.getLastName());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());

		return contact;
	}

}
