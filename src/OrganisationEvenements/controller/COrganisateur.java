/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amine
 */
public class COrganisateur {

    private Lists lse;
    private DefaultTableModel dtmEvt;
    private boolean modif = false;
    private Evenement evenement;

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement e) {
        this.evenement = e;
    }

    public void setModif(boolean modif) {
        this.modif = modif;
    }

    public boolean isModif() {
        return modif;
    }

    public COrganisateur() {
        lse = OrganisationEvenements.getLists();
    }

    public Evenement rechercheEvenement(String type, String titre, String detail) {
        for (Evenement e : lse.getEvt()) {
            if (e.getType().equalsIgnoreCase(type) && e.getTitre().equalsIgnoreCase(titre) && e.getDetailEvenement().equalsIgnoreCase(detail)) {
                System.out.print(e.getTitre());
                return e;
            }
        }
        return null;
    }

    public void modifEvemnement(Evenement evt, String type, String titre, String detail, String ville, int quota) {
        for (Evenement e : lse.getEvt()) {
            if (e == evt) {
                e.setType(type);
                e.setTitre(titre);
                e.setDetailEvenement(detail);
                e.setVilleConcernee(ville);
                e.setQuota(quota);
            }
        }

    }

    public DefaultTableModel getDtmListeEvenementsOrgValide(Organisateur o) {
        dtmEvt = new DefaultTableModel(lse.getEntetesEvt(), 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        for (Evenement e : lse.getEvt()) {
            if (e.getOrganisateur() == o && e.getValidation().equalsIgnoreCase("accepte")) {
                String type = e.getType();
                String titre = e.getTitre();
                String detailEvenement = e.getDetailEvenement();
                String ville = e.getVilleConcernee();
                int quota = e.getQuota();
                String validation = e.getValidation();
                String nomSalle;
                String villeSalle;
                String adresseSalle;
                try {
                    nomSalle = e.getSalle().getNom();
                    villeSalle = e.getSalle().getVille();
                    adresseSalle = e.getSalle().getAdresse();
                } catch (Exception e1) {
                    nomSalle = "Aucune salle n'est affectee";
                    villeSalle = "";
                    adresseSalle = "";
                }
                Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                    adresseSalle};
                dtmEvt.addRow(data);
            }
        }
        return dtmEvt;
    }

    public DefaultTableModel getDtmListeEvenementsOrgEncours(Organisateur o) {
        dtmEvt = new DefaultTableModel(lse.getEntetesEvt(), 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        for (Evenement e : lse.getEvt()) {
            if (e.getOrganisateur() == o && e.getValidation().equalsIgnoreCase("En cours")) {
                String type = e.getType();
                String titre = e.getTitre();
                String detailEvenement = e.getDetailEvenement();
                String ville = e.getVilleConcernee();
                int quota = e.getQuota();
                String validation = e.getValidation();
                String nomSalle;
                String villeSalle;
                String adresseSalle;
                try {
                    nomSalle = e.getSalle().getNom();
                    villeSalle = e.getSalle().getVille();
                    adresseSalle = e.getSalle().getAdresse();
                } catch (Exception e1) {
                    nomSalle = "Aucune salle n'est affectee";
                    villeSalle = "";
                    adresseSalle = "";
                }
                Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                    adresseSalle};
                dtmEvt.addRow(data);
            }
        }
        return dtmEvt;
    }

    public void sauvegardeEvenement(Evenement e) {
        if (!modif) {
            lse.getEvt().add(e);
        } else {

        }
    }
    
    public void supprimerEvernement(Evenement e){
        lse.getEvt().remove(e);
    }
}
