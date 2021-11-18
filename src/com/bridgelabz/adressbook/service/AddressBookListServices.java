package com.bridgelabz.adressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookListServices {

	public void addAddressBook() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter address book name: ");
		String name = sc.next();
		int count = 0;
		List<AdressBookServicesTest> adbook = AddressBookList.getAdressBook();
		for (AdressBookServicesTest adressbook : adbook) {
			if (adressbook.getAdName().equals(name)) {
				count++;
			}
		}
		if (count > 0) {
			System.out.println("Address book name alread exist ");
		} else {
			adbook.add(new AdressBookServicesTest(name));
			AddressBookList.setAdressBook(adbook);
		}
	}
}
