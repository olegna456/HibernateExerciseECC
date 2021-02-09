package com.exist.service;

import com.exist.dao.*;
import com.exist.model.*;
import java.util.*;

public class PersonService {

	private PersonDAO persondao;

	public PersonService() {

	}

	public void addPerson(Person person) {
		persondao = new PersonDAO();
		persondao.addPerson(person);
	}

	public void editPerson(Person personEdit) {
		persondao = new PersonDAO();
		persondao.edit(personEdit);

	}

	public void updatePerson(Person person) {
		persondao = new PersonDAO();
		persondao.updatePerson(person);
	}

	public List<Person> getAllPersons() {       
		persondao = new PersonDAO();
        List<Person> person = persondao.getAllPersons();
        return person;
    }

    public Person getPersonToEdit(int id) {
    	persondao = new PersonDAO();
    	Person person = persondao.getPersonToEdit(id);
    	return person;
    }

    public void deletePerson(int idToDelete) {
    	persondao = new PersonDAO();
    	Person person = persondao.getPerson(idToDelete);
    	persondao.deletePerson(person);
    }

    public Person getPerson(int id) {
    	persondao = new PersonDAO();
    	Person person = persondao.getPerson(id);
    	return person;
    }

    



}