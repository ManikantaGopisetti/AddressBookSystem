package com.bridgelabz.adressbook.entity;

import java.util.Map;
import java.util.Scanner;
import com.bridgelabz.adressbook.service.MultipleAddressBooksServices;
import com.bridgelabz.adressbook.service.AddressBookServices;
import com.bridgelabz.adressbook.service.IAddressBookServices;

public class AddressBookApp {

	public static void main(String[] args) {

		System.out.println("----------Welcome to Address Book Program-----------");

		Map<String, AddressBook> addressBooks = MultipleAddressBooks.getAddressBooks();
		MultipleAddressBooksServices multipleAddressBooksServices = new MultipleAddressBooksServices();
		IAddressBookServices addressBookServices = new AddressBookServices();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"Enter your choice:\n 1. Add contact\n 2.Edit Contact\n 3.Delete contact\n 4.Add multiple contacts\n 5.Add address book\n "
							+ "6.Print contacts\n 7.Search by city/state\n 8.View person by city/state\n 9.Get contacts count using city/state\n "
							+ "10.Sort Contacts in an address book \n 11.Read contacts from file\n 12.Write contacts into file\n "
							+ "13.Read contacts from CSV file\n 14.Write contacts into CSV file\n 15.Exit");
			int choice = sc.nextInt();

			try {
				switch (choice) {

				case 1:
					System.out.println("Enter contact detais to add: ");
					System.out.print(" Enter the name of the address book: ");
					String adBookName = sc.next();
					addressBookServices.addContact(addressBooks, adBookName);
					break;

				case 2:
					System.out.println("Enter contact detais to edit: ");
					System.out.print(" Enter the name of the address book: ");
					adBookName = sc.next();
					addressBookServices.editContact(addressBooks, adBookName);
					break;

				case 3:
					System.out.println("Enter contact detais to delete: ");
					System.out.print(" Enter the name of the address book: ");
					adBookName = sc.next();
					addressBookServices.deleteContact(addressBooks, adBookName);
					break;

				case 4:
					System.out.print("Enter the name of the address book: ");
					adBookName = sc.next();
					System.out.println("Enter no of contacts to add: ");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						addressBookServices.addContact(addressBooks, adBookName);
					}
					break;

				case 5:
					multipleAddressBooksServices.addAddressBook(addressBooks);
					break;

				case 6:
					System.out.println("Contact list of all address books: ");
					addressBookServices.printContacts(addressBooks);
					break;

				case 7:
					multipleAddressBooksServices.searchPersonByCityState(addressBooks);
					break;

				case 8:
					multipleAddressBooksServices.viewPersonByCityState();
					break;

				case 9:
					multipleAddressBooksServices.getNoOfContacts();
					break;

				case 10:
					System.out.print(" Enter the name of the address book: ");
					adBookName = sc.next();
					addressBookServices.sortContacts(addressBooks, adBookName);
					break;

				case 11:
					addressBookServices.readcontactsFromFile();
					break;

				case 12:
					addressBookServices.writeContactsIntoFile();
					break;

				case 13:
					addressBookServices.readFromCSVFile();
					break;

				case 14:
					addressBookServices.writeIntoCSVFile();
					break;

				case 15:
					System.out.println("Exiting address book ");
					sc.close();
					return;

				default:
					System.out.println("Please enter a valid choice ");
					sc.close();
					break;

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}