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
    DefaultTableModel dtmEvt;

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

    public DefaultTableModel getDtmListeEvenementsVilleRegionAbonne(Abonne a) {
        int i = 0;
        dtmEvt = new DefaultTableModel(lse.getEntetesEvt(), 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        String villeAbonne = a.getVille();
        String regionAbonne = a.getRegion();
        while (i < a.getEvenement().size()) {
            if (villeAbonne.equalsIgnoreCase(a.getEvenement().get(i).getVilleConcernee())) {

                String type = a.getEvenement().get(i).getType();
                String titre = a.getEvenement().get(i).getTitre();
                String detailEvenement = a.getEvenement().get(i).getDetailEvenement();
                String ville = a.getEvenement().get(i).getVilleConcernee();
                int quota = a.getEvenement().get(i).getQuota();
                String validation = a.getEvenement().get(i).getValidation();
                String nomSalle;
                String villeSalle;
                String adresseSalle;
                try {
                    nomSalle = a.getEvenement().get(i).getSalle().getNom();
                    villeSalle = a.getEvenement().get(i).getSalle().getVille();
                    adresseSalle = a.getEvenement().get(i).getSalle().getAdresse();
                } catch (Exception e) {
                    nomSalle = "Aucune salle n'est affectee";
                    villeSalle = "";
                    adresseSalle = "";
                }
                Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                    adresseSalle};
                dtmEvt.addRow(data);
            }
            i++;
        }
        return null;
    }

    public DefaultTableModel getDtmListeReservationsAbonne(Abonne a) {
        int i = 0;
        dtmEvt = new DefaultTableModel(lse.getEntetesEvt(), 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };

        while (i < a.getEvenement().size()) {
            String type = a.getEvenement().get(i).getType();
            String titre = a.getEvenement().get(i).getTitre();
            String detailEvenement = a.getEvenement().get(i).getDetailEvenement();
            String ville = a.getEvenement().get(i).getVilleConcernee();
            int quota = a.getEvenement().get(i).getQuota();
            String validation = a.getEvenement().get(i).getValidation();
            String nomSalle;
            String villeSalle;
            String adresseSalle;
            try {
                nomSalle = a.getEvenement().get(i).getSalle().getNom();
                villeSalle = a.getEvenement().get(i).getSalle().getVille();
                adresseSalle = a.getEvenement().get(i).getSalle().getAdresse();
            } catch (Exception e) {
                nomSalle = "Aucune salle n'est affectee";
                villeSalle = "";
                adresseSalle = "";
            }
            Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                adresseSalle};
            dtmEvt.addRow(data);
            i++;
        }

        return dtmEvt;
    }

}
