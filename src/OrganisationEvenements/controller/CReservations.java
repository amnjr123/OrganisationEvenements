/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amine
 */
public class CReservations {

    Lists lse;
    DefaultTableModel dtmEvt;
    DefaultTableModel dtmEvtRes;

    public CReservations() {
        lse = OrganisationEvenements.getLists();
    }

    public void EvenementsParVille() {

    }

    /*
	 * public void creerEvenement(String type, String titre, String
	 * detailEvenement, String villeConcernee, Salle salle) { Evenement evt =
	 * new Evenement(type, titre, detailEvenement, villeConcernee, 0, salle);
	 * lse.getEvt().add(evt); }
	 * 
	 * public void supprimerEvenement(String type, String titre, String
	 * detailEvenement, String villeConcernee, Salle salle) { Evenement evt =
	 * new Evenement(type, titre, detailEvenement, villeConcernee, 0, salle);
	 * lse.getEvt().remove(evt); }
     */
    public Evenement rechercheEvenement(String type, String titre, String detail) {
        for (Evenement e : lse.getEvt()) {
            /*System.out.println(e.getType()+" _ "+type);
            System.out.println(e.getTitre()+" _ "+titre);
            System.out.println(e.getDetailEvenement()+" _ "+detail);*/
            if (e.getType().equalsIgnoreCase(type) && e.getTitre().equalsIgnoreCase(titre) && e.getDetailEvenement().equalsIgnoreCase(detail)) {
                System.out.print(e.getTitre());
                return e;
            }
            System.out.print("mal9a walou");
        }
        return null;
    }

    public void reserverEvenement(Evenement ev, Abonne ab) {
        if (ev.getAbonne().size() < ev.getQuota()) {
            ab.getEvenement().add(ev);
            ev.getAbonne().add(ab);
            JOptionPane.showMessageDialog(new JFrame(), "L'evenement " + ev.getTitre() + " a ete reserve avec sussces ! Yala raw3a");
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Plus de places disponibles pour cet evenement !");
        }

    }

    public void annulerReservationEvenement(Evenement ev, Abonne ab) {
        ab.getEvenement().remove(ev);
        ev.getAbonne().remove(ab);
    }

    public void reserverEvenementFromTable(JTable tSource, Abonne abonne) {
        if (tSource.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a ajouter");
        } else {
            String type = tSource.getModel().getValueAt(tSource.getSelectedRow(), 0).toString();
            String titre = tSource.getModel().getValueAt(tSource.getSelectedRow(), 1).toString();
            String detail = tSource.getModel().getValueAt(tSource.getSelectedRow(), 2).toString();
            Evenement ev = rechercheEvenement(type, titre, detail);
            if (!(ev == null)) {
                reserverEvenement(ev, abonne);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Erreur lors de la reservation");
            }
        }

    }

    public void annulerReservationFromTable(JTable tSource, Abonne abonne) {
        if (tSource.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a annuler");
        } else {
            String type = tSource.getModel().getValueAt(tSource.getSelectedRow(), 0).toString();
            String titre = tSource.getModel().getValueAt(tSource.getSelectedRow(), 1).toString();
            String detail = tSource.getModel().getValueAt(tSource.getSelectedRow(), 2).toString();
            annulerReservationEvenement(rechercheEvenement(type, titre, detail), abonne);
            JOptionPane.showMessageDialog(new JFrame(), "La reservation a l'evenement " + titre + " a ete annulee avec sussces ! Yala raw3a");
        }

    }

    public DefaultTableModel getDtmListeEvenementsVilleRegionAbonne(Abonne a) {
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
        for (Evenement e : lse.getEvt()) {
            System.out.println(a.getVille());
            if (a.getVille().equalsIgnoreCase(e.getVilleConcernee())) {
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

    public DefaultTableModel getDtmListeReservationsAbonne(Abonne a) {
        int i = 0;
        dtmEvtRes = new DefaultTableModel(lse.getEntetesEvt(), 0) {
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
            Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle, adresseSalle};
            dtmEvtRes.addRow(data);
            i++;
        }
        return dtmEvtRes;
    }
}
