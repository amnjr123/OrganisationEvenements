
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

    public Reservation rechercheReservation(Evenement e, int nbPlaces, Abonne a) {
        for (Reservation r : a.getReservation()) {
            if (r.getEvenement() == e && r.getNbPlaces() == nbPlaces) {
                return r;
            }
            System.out.print("mal9a walou");
        }
        return null;
    }

    public int placesDisponibles(Evenement e) {
        int nbPlacesDispo = e.getQuota();
        for (Abonne a : lse.getAbonneList()) {
            for (Reservation r : a.getReservation()) {
                nbPlacesDispo = nbPlacesDispo - r.getNbPlaces();
            }
        }
        return nbPlacesDispo;
    }

    public void reserverEvenement(Evenement ev, Abonne ab) {
        int nbPlacesDispo = placesDisponibles(ev);
        try {
            int nbPlaces = Integer.parseInt(JOptionPane.showInputDialog("Veuillez préciser le nombre de places a reserver :"));
            if (nbPlacesDispo >= nbPlaces) {
                if (nbPlaces > 0) {
                    ab.getReservation().add(new Reservation(ev, nbPlaces));
                    if (nbPlaces == 1) {
                        JOptionPane.showMessageDialog(new JFrame(), "Une place a ete reservee avec sussces pour l'evenement " + ev.getTitre() + " ! Yala raw3a");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), nbPlaces + " places ont ete reservees avec sussces pour l'evenement " + ev.getTitre() + " ! Yala raw3a");
                    }

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Le nombre de places doit etre superieur a 0");
                }
            } else {
                if (nbPlacesDispo == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Cet évenement est complet !");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Plus que " + nbPlacesDispo + " places disponibles pour cet evenement !");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Kteb lia chi haja SAHIHA !");
        }

    }

    public void annulerReservationEvenement(Reservation r, Abonne ab) {
        ab.getReservation().remove(r);
    }

    public void reserverEvenementFromTable(JTable tSource, Abonne abonne) {
        if (tSource.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a ajouter");
        } else {
            String type = tSource.getModel().getValueAt(tSource.getSelectedRow(), 0).toString();
            String titre = tSource.getModel().getValueAt(tSource.getSelectedRow(), 1).toString();
            String detail = tSource.getModel().getValueAt(tSource.getSelectedRow(), 2).toString();
            Evenement ev = rechercheEvenement(type, titre, detail);
            if (!(ev == null) && ev.getValidation().equalsIgnoreCase("accepte")) {
                reserverEvenement(ev, abonne);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "L'evenement n'est pas encore valide par l'organisme, veuillez reessayer plustard");
            }
        }
    }

    public void annulerReservationFromTable(JTable tSource, Abonne abonne) {
        if (tSource.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a annuler");
        } else {
            int nbPlaces = Integer.parseInt(tSource.getModel().getValueAt(tSource.getSelectedRow(), 0).toString());
            String type = tSource.getModel().getValueAt(tSource.getSelectedRow(), 1).toString();
            String titre = tSource.getModel().getValueAt(tSource.getSelectedRow(), 2).toString();
            String detail = tSource.getModel().getValueAt(tSource.getSelectedRow(), 3).toString();
            annulerReservationEvenement(rechercheReservation(rechercheEvenement(type, titre, detail), nbPlaces, abonne), abonne);
            JOptionPane.showMessageDialog(new JFrame(), "La reservation a l'evenement a ete annulee avec sussces ! Yala raw3a");
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
            //System.out.println(a.getVille());
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
        dtmEvtRes = new DefaultTableModel(lse.getEntetesRes(), 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };

        for (Reservation r : a.getReservation()) {
            int nbPlaces = r.getNbPlaces();
            String type = r.getEvenement().getType();
            System.out.println(nbPlaces + " places evt" + type);
            String titre = r.getEvenement().getTitre();
            String detailEvenement = r.getEvenement().getDetailEvenement();
            String ville = r.getEvenement().getVilleConcernee();
            int quota = r.getEvenement().getQuota();
            String validation = r.getEvenement().getValidation();
            String nomSalle;
            String villeSalle;
            String adresseSalle;
            try {
                nomSalle = r.getEvenement().getSalle().getNom();
                villeSalle = r.getEvenement().getSalle().getVille();
                adresseSalle = r.getEvenement().getSalle().getAdresse();
            } catch (Exception e1) {
                nomSalle = "Aucune salle n'est affectee";
                villeSalle = "";
                adresseSalle = "";
            }
            Object[] data = {nbPlaces, type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                adresseSalle};
            dtmEvtRes.addRow(data);
        }
        /*
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
        }*/
        return dtmEvtRes;
    }
}
