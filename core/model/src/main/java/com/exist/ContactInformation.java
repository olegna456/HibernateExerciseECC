package com.exist.model;
import java.io.*;

public class ContactInformation implements Serializable {

	private int contactId;
	private String landline;
	private String mobileNumber;
	private String email;
	private Person person;

	public ContactInformation() {

	}

	public ContactInformation(String landline, String mobileNumber, String email) {
		this.landline = landline;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public int getContactId() {
		return this.contactId;
	}

	public String getLandline() {
		return this.landline;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	public String toString() {
		return "[Contact id = " +  contactId + " " + "Landline number = " + landline + " " + "Mobile number = " + mobileNumber + " " + "Email = " + email +"]";
	}


}