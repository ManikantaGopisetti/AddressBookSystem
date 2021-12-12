package com.bridgelabz.adressbook.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bridgelabz.adressbook.entity.AddressBook;
import com.bridgelabz.adressbook.entity.ContactPerson;
import com.bridgelabz.adressbook.entity.MultipleAddressBooks;

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

		ContactPerson newContact = new ContactPerson();

		try {
			System.out.print("ENTER FIRST NAME:");
			String fname = sc.next();
			newContact.setFirstName(fname);

			// checking for duplicate contact with first name
			for (ContactPerson contact : contacts) {
				if (contact.getFirstName().equals(fname)) {
					System.out.println("contact with same name already exists in this address book \n");
					return;
				}
			}

			System.out.print("ENTER LAST NAME: ");
			newContact.setLastName(sc.next());
			System.out.print("ENTER ADDRESS: ");
			newContact.setAddress(sc.next());
			System.out.print("ENTER CITY: ");
			newContact.setCity(sc.next());
			System.out.print("ENTER STATE: ");
			newContact.setState(sc.next());
			System.out.print("ENTER EMAIL: ");
			newContact.setEmail(sc.next());
			System.out.print("ENTER ZIP CODE: ");
			newContact.setZipCode(sc.nextInt());
			System.out.print("ENTER PHONE NUMBER: ");
			newContact.setPhoneNumber(sc.nextLong());

			contacts.add(newContact);

			Map<String, List<ContactPerson>> cityDictionary = MultipleAddressBooks.getCityDictionary();

			Map<String, List<ContactPerson>> stateDictionary = MultipleAddressBooks.getStateDictionary();

			if (!cityDictionary.containsKey(newContact.getCity())) {
				List<ContactPerson> cityContacts = new ArrayList<ContactPerson>();
				cityDictionary.put(newContact.getCity(), cityContacts);
			}
			cityDictionary.get(newContact.getCity()).add(newContact);
			if (!stateDictionary.containsKey(newContact.getState())) {
				List<ContactPerson> stateContacts = new ArrayList<ContactPerson>();
				stateDictionary.put(newContact.getState(), stateContacts);
			}
			stateDictionary.get(newContact.getState()).add(newContact);

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

			// incase of contact deleted it should be removed from dictionary with city and
			// state also
			if (MultipleAddressBooks.getCityDictionary().containsKey(contact.getCity())) {
				MultipleAddressBooks.getCityDictionary().get(contact.getCity()).remove(contact);
			}
			if (MultipleAddressBooks.getStateDictionary().containsKey(contact.getState())) {
				MultipleAddressBooks.getStateDictionary().get(contact.getState()).remove(contact);
			}
			System.out.println("contact removed from adress book\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sortContacts(Map<String, AddressBook> addressBooks, String adBookName) {

		adressBook = findAddressBook(addressBooks, adBookName);

		System.out.println(
				"Enter your choice:\n 1. Sort contacts by First name\n 2.Sort contacts by City name\n 3.Sort contacts by State name\n 4.Sort contacts by Zip code");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			List<ContactPerson> sortedAddressBookFname = adressBook.getContacts().stream()
					.sorted((contact1, contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
					.collect(Collectors.toList());
			System.out.println("Sorted contacts : \n"+sortedAddressBookFname);

			break;

		case 2:
			List<ContactPerson> sortedAddressBookCity = adressBook.getContacts().stream()
					.sorted((contact1, contact2) -> contact1.getCity().compareTo(contact2.getCity()))
					.collect(Collectors.toList());
			System.out.println("Sorted contacts : \n"+sortedAddressBookCity);

			break;

		case 3:
			List<ContactPerson> sortedAddressBookState = adressBook.getContacts().stream()
					.sorted((contact1, contact2) -> contact1.getState().compareTo(contact2.getState()))
					.collect(Collectors.toList());
			System.out.println("Sorted contacts : \n"+sortedAddressBookState);

			break;

		case 4:
			List<ContactPerson> sortedAddressBookZip = adressBook.getContacts().stream().sorted((contact1,contact2) -> 
					(String.valueOf(contact1.getZipCode()).compareTo(String.valueOf(contact2.getZipCode()))))
					.collect(Collectors.toList());
			System.out.println("Sorted contacts : \n"+sortedAddressBookZip);

			break;

		default:
			System.out.println("Please enter a valid choice ");
			break;

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
