package com.bridgelabz.adressbook.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.adressbook.service.AddressBookList;
import com.bridgelabz.adressbook.service.AddressBookListServices;
import com.bridgelabz.adressbook.service.AddressBookServices;
import com.bridgelabz.adressbook.service.AdressBookServicesTest;

public class AddressBook {

	public static void main(String[] args) {

		System.out.println("----------Welcome to Address Book Program-----------");
		Scanner sc = new Scanner(System.in);

		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		AddressBookServices ads = new AddressBookServices();
		AddressBookListServices abl = new AddressBookListServices();

		abl.addAddressBook();

		ads.addContact(); // adding new contact by invoking addContact method
		for (ContactPerson contact : contacts) {
			System.out.println(contact);
		}
		while (true) {
			System.out.println(
					"Enter your choice:\n 1. Add contact\n 2.Edit Contact\n 3.Delete contact\n 4.Add multiple contacts\n 5.Add address book\n 6.Print contacts\n 7.Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter contact detais to add: ");
				ads.addContact();
				break;

			case 2:
				System.out.println("Enter contact detais to edit: ");
				ads.editContact();
				break;

			case 3:
				System.out.println("Enter contact detais to delete: ");
				ads.deleteContact();
				break;

			case 4:
				System.out.println("Enter no of contacts to add: ");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					ads.addContact();
				}

			case 5:
				System.out.println("Enter name of the address book: ");
				abl.addAddressBook();

			case 6:
				System.out.println("contact list of address book: ");
				ads.printContacts();
				break;

			case 7:
				System.out.println("Exiting address book ");
				sc.close();
				return;

			}
		}

	}
}