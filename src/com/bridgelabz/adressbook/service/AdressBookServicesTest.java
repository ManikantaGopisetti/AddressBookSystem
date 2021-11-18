package com.bridgelabz.adressbook.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.adressbook.entity.ContactPerson;

public class AdressBookServicesTest {

	private List<ContactPerson> contacts = new ArrayList<>();

	private String adName;

	public AdressBookServicesTest(String adName) {
		super();
		this.adName = adName;
	}

	public List<ContactPerson> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactPerson> contacts) {
		this.contacts = contacts;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

}
