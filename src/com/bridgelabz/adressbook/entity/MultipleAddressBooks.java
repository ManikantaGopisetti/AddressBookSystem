package com.bridgelabz.adressbook.entity;

import java.util.HashMap;
import java.util.Map;

public class MultipleAddressBooks {

	static Map<String, AddressBook> addressBooks = new HashMap<>();

	public static Map<String, AddressBook> getAddressBooks() {
		return addressBooks;
	}

	public static void setAddressBooks(Map<String, AddressBook> addressBooks) {
		MultipleAddressBooks.addressBooks = addressBooks;
	}

//	@Override
//	public String toString() {
//		return "MultipleAddressBooks [" + addressBooks + "=addressBooks]";
//	}

}
