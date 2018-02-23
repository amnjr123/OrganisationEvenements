package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;

import java.util.ArrayList;
import java.util.Collection;

public class Lists {
	public Collection<Abonne> abonneList;
	public Collection<Organisateur> organisateurList;
	public Collection<GestionnaireOrganisme> gestionnaireOrganismeList;
	
	public Collection<Salle> salleList;
    public Collection<Evenement> evt;

	public Lists() {
		abonneList= new ArrayList<Abonne>();
		organisateurList = new ArrayList<Organisateur>();
		gestionnaireOrganismeList= new ArrayList<GestionnaireOrganisme>();
		salleList= new ArrayList<Salle>();
		evt	= new ArrayList<Evenement>();
	}

	public Collection<Abonne> getAbonneList() {
		return abonneList;
	}

	public Collection<Organisateur> getOrganisateurList() {
		return organisateurList;
	}

	public Collection<GestionnaireOrganisme> getGestionnaireOrganismeList() {
		return gestionnaireOrganismeList;
	}

	public Collection<Salle> getSalleList() {
		return salleList;
	}

	public Collection<Evenement> getEvt() {
		return evt;
	}
	
	
}
