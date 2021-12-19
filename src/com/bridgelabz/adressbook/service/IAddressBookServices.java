package com.bridgelabz.adressbook.service;

import java.io.IOException;
import java.util.Map;
import com.bridgelabz.adressbook.entity.AddressBook;
import com.bridgelabz.adressbook.entity.ContactPerson;

public interface IAddressBookServices {

	public void addContact(Map<String, AddressBook> addressBooks, String adBookName);

	public void editContact(Map<String, AddressBook> addressBooks, String adBookName);

	public void deleteContact(Map<String, AddressBook> addressBooks, String adBookName);
	
	public void sortContacts(Map<String, AddressBook> addressBooks, String adBookName);

	public ContactPerson findContact(AddressBook adBook);

	void printContacts(Map<String, AddressBook> addressBooks);
	
	public void readcontactsFromFile() throws IOException;
	
	public void writeContactsIntoFile() throws IOException;
	
	public void writeIntoCSVFile() throws IOException;
	
	public void readFromCSVFile() throws IOException;
	
	public void writeIntoJSON_File() throws IOException;
	
	public void readFromJSON_File() throws IOException;

}