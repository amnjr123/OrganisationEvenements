package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;

import java.util.ArrayList;

public class Lists {

    private ArrayList<Abonne> abonneList;
    private ArrayList<Organisateur> organisateurList;
    private ArrayList<GestionnaireOrganisme> gestionnaireOrganismeList;
    private ArrayList<Salle> salleList;
    private ArrayList<Evenement> evt;
    private String[] entetesEvt = {"Type", "Titre", "Detail evenement", "Ville Concernee", "quota", "Validation", "Salle",
        "Ville de la salle", "Adresse de la salle"};
    private String[] entetesRes = {"Nombre de places", "Type", "Titre", "Detail evenement", "Ville Concernee", "quota", "Validation", "Salle",
        "Ville de la salle", "Adresse de la salle"};

    public String[] getEntetesRes() {
        return entetesRes;
    }

    public String[] getEntetesEvt() {
        return entetesEvt;
    }

    public Lists() {
        abonneList = new ArrayList<Abonne>();
        organisateurList = new ArrayList<Organisateur>();
        gestionnaireOrganismeList = new ArrayList<GestionnaireOrganisme>();
        salleList = new ArrayList<Salle>();
        evt = new ArrayList<Evenement>();
    }
    
    public GestionnaireOrganisme getGestionnaireOrganisme(String login) {
    	GestionnaireOrganisme a = new GestionnaireOrganisme();
        for (GestionnaireOrganisme ab : getGestionnaireOrganismeList()) {
            if (ab.getLogin() == login) {
                a = ab;
            }
        }
        return a;
    }
    public Abonne getAbonne(String login) {
        Abonne a = new Abonne();
        for (Abonne ab : abonneList) {
            if (ab.getLogin() == login) {
                a = ab;
            }
        }
        return a;
    }

    public Organisateur getOrganisateur(String login) {
        Organisateur o = new Organisateur();
        for (Organisateur org : organisateurList) {
            if (org.getLogin() == login) {
                o = org;
            }
        }
        return o;
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
