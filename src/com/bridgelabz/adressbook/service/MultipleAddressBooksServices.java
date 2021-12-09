package com.bridgelabz.adressbook.service;

import java.util.Map;
import java.util.Scanner;
import com.bridgelabz.adressbook.entity.AddressBook;
import com.bridgelabz.adressbook.entity.MultipleAddressBooks;

public class MultipleAddressBooksServices {

	public void addAddressBook(Map<String, AddressBook> addressBooks) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter address book name: ");
		String name = sc.next();
		
		//checking for duplicate address book
		if (addressBooks.containsKey(name)) {
			System.out.println("\nAddress book name alread exist \n");
		} else {
			addressBooks.put(name, new AddressBook());
			MultipleAddressBooks.setAddressBooks(addressBooks);
		}
	}
}
