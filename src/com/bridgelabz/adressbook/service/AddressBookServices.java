package com.bridgelabz.adressbook.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import com.bridgelabz.adressbook.entity.AddressBook;
import com.bridgelabz.adressbook.entity.ContactPerson;

public class AddressBookServices implements IAddressBookServices {

	public static AddressBook adressBook;

	Scanner sc = new Scanner(System.in);

	@Override
	public void addContact(Map<String, AddressBook> addressBooks, String adBookName) {

		adressBook = findAddressBook(addressBooks, adBookName);
		if (adressBook == null) {
			return;
		}
		List<ContactPerson> contacts = adressBook.getContacts();

		System.out.print("ENTER FIRST NAME:");
		String name = sc.next();
		//checking for duplicate contact with first name
		for (ContactPerson contact : contacts) {
			if(contact.getFirstName().equals(name)) {
				System.out.println("contact with same name already exists \n");
				return;
			}
		}
		
		System.out.println("ENTER LAST NAME: ");
		System.out.println("ENTER ADDRESS: ");
		System.out.println("ENTER CITY: ");
		System.out.println("ENTER STATE: ");
		System.out.println("ENTER EMAIL: ");
		System.out.println("ENTER ZIP CODE: ");
		System.out.println("ENTER PHONE NUMBER: ");

		try {
			ContactPerson newContact = new ContactPerson(name, sc.next(), sc.next(), sc.next(), sc.next(),
					sc.next(), sc.nextInt(), sc.nextLong());
			contacts.add(newContact);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editContact(Map<String, AddressBook> addressBooks, String adBookName) {

		adressBook = findAddressBook(addressBooks, adBookName);
		if (adressBook == null) {
			return;
		}

		ContactPerson contact = findContact(adressBook);
		if (contact == null) {
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

	@Override
	public void deleteContact(Map<String, AddressBook> addressBooks, String adBookName) {
		adressBook = findAddressBook(addressBooks, adBookName);
		List<ContactPerson> contacts;
		try {
			contacts = adressBook.getContacts();
			ContactPerson contact = findContact(adressBook);
			if (contact == null) {
				System.out.println("no contact found with the given name\n");
				return;
			}
			contacts.remove(contact);
			System.out.println("contact removed from adress book\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ContactPerson findContact(AddressBook adBook) {
		List<ContactPerson> contacts = adBook.getContacts();
		System.out.println("\n Enter first name: ");
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

		} else if (duplicate > 1) {
			System.out.print(" There are multiple contacts with given name.\n Please enter email id also: ");
			String email = sc.next();
			for (ContactPerson contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
					return contact;
				}
			}
		}
		return temp;

	}

	private AddressBook findAddressBook(Map<String, AddressBook> addressBooks, String adBookName) {

		if (addressBooks.size() == 0) {
			System.out.println("Please create an address book first! \n");
			return null;
		}

		Iterator<Entry<String, AddressBook>> iterator = addressBooks.entrySet().iterator();
		while (iterator.hasNext()) {

			Map.Entry<String, AddressBook> entry = iterator.next();
			if (entry.getKey().equals(adBookName)) {
				return entry.getValue();
			}
		}

		System.out.println("Address book does not exist! \n");
		return null;
	}

	@Override
	public void printContacts(Map<String, AddressBook> addressBooks) {
		System.out.println(addressBooks);
	}
}
