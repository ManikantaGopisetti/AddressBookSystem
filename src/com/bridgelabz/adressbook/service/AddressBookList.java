package com.bridgelabz.adressbook.service;

import java.util.ArrayList;
import java.util.List;

public class AddressBookList {
	
	private static List<AdressBookServicesTest> adressBook = new ArrayList<AdressBookServicesTest>();

	public static List<AdressBookServicesTest> getAdressBook() {
		return adressBook;
	}

	public static void setAdressBook(List<AdressBookServicesTest> adressBook) {
		AddressBookList.adressBook = adressBook;
	}
	
}
