package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;

import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;

public class InternDirectory {

	public ArrayList<Intern> isikaInterns;
	public String organizationName;
	
	public InternDirectory (String organizationName) {
		this.isikaInterns = new ArrayList<Intern>();
		this.organizationName = organizationName;
	}
}
