package com.bridgelabz.adressbook.entity;

public class ContactPerson {

	String firstName, lastName, address, city, state, email;
	int zipCode;
	Long phoneNumber;

	public ContactPerson(String firstName, String lastName, String address, String city, String state, String email,
			int zipCode, Long phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactDetails [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", email=" + email + ", zipCode=" + zipCode + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
