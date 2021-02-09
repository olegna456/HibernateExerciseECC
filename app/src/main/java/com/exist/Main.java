package com.exist;
import java.util.List; 
import java.util.Date; 
import java.util.Iterator; 
import java.util.*;
import com.exist.model.*;
import com.exist.service.*;
import com.exist.util.UserInputs;
// import java.util.stream;

public class Main {
	
    static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {        
    
        // try {
        //     factory = new Configuration().configure().buildSessionFactory();
        // }catch(Throwable e) {
        //     System.err.println("Failed to create sessionFactory object." + e);
        //     //throw new ExceptionInInitializerError(e);
        // }
        
        // Main mp = new Main();
        while(true) {
            selectOption();
        }    

    }

    static void selectOption() {
        
        int choice;
        try {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(console.nextLine());
            if((choice < 0) || (choice > 14)) {
                System.out.println("Invalid input. Please select from the choices.");
            } else {
                selected(choice);
            }
        } catch(NumberFormatException e) {
            System.out.println("Invalid Input. Please enter a valid choice.");
        }      
    }

    static void selected(int choice) {
        PersonService ps = new PersonService();
        ContactInformationService cis = new ContactInformationService();
        RolesService rs = new RolesService();
        switch(choice) {
            case 0:
                System.exit(1);
                break;
            case 1:                
                ps.addPerson(Service.addPerson()); 
                break;
            case 2:
                String message = "Enter person(s) id to be deleted: ";
                int min = 1, max = 100;
                int idToDelete = UserInputs.getIntInput(message, min, max);
                try {
                    ps.deletePerson(idToDelete);
                }catch(Exception e) {

                }
                break;
            case 3:
                // UserInputs ui = new UserInputs();
                message = "Enter person's id to edit: ";
                min = 1; max = 100;
                int idToEdit = UserInputs.getIntInput(message, min, max);
                message = "Select an option to edit \n" +
                          "1. Edit Lastname \n" +
                          "2. Edit Firstname \n" +
                          "3. Edit Middlename \n" +
                          "4. Edit Suffix \n" +
                          "5. Edit title \n" +
                          "6. Edit Street Number \n" +
                          "7. Edit Barangay \n" +
                          "8. Edit Municipality/City \n" +
                          "9. Edit Zipcode \n" +
                          "10. Edit birthday \n" + 
                          "11. Edit Date Hired \n" +
                          "12. Edit GWA \n" +
                          "13. Edit Currently Emplyoed \n" +
                          "Enter your choice: ";
                max = 13;
                int choiceToEdit = UserInputs.getIntInput(message, min, max);
                try { 
                    Person personDetails = ps.getPersonToEdit(idToEdit);
                    ps.editPerson(Service.editPerson(personDetails, choiceToEdit));                    
                }catch(Exception e) {
                    System.out.println("Invalid Input. try again");
                    selected(choice);
                }
                break;
            case 4:                
                List<Person> person = new ArrayList<>();
                person = ps.getAllPersons();                
                for(Person p: person) {
                    System.out.println(p.toString());
                }
                break;
            case 5:
                message = "Enter person(s) id to add role: ";
                min = 1; max = 100;
                int personIdToAddRole = UserInputs.getIntInput(message, min, max);
                message = "Enter role id to be added to the person: ";
                int roleId = UserInputs.getIntInput(message, min, max);
                try {
                    Person personAddRole = ps.getPerson(personIdToAddRole);
                    Roles roleAddRole = rs.getRole(roleId);
                    List<Roles> role = personAddRole.getRole();
                    role.add(roleAddRole);                    
                    personAddRole.setRole(role);
                    // System.out.println(personAddRole.getRole());
                    ps.editPerson(personAddRole);
                } catch(Exception e) {

                }
                break;
            case 6:
                message = "Enter person(s) id to delete role: ";
                min = 1; max = 100;
                int personIdToDeleteRole = UserInputs.getIntInput(message, min, max);
                message = "Enter role id: ";
                roleId = UserInputs.getIntInput(message, min, max);
                try {

                }catch(Exception e) {
                    
                }
                break;
            case 7:
                message = "Enter person's id to add contact information: ";
                int personId = UserInputs.getIntInput(message, 1, 100);
                try {
                    Person addContactInfo = ps.getPersonToEdit(personId);
                    message = "Enter landline number: ";
                    String landline = UserInputs.getString(message);
                    message = "Enter mobile number: ";
                    String mobilenumber = UserInputs.getString(message);
                    message = "Enter email: ";
                    String email = UserInputs.getString(message);
                    ContactInformation addNewContact = new ContactInformation(landline, mobilenumber, email);
                    addNewContact.setPerson(addContactInfo);
                    cis.addContact(addNewContact);
 
                } catch(Exception e) {
                    System.out.println("Invalid Input. Try Again.");
                    selected(choice);
                }
                break;
            case 8:
                message = "Enter Person(s) id to edit: ";
                min = 1; max = 100;
                idToEdit = UserInputs.getIntInput(message, min, max);
                try {
                    Person personContactToEdit = ps.getPersonToEdit(idToEdit);
                    List<ContactInformation> contactinformationToEdit = personContactToEdit.getContactinformation();
                    // System.out.println(contactinformationToEdit);
                    if(contactinformationToEdit.isEmpty()) {
                        System.out.println("No contact information added.");
                    } else {
                        message = "Enter contact id to update: ";
                        int updateContactId = UserInputs.getIntInput(message, min, max);
                        message = "Select an option \n" +
                                  "1. landline \n" +
                                  "2. mobile number \n" +
                                  "3. email \n" +
                                  "Enter your choice: ";
                        choiceToEdit = UserInputs.getIntInput(message, 1, 100);
                        cis.editContact(Service.editContact(choiceToEdit, Service.getContactDetails(contactinformationToEdit, updateContactId)));
                    }
                }catch(Exception e) {

                }
                break;
            case 9:
                message = "Enter contact id to be deleted: ";
                min = 1; max = 100;
                int contactIdToDelete = UserInputs.getIntInput(message, min, max);
                try {
                    cis.deleteContact(contactIdToDelete);
                }catch(Exception e) {

                }
                break;
            case 10:
                message = "Enter role: ";
                String role = UserInputs.getString(message);
                Roles addRole = new Roles(role);
                rs.addRole(addRole);
                break;
            case 11:
                message = "Enter role id to edit: ";
                min = 1;max =100;
                int roleIdToEdit = UserInputs.getIntInput(message, min, max);
                message = "Enter role replacement: ";
                String toReplace = UserInputs.getString(message);
                try {
                    Roles updateRole = new Roles(toReplace);
                    updateRole.setRoleId(roleIdToEdit);
                    rs.updateRole(updateRole);
                } catch(Exception e) {

                }
                break;
            case 12:
                message = "Enter role to be deleted: ";
                min = 1; max = 100;
                int deleteRoleId = UserInputs.getIntInput(message, min, max);
                try {
                    rs.deleteRole(deleteRoleId);
                } catch(Exception e) {

                }

                break;
            case 13:
                List<Roles> listOfRoles = rs.getListOfRoles();
                for(Roles roles: listOfRoles) {
                    System.out.println(roles.toString());
                }
                break;
            
        }
    }

    static void showMenu() {
        System.out.println("Select an option");
        System.out.println("0. Exit Program");
        System.out.println("1. Create Person");
        System.out.println("2. Delete Person");
        System.out.println("3. Update Person");
        System.out.println("4. List Person(s)");
        System.out.println("5. Add Person Role");
        System.out.println("6. Delete Person Role");
        System.out.println("7. Add Contact Information");
        System.out.println("8. Update Contact Information");
        System.out.println("9. Delete Contact Information");
        System.out.println("10. Add Role");
        System.out.println("11. Update Role");
        System.out.println("12. Delete Role");
        System.out.println("13. List Role");         

    }	
}