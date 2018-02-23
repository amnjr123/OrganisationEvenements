package OrganisationEvenements.model;
import java.util.*;

public class Abonne extends Personne {
	private String tel;
	private String email;
	private String adresse;
	public Collection<Evenement> evenement;

	public Abonne(){
		super("","","","");
		this.tel = "";
		this.email = "";
		this.adresse = "";
	}
	public Abonne(String nom, String prenom, String login, String mdp, String tel, String email, String adresse) {
		super(nom, prenom, login, mdp);
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
	}

	public String toString() {
		return super.toString() + "\nAdresse :" + adresse + "\ntel :" + tel + "\nEmail :" + email;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Collection<Evenement> getEvenement() {
		if (evenement == null)
			evenement = new java.util.HashSet<Evenement>();
		return evenement;
	}

	public Iterator<Evenement> getIteratorEvenement() {
		if (evenement == null)
			evenement = new java.util.HashSet<Evenement>();
		return evenement.iterator();
	}

	public void setEvenement(Collection<Evenement> newEvenement) {
		removeAllEvenement();
		for (Iterator<Evenement> iter = newEvenement.iterator(); iter.hasNext();)
			addEvenement((Evenement) iter.next());
	}

	public void addEvenement(Evenement newEvenement) {
		if (newEvenement == null)
			return;
		if (this.evenement == null)
			this.evenement = new HashSet<Evenement>();
		if (!this.evenement.contains(newEvenement))
			this.evenement.add(newEvenement);
	}

	public void removeEvenement(Evenement oldEvenement) {
		if (oldEvenement == null)
			return;
		if (this.evenement != null)
			if (this.evenement.contains(oldEvenement))
				this.evenement.remove(oldEvenement);
	}

	public void removeAllEvenement() {
		if (evenement != null)
			evenement.clear();
	}
}