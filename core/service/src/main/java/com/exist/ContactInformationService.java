package com.exist.service;

import java.util.*;
import com.exist.dao.*;
import com.exist.model.*;

public class ContactInformationService {

	private ContactInformationDAO contactinformationdao;
	
	public ContactInformationService() {

	}

	public void addContact(ContactInformation contact) {
		contactinformationdao = new ContactInformationDAO();
		contactinformationdao.addContact(contact);
	}

	public void editContact(ContactInformation contactEdit) {
		// System.out.println(contact);
		contactinformationdao = new ContactInformationDAO();
		contactinformationdao.updateContact(contactEdit);
		
	}

	public void deleteContact(int contactIdToDelete) {
		contactinformationdao = new ContactInformationDAO();
		ContactInformation contactToDelete = contactinformationdao.getContact(contactIdToDelete);
		contactinformationdao.deleteContact(contactToDelete);
	}


}