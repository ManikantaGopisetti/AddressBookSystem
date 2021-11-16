package com.bridgelabz.adressbook.entity;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	public static void main(String[] args) {

		System.out.println("----------Welcome to Address Book Program-----------");

		List<ContactPerson> contacts = new ArrayList<>();

		ContactPerson newContact = new ContactPerson("Mani", "Gopisetti", "Ravulapalem", "East Godavari", "A.P",
				"mani@gmail.com", 533236, 9000000000l);

		contacts.add(newContact);

		System.out.println(contacts);
	}

}