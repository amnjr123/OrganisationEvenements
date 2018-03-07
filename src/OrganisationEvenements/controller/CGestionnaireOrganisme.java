package OrganisationEvenements.controller;

import OrganisationEvenements.model.*;
import OrganisationEvenements.view.InterfaceAbonne;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CGestionnaireOrganisme {

	/*
	 * To change this license header, choose License Headers in Project
	 * Properties. To change this template file, choose Tools | Templates and
	 * open the template in the editor.
	 */

	private Lists lse;
	private DefaultTableModel dtmEvt;
	private DefaultTableModel dtmSalle;
	private String[] entetesEvt = { "Type", "Titre", "Detail evenement", "Ville Concernee", "quota", "Validation",
			"Salle", "Ville de la salle", "Adresse de la salle" };
	private String[] entetesSalle = { "Nom", "Ville", "Region", "Adresse", "nb Places" };
	private JFrame frame = new JFrame("CrÈer salle");

	public CGestionnaireOrganisme() {
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
	public Salle rechercheSalle(String nom) {
		for (Salle s : lse.getSalleList()) {
			if (s.getNom().equalsIgnoreCase(nom)) {
				System.out.print(s.getNom());
				return s;
			}
		}
		return null;
	}

	public Lists getList() {
		return lse;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Evenement rechercheEvenement(String type, String titre, String detail) {
		for (Evenement e : lse.getEvt()) {
			if (e.getType().equalsIgnoreCase(type) && e.getTitre().equalsIgnoreCase(titre)
					&& e.getDetailEvenement().equalsIgnoreCase(detail)) {
				return e;
			}
		}
		return null;
	}

	public void accouplerSalleEvenement(JTable tSourceEvt, JTable tSourceSalle, GestionnaireOrganisme gO) {
		if (tSourceEvt.getSelectionModel().isSelectionEmpty())
			JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a affecte");
		else {
			if (tSourceSalle.getSelectionModel().isSelectionEmpty())
				JOptionPane.showMessageDialog(new JFrame(), "Selectionnez une salle a affecte");
			else {
				String type = tSourceEvt.getModel().getValueAt(tSourceEvt.getSelectedRow(), 0).toString();
				String titre = tSourceEvt.getModel().getValueAt(tSourceEvt.getSelectedRow(), 1).toString();
				String detail = tSourceEvt.getModel().getValueAt(tSourceEvt.getSelectedRow(), 2).toString();
				Evenement ev = rechercheEvenement(type, titre, detail);
				String nomS = tSourceSalle.getModel().getValueAt(tSourceSalle.getSelectedRow(), 0).toString();
				Salle salle = rechercheSalle(nomS); // nakhdo men table
				if (!(ev == null || salle == null)) {
					accoupler(ev, gO, salle);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Erreur lors de la validation");
				}
			}
		}
	}

	public void accoupler(Evenement e, GestionnaireOrganisme gO, Salle s) {
		boolean libre = true;
		if (e.getValidation().equalsIgnoreCase("en cours") || e.getValidation().equalsIgnoreCase("complet")) {
			for (Evenement evt : lse.getEvt()) {
				if (evt.getSalle() == s && evt != e) {
					libre = false;
				}
			}
		}
		if (libre) {
			e.setGestionnaireOrganisme(gO);
			e.setSalle(s);
			e.setValidation("accepte");
			JOptionPane.showMessageDialog(new JFrame(), "Salle affecte, Evenement accepte");
		} else
			JOptionPane.showMessageDialog(new JFrame(), "Erreur salle deja affecte !");

	}

	public DefaultTableModel remplirTableSalle() {
		/* Bach maykonch tikrar f la table une fois revenu l accueil */
		/*if (lse.getEvt().isEmpty()) {
			lse.remplirListEvtTest();
		}*/

		dtmSalle = new DefaultTableModel(entetesSalle, 0) {
			/* Non editable */
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		for (int i = 0; i < lse.getSalleList().size(); i++) {
			String nomSalle = lse.getSalleList().get(i).getNom();
			String villeSalle = lse.getSalleList().get(i).getVille();
			String regionSalle = lse.getSalleList().get(i).getRegion();
			String adresseSalle = lse.getSalleList().get(i).getAdresse();
			int quota = lse.getSalleList().get(i).getNbPlaces();

			Object[] data = { nomSalle, villeSalle, regionSalle, adresseSalle, quota };
			dtmSalle.addRow(data);
		}

		return dtmSalle;
	}

	public DefaultTableModel remplirTableEvenement() {
		/* Bach maykonch tikrar f la table une fois revenu l accueil */
		/*if (OrganisationEvenements.getLists().getEvt().isEmpty())
			OrganisationEvenements.getLists().remplirListEvtTest();*/

		dtmEvt = new DefaultTableModel(entetesEvt, 0) {
			/* Non editable */
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		for (int i = 0; i < lse.getEvt().size(); i++) {
			String type = lse.getEvt().get(i).getType();
			String titre = lse.getEvt().get(i).getTitre();
			String detailEvenement = lse.getEvt().get(i).getDetailEvenement();
			String ville = lse.getEvt().get(i).getVilleConcernee();
			int quota = lse.getEvt().get(i).getQuota();
			String validation = lse.getEvt().get(i).getValidation();
			String nomSalle;
			String villeSalle;
			String adresseSalle;
			try {
				nomSalle = lse.getEvt().get(i).getSalle().getNom();
				villeSalle = lse.getEvt().get(i).getSalle().getVille();
				adresseSalle = lse.getEvt().get(i).getSalle().getAdresse();
			} catch (Exception e) {
				nomSalle = "Aucune salle n'est affectee";
				villeSalle = "";
				adresseSalle = "";
			}
			Object[] data = { type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
					adresseSalle };
			dtmEvt.addRow(data);
		}
		return dtmEvt;
	}

	public void supprimerSalle(JTable table) {
		if (table.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(new JFrame(), "Selectionnez une salle a supprimer");
		} else {
			String nomSalle = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			Salle s = rechercheSalle(nomSalle);
			int choix = JOptionPane.showConfirmDialog(new JFrame(), "La suppression est irreversible vous etes sur ?",
					"Suppresion de la salle " + nomSalle, JOptionPane.YES_NO_OPTION);
			if (choix == 0) {
				for (Evenement e : lse.getEvt()) {
					if (e.getSalle()==s)
						e.setSalle(new Salle());
				}
				lse.getSalleList().remove(s);
			}
		}
	}

	public void rejetEvenement(JTable tEvents, GestionnaireOrganisme s) {
		if (tEvents.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a rejeter");
		} else {
			String type = tEvents.getModel().getValueAt(tEvents.getSelectedRow(), 0).toString();
			String titre = tEvents.getModel().getValueAt(tEvents.getSelectedRow(), 1).toString();
			String detail = tEvents.getModel().getValueAt(tEvents.getSelectedRow(), 2).toString();
			Evenement ev = rechercheEvenement(type, titre, detail);
			ev.setGestionnaireOrganisme(s);
			ev.setValidation("rejet");
                        JOptionPane.showMessageDialog(new JFrame(), "Evenement rejeté");

		}
	}

	public void gererSalle(char nature, JTable table, JFrame f) {
		JLabel lNom = new JLabel("Nom : ");
		JLabel lVille = new JLabel("Ville : ");
		JLabel lRegion = new JLabel("Region : ");
		JLabel lAdresse = new JLabel("Adresse : ");
		JLabel lNbPlaces = new JLabel("nbPlaces : ");

		lNom.setLocation(30, 30);
		lNom.setSize(140, 20);
		lVille.setLocation(30, 60);
		lVille.setSize(140, 20);
		lRegion.setLocation(30, 90);
		lRegion.setSize(140, 20);
		lAdresse.setLocation(30, 120);
		lAdresse.setSize(140, 20);
		lNbPlaces.setLocation(30, 150);
		lNbPlaces.setSize(140, 20);

		// Create and populate the panel.
		JPanel p = new JPanel();

		p.add(lNom);
		JTextField jNom = new JTextField(10);
		p.add(jNom);

		p.add(lVille);
		JTextField jVille = new JTextField(10);
		p.add(jVille);

		p.add(lRegion);
		JTextField jRegion = new JTextField(10);
		p.add(jRegion);

		p.add(lAdresse);
		JTextField jAdresse = new JTextField(10);
		p.add(jAdresse);

		p.add(lNbPlaces);
		JTextField jNbPlaces = new JTextField(10);
		p.add(jNbPlaces);

		JButton creer = new JButton("Creer");
		p.add(creer);

		frame.setLayout(new BorderLayout());

		frame.setLayout(new FlowLayout());

		// Set up the content pane.
		frame.setContentPane(p);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
				f.setEnabled(true);
			}
		});

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) dimension.getHeight();
		frame.setLocationRelativeTo(null);
		frame.setLocation(frame.getX() - height / 2, frame.getY());
		frame.pack();

		if (nature == 'c') {
			creer.addActionListener(e -> {
				lse.getSalleList().add(new Salle(jNom.getText(), jVille.getText(), jRegion.getText(),
						jAdresse.getText(), Integer.parseInt(jNbPlaces.getText())));
				JOptionPane.showMessageDialog(new JFrame(), "CrÈation de salle avec succËs");
				f.setEnabled(true);
				frame.dispose();
			});
			frame.setVisible(true);
		} else {
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(new JFrame(), "Selectionnez une salle a modifier");
			} else {
				creer.setText("Modifier");
				frame.setTitle("Modifier Salle");
				/* prendre les donnes From table et chercher la salle */
				String nomSalle = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				Salle s = rechercheSalle(nomSalle);
				jNom.setText(nomSalle);
				jVille.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
				jRegion.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
				jAdresse.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
				jNbPlaces.setText(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
				frame.setVisible(true);
				creer.addActionListener(e -> {
					/* insÈrer les donnes dans les champs */
					s.setNom(jNom.getText());
					s.setAdresse(jAdresse.getText());
					s.setVille(jVille.getText());
					s.setRegion(jRegion.getText());
					s.setNbPlaces(Integer.parseInt(jNbPlaces.getText()));
					JOptionPane.showMessageDialog(new JFrame(), "Salle modifiÈ avec succËs");
					f.setEnabled(true);
					frame.dispose();
				});
			}

		}
	}
}
