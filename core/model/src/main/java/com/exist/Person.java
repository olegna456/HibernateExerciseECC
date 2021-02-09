package com.exist.model;

import java.io.*;
import java.util.*;


// @Table(name="person")
public class Person implements Serializable { 
	private int id;
	private String lastName;
	private String firstName;
	private String middleName;
	private String suffix;
	private String title;
	private int streetNumber;
	private String barangay;
	private String municipalityorcity;
	private int zipcode;
	private String birthday;
	private String dateHired;
	private double gwa;
	private boolean employed;
	private List<ContactInformation> contactinformation = new ArrayList<>();
	private List<Roles> role = new ArrayList<>();
	
	public Person() { 

	}

	public Person(String lastName, String firstName, String middleName,  String suffix, String title, int streetNumber, String barangay, String municipalityOrCity, int zipcode, String birthday, String dateHired, double gwa, boolean currentlyEmployed) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.suffix = suffix;
		this.title = title;
		this.streetNumber = streetNumber;
		this.barangay = barangay;
		this.municipalityorcity = municipalityOrCity;
		this.zipcode = zipcode;
		this.birthday = birthday;
		this.dateHired = dateHired;
		this.gwa = gwa;
		this.employed = currentlyEmployed;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public void setMunicipalityorcity(String municipalityorcity) {
		this.municipalityorcity = municipalityorcity;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public void setGwa(double gwa) {
		this.gwa = gwa;
	}

	public void setEmployed(boolean currentlyEmployed) {
		this.employed = currentlyEmployed;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public String getTitle() {
		return this.title;
	}

	public int getStreetNumber() {
		return this.streetNumber;
	}

	public String getBarangay() {
		return this.barangay;
	}

	public String getMunicipalityorcity() {
		return this.municipalityorcity;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public String getDateHired() {
		return this.dateHired;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public double getGwa() {
		return this.gwa;
	}

	public boolean getEmployed() {
		return this.employed;
	}

	public void setContactinformation(List<ContactInformation> contactinformation) {
		this.contactinformation = contactinformation;
	}

	public List<ContactInformation> getContactinformation() {
		return this.contactinformation;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}

	public List<Roles> getRole() {
		return this.role;
	}

	public String toString() {
		if(this.contactinformation.isEmpty()) {

		} else {
			for(ContactInformation contact: this.contactinformation) {
				System.out.println(contact.toString());
			}
		}

		if(this.role.isEmpty()) {

		} else {
			for(Roles role : this.role) {
				System.out.println(role.toString());
			}
		}
		String fullName = lastName + "," + firstName + " " + middleName;
		String zip = String.valueOf(zipcode);
		String strtNum = String.valueOf(streetNumber);
		String fulladdress = strtNum + " " + barangay + " " + municipalityorcity + " " + zip;

		return "[Person id =" + id + " " + "Person name = " + fullName + " "  + "Address = " + fulladdress + " " +  "Date of Birth = " + birthday + " " + "Grade Weighted Average = " + gwa + " " + "Currently Hired = " + employed + " ]";
	}


}