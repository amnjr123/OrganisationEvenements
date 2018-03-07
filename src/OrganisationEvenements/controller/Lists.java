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

public void remplirListEvtTest() {
    	Salle salle2 = new Salle("9ism ra9m 6", "Casa", "Dar lbaydae lkoubra", "l7ay", 8);
        
    	Salle salle3 = new Salle("9ism ra9m 7", "Casa", "Dar lbaydae lkoubra", "l7ay", 8);
        
    	Salle salle1 = new Salle("9ism ra9m 8", "Casa", "Dar lbaydae lkoubra", "l7ay", 8);
        salleList.add(salle1) ; salleList.add(salle2);salleList.add(salle3);

        abonneList.add(new Abonne("BOUDYACH", "Anas", "1", "1", "0614845937", "anas.boudyach@gmail.com",
                "87 cours gambetta", "Aglou"));
        abonneList.add(new Abonne("BOUDYACH1", "Anas1", "2", "2", "0614845937", "anas.boudyach@gmail.com",
                "87 cours gambetta", "Aglou"));
        abonneList.add(new Abonne("BOUDYACH2", "Anas2", "3", "3", "0614845937", "anas.boudyach@gmail.com",
                "87 cours gambetta", "Aglou"));
        evt.add(new Evenement("cont", "yarebbinkouneghikanhle", "detail1", "Aglou", 2));
        evt.add(new Evenement("cont1", "Swing", "detail2", "Asfi", 10));
        evt.add(new Evenement("cont2", "yarebbinkouneghikanhle2", "detail3", "rabat", 10));
        evt.add(new Evenement("cont3", "yarebbinkouneghikanhle3", "detail4", "lyon", 101));
        evt.add(new Evenement("cont4", "yarebbinkouneghikanhle4", "detail5", "khemisset", 10));
        organisateurList.add(new Organisateur("Monsieur","Bouzix","1","1","845665","bouzix@gmail.com"));

        gestionnaireOrganismeList.add(new GestionnaireOrganisme("BOUDYACH", "Anas", "1", "1"));

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
