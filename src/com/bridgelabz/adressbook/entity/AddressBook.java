package com.bridgelabz.adressbook.entity;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.adressbook.service.AddressBookServices;

public class AddressBook {

	public static void main(String[] args) {

		System.out.println("----------Welcome to Address Book Program-----------");

		List<ContactPerson> contacts = new ArrayList<>();
		AddressBookServices ads = new AddressBookServices();

		ContactPerson newContact = new ContactPerson("Mani", "Gopisetti", "Ravulapalem", "East Godavari", "A.P",
				"mani@gmail.com", 533236, 9000000000l);

		contacts.add(newContact);			//adding contact to list
		ads.addContact(contacts);			//adding new contact by invoking addContact method

		for (ContactPerson contact : contacts) {
			System.out.println(contact);
		}
	
		
	}

}