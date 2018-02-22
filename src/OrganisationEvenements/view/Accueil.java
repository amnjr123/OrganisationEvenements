package OrganisationEvenements.view;

import java.awt.*;
import javax.swing.*;
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
	private String[] lUtilisateurs = { "Organnisme", "Organisateur", "Abonné" };

	public Accueil() {
		this.design();
		this.setVisible(true);
	}

	public void design() {
		this.setTitle("Accueil");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new BorderLayout());
		// Panel principal
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		this.add(pPrincipal, BorderLayout.CENTER);
		// panel Accès
		pAcces = new JPanel();
		pAcces.setBorder(BorderFactory.createTitledBorder("Accès"));
		pPrincipal.add(pAcces, BorderLayout.NORTH);
		cbUtilisateur = new JComboBox<String>(lUtilisateurs);
		bAcces = new JButton("Accéder");
		pAcces.add(cbUtilisateur);
		pAcces.add(bAcces);
		// Panel Consultation
		pConsultation = new JScrollPane();
		pConsultation.setBorder(BorderFactory.createTitledBorder("Liste d'évènements"));
		pPrincipal.add(pConsultation, BorderLayout.CENTER);
		// Table consultation
		tConsultation = new JTable();
		this.setLocationRelativeTo(null);
	}

	public JTable gettConsultation() {
		return tConsultation;
	}

	public JComboBox<String> getCbUtilisateur() {
		return cbUtilisateur;
	}

	public JButton getbAcces() {
		return bAcces;
	}

}
