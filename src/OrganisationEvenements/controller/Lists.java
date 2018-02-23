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
        abonneList = new ArrayList<Abonne>();
        organisateurList = new ArrayList<Organisateur>();
        gestionnaireOrganismeList = new ArrayList<GestionnaireOrganisme>();
        salleList = new ArrayList<Salle>();
        evt = new ArrayList<Evenement>();
    }

    public void remplirListEvtTest() {
        Salle salle1 = new Salle("9ism ra9m 8", "Casa", "Dar lbaydae lkoubra", "l7ay", 8);
        
        evt.add(new Evenement("cont", "yarebbinkouneghikanhle", "detail1", "Aglou", 10, salle1));
        evt.add(new Evenement("cont1", "Swing", "detail2", "Asfi", 10, salle1));
        evt.add(new Evenement("cont2", "yarebbinkouneghikanhle2", "detail3", "rabat", 10, salle1));
        evt.add(new Evenement("cont3", "yarebbinkouneghikanhle3", "detail4", "lyon", 10, salle1));
        evt.add(new Evenement("cont4", "yarebbinkouneghikanhle4", "detail5", "khemisset", 10));
        
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
