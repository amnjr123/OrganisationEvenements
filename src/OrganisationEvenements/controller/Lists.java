package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;

import java.util.ArrayList;
import java.util.ArrayList;

public class Lists {
	public ArrayList<Abonne> abonneList;
	public ArrayList<Organisateur> organisateurList;
	public ArrayList<GestionnaireOrganisme> gestionnaireOrganismeList;
	
	public ArrayList<Salle> salleList;
    public ArrayList<Evenement> evt;

	public Lists() {
		abonneList= new ArrayList<Abonne>();
		organisateurList = new ArrayList<Organisateur>();
		gestionnaireOrganismeList= new ArrayList<GestionnaireOrganisme>();
		salleList= new ArrayList<Salle>();
		evt	= new ArrayList<Evenement>();
	}

	public ArrayList<Abonne> getAbonneList() {
		return abonneList;
	}

	public ArrayList<Organisateur> getOrganisateurList() {
		return organisateurList;
	}

	public ArrayList<GestionnaireOrganisme> getGestionnaireOrganismeList() {
		return gestionnaireOrganismeList;
	}

	public ArrayList<Salle> getSalleList() {
		return salleList;
	}

	public ArrayList<Evenement> getEvt() {
		return evt;
	}
	
	
}
