package OrganisationEvenements.view;

import OrganisationEvenements.controller.OrganisationEvenements;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import OrganisationEvenements.controller.*;
import OrganisationEvenements.model.*;
import javax.swing.table.DefaultTableModel;

public class Accueil extends JFrame {

	// Declaration panels
	private JPanel pPrincipal;
	private JPanel pAcces;
	private JScrollPane pConsultation;
	// Declaration Tableau
	private JTable tConsultation;
	// Declaration objets acces
	private JComboBox<String> cbUtilisateur;
	private JButton bAcces;
	private String[] lUtilisateurs = { "Organisme", "Organisateur", "Abonne" };
	
	private JButton bCreation;
	private CAccueil controleurAccueil;
	
	public Accueil() {
		controleurAccueil= new CAccueil();
		this.design();
	}
	/*Dessiner l'interface accueil*/
	public void design() {
		this.setTitle("Accueil");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new BorderLayout());
		// Panel principal
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		this.add(pPrincipal, BorderLayout.CENTER);
		// panel Acces
		pAcces = new JPanel();
		pAcces.setBorder(BorderFactory.createTitledBorder("Acces"));
		pPrincipal.add(pAcces, BorderLayout.NORTH);
		cbUtilisateur = new JComboBox<String>(lUtilisateurs);
		/* Button COnnexion */
		bAcces = new JButton("Acceder");
		bCreation = new JButton("Creer un compte");
		pAcces.add(cbUtilisateur);
		/**
		 * Button config actionListener
		 */
		/* JDK 8 Notation */
		bAcces.addActionListener(e -> {
			if (cbUtilisateur.getSelectedItem() == "Abonne") {
				controleurAccueil.afficherInterfaceAbonne(null,null,'m',this);
			} else if (cbUtilisateur.getSelectedItem() == "Organisateur") {
				controleurAccueil.afficherInterfaceOrganisateur(null,null,'m',this);
			} else {
				controleurAccueil.afficherInterfaceGestionnaireOrganisme(null,null,'m',this);
			}
		});
		bCreation.addActionListener(e -> {
			if (cbUtilisateur.getSelectedItem() == "Abonne") {
				controleurAccueil.afficherInterfaceAbonne(null,null,'c',this);
			} else if (cbUtilisateur.getSelectedItem() == "Organisateur") {
				controleurAccueil.afficherInterfaceOrganisateur(null,null,'c',this);
			} else {
				controleurAccueil.afficherInterfaceGestionnaireOrganisme(null,null,'c',this);
			}
		});

		/* End button config */
		pAcces.add(bAcces);
		pAcces.add(bCreation);
		// Panel Consultation
		pConsultation = new JScrollPane();
		pConsultation.setBorder(BorderFactory.createTitledBorder("Liste d'evenements"));
		pPrincipal.add(pConsultation, BorderLayout.CENTER);
		// Table consultation
		tConsultation = new JTable();
		tConsultation.clearSelection();
		tConsultation.setModel(controleurAccueil.remplirTableEvenement());
	
		pConsultation.setViewportView(tConsultation);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/* M�thodes de gestion pour le controleur d'accueil*/
	public JTable gettConsultation() {
		return tConsultation;
	}

	public JComboBox<String> getCbUtilisateur() {
		return cbUtilisateur;
	}
	
	public CAccueil getControleurAccueil() {
		return controleurAccueil;
	}

	public JButton getbAcces() {
		return bAcces;
	}
}
