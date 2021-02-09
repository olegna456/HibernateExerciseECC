package com.exist.model;

import java.util.*;
import java.io.*;
import com.exist.model.*;

public class Roles implements Serializable {

	private int roleId;
	private String role;
	private List<Person> personRole;

	public Roles() {

	}

	public Roles(String role) {
		this.role = role;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPersonRole(List<Person> personRole) {
		this.personRole = personRole;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public String getRole() {
		return this.role;
	}

	public List<Person> getPersonRole() {
		return this.personRole;
	}

	public String toString() {
		return "[Role id = "+ roleId + "\n" + "Role = " + role + "]";
	}
	
}