package fr.isika.cda26.grp4.projetAnnuaire;

import java.util.ArrayList;

public class InternDirectory {

	public ArrayList<Intern> isikaInterns;
	public String organizationName;
	
	public InternDirectory (String organizationName) {
		this.isikaInterns = new ArrayList<Intern>();
		this.organizationName = organizationName;
	}
}
