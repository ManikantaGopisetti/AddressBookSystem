package com.bridgelabz.adressbook.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleAddressBooks {

	static Map<String, AddressBook> addressBooks = new HashMap<>();

	public static Map<String, AddressBook> getAddressBooks() {
		return addressBooks;
	}

	public static void setAddressBooks(Map<String, AddressBook> addressBooks) {
		MultipleAddressBooks.addressBooks = addressBooks;
	}

	static Map<String, List<ContactPerson>> cityDictionary = new HashMap<>();

	static Map<String, List<ContactPerson>> stateDictionary = new HashMap<>();

	public static Map<String, List<ContactPerson>> getCityDictionary() {
		return cityDictionary;
	}

	public static void setCityDictionary(Map<String, List<ContactPerson>> cityDictionary) {
		MultipleAddressBooks.cityDictionary = cityDictionary;
	}

	public static Map<String, List<ContactPerson>> getStateDictionary() {
		return stateDictionary;
	}

	public static void setStateDictionary(Map<String, List<ContactPerson>> stateDictionary) {
		MultipleAddressBooks.stateDictionary = stateDictionary;
	}

	@Override
	public String toString() {
		return "MultipleAddressBooks [" + addressBooks + "=addressBooks]";
	}

}
