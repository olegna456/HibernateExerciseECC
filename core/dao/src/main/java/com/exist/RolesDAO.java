package com.exist.dao;

import org.hibernate.Session; 
import org.hibernate.Transaction; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.exist.model.*;
import java.util.*;
import org.hibernate.service.ServiceRegistry;

public class RolesDAO {

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

    public void addRole(Roles role) {
    	openCurrentSessionWithTransaction();
		getSession().save(role);
		closeCurrentSessionWithTransaction();
    }

    public void updateRole(Roles role) {
        openCurrentSessionWithTransaction();
        getSession().update(role);
        closeCurrentSessionWithTransaction();
    }

    public List<Roles> getListOfRoles() {
        openCurrentSessionWithTransaction();
        List<Roles> roles = (List<Roles>) getSession().createQuery("from Roles").list();
        closeCurrentSessionWithTransaction();
        return roles;
    }

    public Roles getRole(int idRoleToDelete) {
        openCurrentSessionWithTransaction();
        Roles role = (Roles) getSession().get(Roles.class, idRoleToDelete);
        closeCurrentSessionWithTransaction();
        return role;
    }

    public void deleteRole(Roles role) {
        openCurrentSessionWithTransaction();
        getSession().delete(role);
        closeCurrentSessionWithTransaction();
    }

}