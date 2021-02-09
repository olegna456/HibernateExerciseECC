package com.exist.service;

import com.exist.model.*;
import com.exist.dao.PersonDAO;
import com.exist.util.UserInputs;
import java.util.*;

public class Service {

	public static Person addPerson() {
		String message = "Enter firstname: ";
		String firstName = UserInputs.getString(message);
		message = "Enter Lastname ";
		String lastName = UserInputs.getString(message);
		message = "Enter Middlename: ";
		String middleName = UserInputs.getString(message);
		message = "Enter suffix: ";
		String suffix = UserInputs.getString(message);
		message = "Enter Title: ";
		String title = UserInputs.getString(message);
		message =  "Enter Street number: ";
		int streetNumber = UserInputs.getIntInput(message, 0, 99999);
		message = "Enter Barangay: ";
		String barangay = UserInputs.getString(message);
		message = "Enter Municipality / City: ";
		String municipalityOrCity = UserInputs.getString(message);
		message = "Enter Zipcode: ";
		int zipcode = UserInputs.getIntInput(message, 0, 9999);
		message = "Enter Birthday: ";
		String birthday = UserInputs.getString(message);
		message = "Enter Date hired: ";
		String dateHired = UserInputs.getString(message);
		message = "Enter GWA: ";
		double gwa = UserInputs.getDoubleInput(message);
		message = "Enter Currently Employed?(True or False Only): ";
		boolean employed = UserInputs.getBooleanInput(message);

		Person addPerson = new Person(lastName, firstName, middleName, suffix, title, streetNumber, barangay, municipalityOrCity, zipcode, birthday, dateHired, gwa, employed);
		return addPerson;

	}

	public static Person editPerson(Person person, int choiceToEdit) {
		String message = "";
		String input;
		int intInput;
		double doubleInput;
		int min = 0, max = 9999;
		boolean employed;
		if(choiceToEdit == 1) {
			message = "Enter new Lastname: ";
			input = UserInputs.getString(message);
			person.setLastName(input);
		} else if(choiceToEdit == 2) {
			message = "Enter new Firstname: ";
			input = UserInputs.getString(message);
			person.setFirstName(input);
		} else if(choiceToEdit == 3) {
			message = "Enter new Middlename: ";
			input = UserInputs.getString(message);
			person.setMiddleName(input);
		} else if(choiceToEdit == 4) {
			message = "Enter new suffix: ";
			input = UserInputs.getString(message);
			person.setSuffix(input);
		} else if(choiceToEdit == 5) {
			message = "Enter new title: ";
			input = UserInputs.getString(message);
			person.setTitle(input);
		} else if(choiceToEdit == 6) {
			message = "Enter new streetnumber: ";
			intInput = UserInputs.getIntInput(message, min, max);
			person.setStreetNumber(intInput);
		} else if(choiceToEdit == 7) {
			message = "Enter new barangay: ";
			input = UserInputs.getString(message);
			person.setBarangay(input);
		} else if(choiceToEdit == 8) {
			message = "Enter new municipality/city: ";
			input = UserInputs.getString(message);
			person.setMunicipalityorcity(input);
		} else if(choiceToEdit == 9) {
			message = "Enter new zipcode: ";
			intInput = UserInputs.getIntInput(message, min, max);
			person.setZipcode(intInput);
		} else if(choiceToEdit == 10) {
			message = "Enter new birthday: "; 
			input = UserInputs.getString(message);
			person.setBirthday(input);
		} else if(choiceToEdit == 11) {
			message = "Enter new date hired: ";
			input = UserInputs.getString(message);
			person.setDateHired(input);
		} else if(choiceToEdit == 12) {
			message = "Enter new gwa: ";
			doubleInput = UserInputs.getDoubleInput(message);
			person.setGwa(doubleInput);
		} else {
			message = "Enter new Currently employed: ";
			boolean newEmployed = UserInputs.getBooleanInput(message);
			person.setEmployed(newEmployed);
		}

		return person;
	}

	public static ContactInformation editContact(int choiceToEdit, ContactInformation contact) {
		// System.out.println(choiceToEdit);
		String message = "";
		String input;
		if(choiceToEdit == 1) {
			message = "Enter new landline: ";
			input = UserInputs.getString(message);
			contact.setLandline(input);
		} else if(choiceToEdit == 2) {
			message = "Enter new mobilenumber: ";
			input = UserInputs.getString(message);
			contact.setMobileNumber(input);
		} else {
			message = "Enter new email: ";
			input = UserInputs.getString(message);
			contact.setEmail(input);
		}
		// System.out.println(contact);
		return contact;
	}

	public static ContactInformation getContactDetails(List<ContactInformation> contactinformation, int contactId) {
		// System.out.println(contactinformation);
		ContactInformation contactdetails = new ContactInformation();
		for(ContactInformation contacts: contactinformation) {
			if(contacts.getContactId() == contactId) {
				contactdetails.setContactId(contactId);
				contactdetails.setLandline(contacts.getLandline());
				contactdetails.setMobileNumber(contacts.getMobileNumber());
				contactdetails.setEmail(contacts.getEmail());
				contactdetails.setPerson(contacts.getPerson());
			}
		}
		// System.out.println(contactdetails);
		return contactdetails;
	}






}
