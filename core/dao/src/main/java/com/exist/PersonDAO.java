package com.exist.dao;


import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.exist.model.*;
import java.util.*;
import org.hibernate.service.ServiceRegistry;

public class PersonDAO {

	private Session session;
	private Transaction currentTransaction;
	private SessionFactory sessionFactory;


	public Session openCurrentSession() {
        session = getSessionFactory().openSession();
        return session;
    }
 
    public Session openCurrentSessionWithTransaction() {
        session = getSessionFactory().openSession();
        currentTransaction = session.beginTransaction();
        return session;
    }
     
    public void closeCurrentSession() {
        session.close();
    }
     
    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        session.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addClass(Person.class).addClass(ContactInformation.class).addClass(Roles.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
 
    public Session getSession() {
        return session;
    }
 
    public void setCurrentSession(Session session) {
        this.session = session;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }



    ////////

	public void addPerson(Person person) {
		// openSessionFactory();
		// openSession();
		// transaction = session.beginTransaction();
		openCurrentSessionWithTransaction();
		getSession().save(person);
		closeCurrentSessionWithTransaction();
		// transaction.commit();
		// session.close();

	}

	public List<Person> getAllPersons() {
		openCurrentSessionWithTransaction();

		// openSessionFactory();
		// openSession();		
        List<Person> allPersons = (List<Person>) getSession().createQuery("from Person").list();
        // session.close();
        closeCurrentSessionWithTransaction();
        return allPersons;
       
    }

    public Person getPersonToEdit(int id) {
    	// openSessionFactory();
    	// openSession();
    	openCurrentSessionWithTransaction();
    	Person person = (Person) getSession().get(Person.class, id);
    	// session.close();
    	closeCurrentSessionWithTransaction();
    	return person;
    }

    public void edit(Person personEdit) {
    	
    	openCurrentSessionWithTransaction();
    	getSession().update(personEdit);
    	closeCurrentSessionWithTransaction();
    	// transaction.commit();
    	// session.close();
    }

    public Person getPerson(int idToDelete) {
        openCurrentSessionWithTransaction();
        Person person = (Person) getSession().get(Person.class, idToDelete);
        closeCurrentSessionWithTransaction();
        return person;        
    }

    public void deletePerson(Person person) {
        openCurrentSessionWithTransaction();
        getSession().delete(person);
        closeCurrentSessionWithTransaction();
    }

    public void updatePerson(Person person) {
        openCurrentSessionWithTransaction();
        getSession().update(person);
        closeCurrentSessionWithTransaction();
    }


	// from option ->
	// person service -> papasok nya  dao
	// close session dao balik option



}