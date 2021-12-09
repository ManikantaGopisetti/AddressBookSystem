package com.bridgelabz.adressbook.entity;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<ContactPerson> contacts = new ArrayList<>();

	public List<ContactPerson> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactPerson> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "AddressBook [contacts=" + contacts + "]\n";
	}

}
