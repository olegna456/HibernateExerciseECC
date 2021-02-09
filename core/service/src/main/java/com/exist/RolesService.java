package com.exist.service;

import java.util.*;
import com.exist.model.*;
import com.exist.dao.*;

public class RolesService {

	private RolesDAO rolesdao;

	public RolesService() {

	}

	public void addRole(Roles role) {
		rolesdao = new RolesDAO();
		rolesdao.addRole(role);
	}

	public void updateRole(Roles role) {
		rolesdao = new RolesDAO();
		rolesdao.updateRole(role);
	}

	public List<Roles> getListOfRoles() {
		rolesdao = new RolesDAO();
		List<Roles> roles = rolesdao.getListOfRoles();
		return roles;
	}

	public void deleteRole(int roleIdToDelete) {
		rolesdao = new RolesDAO();
		Roles role = rolesdao.getRole(roleIdToDelete);
		rolesdao.deleteRole(role);
	}

	public Roles getRole(int roleId) {
		rolesdao = new RolesDAO();
		Roles role = rolesdao.getRole(roleId);
		return role;
	}


}