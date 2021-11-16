package com.bridgelabz.adressbook.entity;

import java.util.List;
import java.util.Scanner;

import com.bridgelabz.adressbook.service.AddressBookServices;
import com.bridgelabz.adressbook.service.AdressBookServicesTest;

public class AddressBook {

	public static void main(String[] args) {

		System.out.println("----------Welcome to Address Book Program-----------");
		Scanner sc=new Scanner(System.in);

		List<ContactPerson> contacts = AdressBookServicesTest.getContacts();
		AddressBookServices ads = new AddressBookServices();

		ads.addContact(); // adding new contact by invoking addContact method
		for (ContactPerson contact : contacts) {
			System.out.println(contact);
		}
		while (true) {
			System.out.println("Enter your choice:\n 1. Add\n 2.Edit Contact 3. Exit ");
			int choice= sc.nextInt();
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
				System.out.println("Exited : ");
				sc.close();
				return;
				
			}
		}
		
	}
}