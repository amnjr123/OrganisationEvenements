<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;
=======
package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
>>>>>>> 56a510f0bc0466184ad793401793c2c0670567d5
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amine
 */
<<<<<<< HEAD
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
=======

public class COrganisateur {

	Lists lse;
	DefaultTableModel dtmEvt;
	DefaultTableModel dtmEvtCree;

	public COrganisateur() {
		lse = OrganisationEvenements.getLists();
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
			/*
			 * System.out.println(e.getType()+" _ "+type);
			 * System.out.println(e.getTitre()+" _ "+titre);
			 * System.out.println(e.getDetailEvenement()+" _ "+detail);
			 */
			if (e.getType().equalsIgnoreCase(type) && e.getTitre().equalsIgnoreCase(titre)
					&& e.getDetailEvenement().equalsIgnoreCase(detail)) {
				System.out.print(e.getTitre());
				return e;
			}
			System.out.print("mal9a walou");
		}
		return null;
	}

	/*
	public Reservation rechercheReservation(Evenement e, int nbPlaces, Organisateur o) {
		for (Reservation r : o.getReservation()) {
			if (r.getEvenement() == e && r.getNbPlaces() == nbPlaces) {
				return r;
			}
			System.out.print("mal9a walou");
		}
		return null;
	}
*/
	/*
	public int placesDisponibles(Evenement e) {
		int nbPlacesDispo = e.getQuota();
		for (Organisateur o : lse.getOrganisateurList()) {
			for (Reservation r : .getReservation()) {
				nbPlacesDispo = nbPlacesDispo - r.getNbPlaces();
			}
		}
		return nbPlacesDispo;
	}
*/
	

/*
	public void annulerReservationEvenement(Reservation r, Organisateur ob) {
		ab.getReservation().remove(r);
	}
*/
	/*
	public void reserverEvenementFromTable(JTable tSource, Organisateur o) {
		if (tSource.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a ajouter");
		} else {
			String type = tSource.getModel().getValueAt(tSource.getSelectedRow(), 0).toString();
			String titre = tSource.getModel().getValueAt(tSource.getSelectedRow(), 1).toString();
			String detail = tSource.getModel().getValueAt(tSource.getSelectedRow(), 2).toString();
			Evenement ev = rechercheEvenement(type, titre, detail);
			if (!(ev == null)) {
				reserverEvenement(ev, Organisateur);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Erreur lors de la reservation");
			}
		}
	}
*/
	/*
	public void annulerReservationFromTable(JTable tSource, Organisateur o) {
		if (tSource.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a annuler");
		} else {
			int nbPlaces = Integer.parseInt(tSource.getModel().getValueAt(tSource.getSelectedRow(), 0).toString());
			String type = tSource.getModel().getValueAt(tSource.getSelectedRow(), 1).toString();
			String titre = tSource.getModel().getValueAt(tSource.getSelectedRow(), 2).toString();
			String detail = tSource.getModel().getValueAt(tSource.getSelectedRow(), 3).toString();
			annulerReservationEvenement(rechercheReservation(rechercheEvenement(type, titre, detail), nbPlaces, Organisateur),
					Organisateur);
			JOptionPane.showMessageDialog(new JFrame(),
					"La reservation a l'evenement a ete annulee avec sussces ! Yala raw3a");
		}

	}
	*/

	public DefaultTableModel getDtmListeEvenementsVilleRegionOrganisateur(Organisateur o) {
		dtmEvt = new DefaultTableModel(lse.getEntetesEvt(), 0) {
			/* Non editable */
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
	//	String villeOrganisateur = o.getVille();
		//String regionOrganisateur = o.getRegion();
		for (Evenement e : lse.getEvt()) {
			// System.out.println(o.getVille());
			if (o.getVille().equalsIgnoreCase(e.getVilleConcernee())) {
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
				Object[] data = { type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
						adresseSalle };
				dtmEvt.addRow(data);
			}
		}
		return dtmEvt;
	}

	public DefaultTableModel getDtmListeCreeOrganisateur(Organisateur o) { // méthode retour liste crée par l'orga
		dtmEvtCree = new DefaultTableModel(lse.getEntetesRes(), 0) {
			/* Non editable */
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		for (Reservation r : o.getEvenement()) {
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
			Object[] data = { nbPlaces, type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
					adresseSalle };
			dtmEvtCree.addRow(data);
		}
		/*
		 * while (i < o.getEvenement().size()) { String type =
		 * o.getEvenement().get(i).getType(); String titre =
		 * o.getEvenement().get(i).getTitre(); String detailEvenement =
		 * o.getEvenement().get(i).getDetailEvenement(); String ville =
		 * o.getEvenement().get(i).getVilleConcernee(); int quota =
		 * o.getEvenement().get(i).getQuota(); String validation =
		 * o.getEvenement().get(i).getValidation(); String nomSalle; String
		 * villeSalle; String adresseSalle; try { nomSalle =
		 * o.getEvenement().get(i).getSalle().getNom(); villeSalle =
		 * o.getEvenement().get(i).getSalle().getVille(); adresseSalle =
		 * o.getEvenement().get(i).getSalle().getAdresse(); } catch (Exception
		 * e) { nomSalle = "Aucune salle n'est affectee"; villeSalle = "";
		 * adresseSalle = ""; } Object[] data = {type, titre, detailEvenement,
		 * ville, quota, validation, nomSalle, villeSalle, adresseSalle};
		 * dtmEvtCree.addRow(data); i++; }
		 */
		return dtmEvtCree;
	}
>>>>>>> 56a510f0bc0466184ad793401793c2c0670567d5
}
