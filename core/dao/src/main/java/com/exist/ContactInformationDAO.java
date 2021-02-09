package com.exist.dao;


import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import com.exist.model.*;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.exist.model.*;
import java.util.*;
import org.hibernate.service.ServiceRegistry;
public class ContactInformationDAO {

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
 
    public Session getCurrentSession() {
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


	public void addContact(ContactInformation contact) {
		// openSessionFactory();
		// openSession();
		// transaction = session.beginTransaction();
		// session.save(contact);
		// transaction.commit();
		// session.close();
		openCurrentSessionWithTransaction();
		getCurrentSession().save(contact);
		closeCurrentSessionWithTransaction();
	}

    public void updateContact(ContactInformation contactEdit) {
        // System.out.println(contact);
        openCurrentSessionWithTransaction();
        getCurrentSession().update(contactEdit);
        closeCurrentSessionWithTransaction();
    }

    public ContactInformation getContact(int contactIdToDelete) {
        openCurrentSessionWithTransaction();
        ContactInformation ci = (ContactInformation) getCurrentSession().get(ContactInformation.class, contactIdToDelete);
        closeCurrentSessionWithTransaction();
        return ci;
    }

    public void deleteContact(ContactInformation contact) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(contact);
        closeCurrentSessionWithTransaction();
    }

}