package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.backpackage.person.DBUsersManager;
import fr.isika.cda26.project1.groupe4.backpackage.person.User;

public class AdminAccountLogin implements BackConstants {

	// ******************ATTRIBUTES******************
	List<User> employees;
	List<Intern> internsList;

	// ******************CONSTRUCTOR******************
	public AdminAccountLogin() {
		super();
		InternsDirectoryTree idt = new InternsDirectoryTree();
		DBUsersManager dum = new DBUsersManager();
		this.employees = new ArrayList<User>();
		dum.getAllUsersInDB(employees);
		for (User user : employees) {
		System.out.println(user);
		}
		this.internsList = new ArrayList<Intern>();
		idt.getAllInternInDB(internsList, START_VALUE);
		for (Intern intern : internsList) {
		System.out.println(intern);
		}
	}

	// ******************METHODE PUBLIC******************
	/**
	 * Check Id with compare To Override method.
	 * 
	 * @param name     (:String)
	 * @param forename (:String)
	 * @param password (:String)
	 * @return (:String)
	 */
	public String checkId(String name, String forename, String password) {
		User userToTest = new User(name, forename, password);
		for (User employee : employees) {
			if (employee.compareFormTo(userToTest) == 0) {
				System.out.println(employee.getSTATUS());
				return employee.getSTATUS();
			}
		}
		return EMPTY_STATUS;
	}
}