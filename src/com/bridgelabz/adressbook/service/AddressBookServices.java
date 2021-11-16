package com.bridgelabz.adressbook.service;

import java.util.List;
import java.util.Scanner;
import com.bridgelabz.adressbook.entity.ContactPerson;

public class AddressBookServices {

	String firstName, lastName, address, city, state, email;
	int zipCode;
	long phoneNumber;

	Scanner sc = new Scanner(System.in);

	public void addContact(List<ContactPerson> contacts) {

		System.out.print("ENTER FIRST NAME: ");
		firstName = sc.next();
		System.out.print("ENTER LAST NAME: ");
		lastName = sc.next();
		System.out.print("ENTER ADDRESS: ");
		address = sc.next();
		System.out.print("ENTER CITY: ");
		city = sc.next();
		System.out.print("ENTER STATE: ");
		state = sc.next();
		System.out.print("ENTER EMAIL: ");
		email = sc.next();
		System.out.print("ENTER ZIP CODE: ");
		zipCode = sc.nextInt();
		System.out.print("ENTER PHONE NUMBER: ");
		phoneNumber = sc.nextLong();

		ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, email, zipCode,
				phoneNumber);
		contacts.add(newContact);

	}

}
