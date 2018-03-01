/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amine
 */
public class CReservations {

    Lists lse;

    public CReservations() {
        lse = new Lists();
    }

    public void EvenementsParVille() {

    }

    /*public void creerEvenement(String type, String titre, String detailEvenement, String villeConcernee, Salle salle) {
        Evenement evt = new Evenement(type, titre, detailEvenement, villeConcernee, 0, salle);
        lse.getEvt().add(evt);
    }

    public void supprimerEvenement(String type, String titre, String detailEvenement, String villeConcernee, Salle salle) {
        Evenement evt = new Evenement(type, titre, detailEvenement, villeConcernee, 0, salle);
        lse.getEvt().remove(evt);
    }*/
    public void reserverEvenement(Evenement ev, Abonne ab) {
        ab.getEvenement().add(ev);
    }

    public void annulerReservationEvenement(Evenement ev, Abonne ab) {
        ab.getEvenement().remove(ev);
    }
    
    public DefaultTableModel getDtmListeReservations(Abonne a){

        for (int i : a.getEvenement()){
            System.out.println(alEvt.get(i).toString());
        }

        return null;
    }

}
