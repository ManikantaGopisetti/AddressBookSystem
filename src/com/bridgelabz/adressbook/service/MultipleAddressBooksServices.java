package com.bridgelabz.adressbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bridgelabz.adressbook.entity.AddressBook;
import com.bridgelabz.adressbook.entity.ContactPerson;
import com.bridgelabz.adressbook.entity.MultipleAddressBooks;

public class MultipleAddressBooksServices {

	Scanner sc = new Scanner(System.in);

	public void addAddressBook(Map<String, AddressBook> addressBooks) {

		System.out.print("Enter address book name: ");
		String name = sc.next();

		// checking for duplicate address book
		if (addressBooks.containsKey(name)) {
			System.out.println("\nAddress book name alread exist \n");
		} else {
			addressBooks.put(name, new AddressBook());
			MultipleAddressBooks.setAddressBooks(addressBooks);
		}
	}

	public void searchPersonByCityState(Map<String, AddressBook> addressBooks) {

		System.out.println("Enter your choice to search from \n1.city \n2.state");
		List<AddressBook> arrlist = addressBooks.entrySet().stream().map(Map.Entry::getValue)
				.collect(Collectors.toList());

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter name of the city");
			String name = sc.next();
			arrlist.stream().forEach(ad -> ad.getContacts().stream().filter(contact -> contact.getCity().equals(name))
					.forEach(contact -> System.out.println(contact)));
			break;

		case 2:
			System.out.println("Enter name of the state");
			name = sc.next();
			arrlist.stream().forEach(ad -> ad.getContacts().stream().filter(contact -> contact.getState().equals(name))
					.forEach(contact -> System.out.println(contact)));
			break;

		default:
			System.out.println("Enter valid choice");
		}

	}

	public void viewPersonByCityState() {

		System.out.println("Enter your choice to view from \n1.city \n2.state");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Map<String, List<ContactPerson>> cityDictionary = MultipleAddressBooks.getCityDictionary();
			System.out.println("Enter name of the city");
			String name = sc.next();
			cityDictionary.entrySet().stream().filter(contact -> contact.getKey().equals(name))
					.forEach(contact -> System.out.println(contact.getValue()));
			;
			break;

		case 2:
			Map<String, List<ContactPerson>> stateDictionary = MultipleAddressBooks.getStateDictionary();
			System.out.println("Enter name of the state");
			name = sc.next();
			stateDictionary.entrySet().stream().filter(contact -> contact.getKey().equals(name))
					.forEach(contact -> System.out.println(contact.getValue()));
			;
			break;

		default:
			System.out.println("Enter valid choice");
		}
	}

	public void getNoOfContacts() {
		System.out.println("Enter your choice to get contacts count from \n1.city \n2.state");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Map<String, List<ContactPerson>> cityDictionary = MultipleAddressBooks.getCityDictionary();
			System.out.println("Enter name of the city");
			String name = sc.next();
			cityDictionary.entrySet().stream().filter(contact -> contact.getKey().equals(name))
					.forEach(contact -> System.out.println(contact.getValue().size()));
			;
			break;

		case 2:
			Map<String, List<ContactPerson>> stateDictionary = MultipleAddressBooks.getStateDictionary();
			System.out.println("Enter name of the state");
			name = sc.next();
			stateDictionary.entrySet().stream().filter(contact -> contact.getKey().equals(name))
					.forEach(contact -> System.out.println(contact.getValue().size()));
			;
			break;

		default:
			System.out.println("Enter valid choice");
		}

	}

}
