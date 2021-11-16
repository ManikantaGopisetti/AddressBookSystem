package com.bridgelabz.adressbook.service;

import java.util.List;
import java.util.Scanner;
import com.bridgelabz.adressbook.entity.ContactPerson;

public class AddressBookServices {

	String firstName, lastName, address, city, state, email;
	int zipCode;
	long phoneNumber;

	Scanner sc = new Scanner(System.in);

	List<ContactPerson> contacts = AdressBookServicesTest.getContacts();

	public void addContact() {

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

	public ContactPerson findContact() {
		System.out.println("/n Enter first name: ");
		String name = sc.next();
		int duplicate = 0;
		ContactPerson temp = null;
		for (ContactPerson contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				duplicate++;
				temp = contact;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if(duplicate >1){
			System.out.print(" There are multiple contacts with given name.\n Please enter their email id also: ");
			String email = sc.next();
			for (ContactPerson contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
					return contact;
				}
			}
		}
		return temp;

	}

	public void editContact() {

		ContactPerson contact = findContact();
		
		if(contact == null) {
			System.out.println(" no contact found with the given name");
			return;
		}

		System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
				+ "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit email" + "\n 7.Edit zipcode"
				+ "\n 8.Edit phone number");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter new first name");
			String newFirstName = sc.next();
			contact.setFirstName(newFirstName);
			System.out.println("new first name updated");

			break;
		case 2:
			System.out.println("Enter new last name");
			String newLastName = sc.next();
			contact.setLastName(newLastName);
			System.out.println("new last name updated");

			break;
		case 3:
			System.out.println("Enter new address");
			String newAddress = sc.next();
			contact.setAddress(newAddress);
			System.out.println("new newaddress updated");

			break;
		case 4:
			System.out.println("Enter new city");
			String newCity = sc.next();
			contact.setCity(newCity);
			System.out.println("new city updated");

			break;
		case 5:
			System.out.println("Enter new state");
			String newState = sc.next();
			contact.setState(newState);
			System.out.println("new state updated");

			break;
		case 6:
			System.out.println("Enter new email");
			String newEmail = sc.next();
			contact.setEmail(newEmail);
			System.out.println("new email updated");

			break;
		case 7:
			System.out.println("Enter new zip code");
			int newZipCode = sc.nextInt();
			contact.setZipCode(newZipCode);
			System.out.println("new zip code updated");
			break;
		case 8:
			System.out.println("Enter new phone number");
			long newPhoneNumber = sc.nextLong();
			contact.setPhoneNumber(newPhoneNumber);
			System.out.println("new phone number updated");

			break;

		default:
			System.out.println("Please enter a number between 1 to 8 only...");
			break;
		}
		System.out.println("after editing: " + contact);

	}
	public void deleteContact() {
		ContactPerson contact = findContact();
		if (contact == null) {
			System.out.println("no contact found with the given name");
			return;
		}
		contacts.remove(contact);
		System.out.println("contact removed from adress book");
	}

}
