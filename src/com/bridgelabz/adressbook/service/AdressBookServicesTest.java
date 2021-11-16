package com.bridgelabz.adressbook.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.adressbook.entity.ContactPerson;

public class AdressBookServicesTest {

	public static List<ContactPerson> contacts = new ArrayList<>();

	public static List<ContactPerson> getContacts() {
		return contacts;
	}

	public static void setContacts(List<ContactPerson> contacts) {
		AdressBookServicesTest.contacts = contacts;
	}

	
}
