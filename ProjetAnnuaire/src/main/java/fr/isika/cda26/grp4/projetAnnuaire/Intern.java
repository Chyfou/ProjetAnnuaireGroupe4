package fr.isika.cda26.grp4.projetAnnuaire;

public class Intern {
	
	//****************Attributs*************
	//A retirer, héritage de la classe Person.
	private String name;
	private String forename;
	//Fin à retirer
	private String location;
	private String promotion;
	private String year;
	
	//****************Constructor*************
	public Intern (String name, String forename, String location, String promotion, String year) {
		this.name = name;
		this.forename = forename;
		this.location = location;
		this.promotion = promotion;
		this.year = year;
	}

	//****************Getters & Setters*************
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getForename() {
		return forename;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
