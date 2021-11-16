package com.bridgelabz.adressbook.service;

import java.util.List;
import java.util.Scanner;
import com.bridgelabz.adressbook.entity.ContactPerson;

public class AddressBookServices {

	String firstName, lastName, address, city, state, email;
	int zipCode;
	
	Scanner sc =new Scanner(System.in);
	
	public void addContact(List<ContactPerson> contacts) {
	
		System.out.print("ENTER FIRST NAME: ");
		String addFirstName = sc.next();
		System.out.print("ENTER LAST NAME: ");
		String addLastName = sc.next();
		System.out.print("ENTER ADDRESS: ");
		String addAddress = sc.next();
		System.out.print("ENTER CITY: ");
		String addCity = sc.next();
		System.out.print("ENTER STATE: ");
		String addState = sc.next();
		System.out.print("ENTER EMAIL: ");
		String addEmail = sc.next();
		System.out.print("ENTER ZIP CODE: ");
		int addZipCode = sc.nextInt();
		System.out.print("ENTER PHONE NUMBER: ");
		long addPhoneNumber = sc.nextLong();

		ContactPerson newContact = new ContactPerson(addFirstName, addLastName, addAddress, addCity, addState,
				addEmail, addZipCode, addPhoneNumber);
		contacts.add(newContact);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
