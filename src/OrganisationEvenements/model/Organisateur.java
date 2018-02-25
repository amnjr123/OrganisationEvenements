package OrganisationEvenements.model;

import java.util.ArrayList;

public class Organisateur extends Personne {

	private String adresse;
	private String tel;
	private String email;
	public ArrayList<Evenement> evenement;

	public Organisateur() {
		super("", "", "", "");
		this.tel = "";
		this.email = "";
		evenement = new ArrayList<Evenement>();

	}

	public Organisateur(String nom, String prenom, String login, String mdp, String tel, String email) {
		super(nom, prenom, login, mdp);
		this.tel = tel;
		this.email = email;
	}

	public String toString() {
		return super.toString() + "\nAdresse :" + adresse + "\ntel :" + tel + "\nEmail :" + email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Evenement> getEvenement() {
		return evenement;
	}

}