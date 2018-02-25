package OrganisationEvenements.model;

import java.util.*;

public class GestionnaireOrganisme extends Personne {

	public ArrayList<Evenement> evenement;
	public ArrayList<Salle> salle;

	public GestionnaireOrganisme(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);
	}

	public GestionnaireOrganisme() {
		super("", "", "", "");
	}

	public ArrayList<Evenement> getEvenement() {
		if (evenement == null)
			evenement = new ArrayList<Evenement>();
		return evenement;
	}

	public Iterator<Evenement> getIteratorEvenement() {
		if (evenement == null)
			evenement = new ArrayList<Evenement>();
		return evenement.iterator();
	}

	public void setEvenement(ArrayList<Evenement> newEvenement) {
		removeAllEvenement();
		for (Iterator<Evenement> iter = newEvenement.iterator(); iter.hasNext();)
			addEvenement((Evenement) iter.next());
	}

	public void addEvenement(Evenement newEvenement) {
		if (newEvenement == null)
			return;
		if (this.evenement == null)
			this.evenement = new ArrayList<Evenement>();
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

	public ArrayList<Salle> getSalle() {
		if (salle == null)
			salle = new ArrayList<Salle>();
		return salle;
	}

	public Iterator<Salle> getIteratorSalle() {
		if (salle == null)
			salle = new ArrayList<Salle>();
		return salle.iterator();
	}

	public void setSalle(ArrayList<Salle> newSalle) {
		removeAllSalle();
		for (Iterator<Salle> iter = newSalle.iterator(); iter.hasNext();)
			addSalle((Salle) iter.next());
	}

	public void addSalle(Salle newSalle) {
		if (newSalle == null)
			return;
		if (this.salle == null)
			this.salle = new ArrayList<Salle>();
		if (!this.salle.contains(newSalle))
			this.salle.add(newSalle);
	}

	public void removeSalle(Salle oldSalle) {
		if (oldSalle == null)
			return;
		if (this.salle != null)
			if (this.salle.contains(oldSalle))
				this.salle.remove(oldSalle);
	}

	public void removeAllSalle() {
		if (salle != null)
			salle.clear();
	}

}