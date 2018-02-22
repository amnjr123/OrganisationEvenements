package OrganisationEvenements.model;

import java.util.*;

public class Salle {
	private String nom;
	private String ville;
	private String region;
	private String adresse;
	private int nbPlaces;
	public Collection<Evenement> evenement;
	public GestionnaireOrganisme gestionnaireOrganisme;

	
	
	public Salle(String nom, String ville, String region, String adresse, int nbPlaces) {
		this.nom = nom;
		this.ville = ville;
		this.region = region;
		this.adresse = adresse;
		this.nbPlaces = nbPlaces;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public GestionnaireOrganisme getGestionnaireOrganisme() {
		return gestionnaireOrganisme;
	}

	public void setGestionnaireOrganisme(GestionnaireOrganisme gestionnaireOrganisme) {
		this.gestionnaireOrganisme = gestionnaireOrganisme;
	}

	public String toString() {
		return super.toString();
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
			this.evenement = new java.util.HashSet<Evenement>();
		if (!this.evenement.contains(newEvenement)) {
			this.evenement.add(newEvenement);
			newEvenement.setSalle(this);
		}
	}

	public void removeEvenement(Evenement oldEvenement) {
		if (oldEvenement == null)
			return;
		if (this.evenement != null)
			if (this.evenement.contains(oldEvenement)) {
				this.evenement.remove(oldEvenement);
				oldEvenement.setSalle((Salle) null);
			}
	}

	public void removeAllEvenement() {
		if (evenement != null) {
			Evenement oldEvenement;
			for (Iterator<Evenement> iter = getIteratorEvenement(); iter.hasNext();) {
				oldEvenement = (Evenement) iter.next();
				iter.remove();
				oldEvenement.setSalle((Salle) null);
			}
		}
	}
}