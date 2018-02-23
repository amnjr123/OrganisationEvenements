package OrganisationEvenements.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import OrganisationEvenements.controller.*;
import OrganisationEvenements.model.*;

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
	private String[] lUtilisateurs = { "Organisme", "Organisateur", "Abonné" };
	private Lists lists ;
	
	public Accueil() {
		lists = new Lists();
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
		/* Button COnnexion */
		bAcces = new JButton("Accéder");
		pAcces.add(cbUtilisateur);
		bAcces.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (cbUtilisateur.getSelectedItem() == "Organisme"){
					boolean exist=false;
					
					Hashtable<String,String> t = login();
					
					for(Abonne a : lists.getAbonneList()){
						if(t.get("login").equals(a.getLogin()) && t.get("password").equals(a.getMdp())){
							exist=true;
							new InterfaceAbonne();
						}
					}
					if(!exist){
						//new InterfaceAbonneRegister();
					}
				}
				else if (cbUtilisateur.getSelectedItem() == "Organisateur")
					System.out.println("mazal maqadina Organisateur");// veritf
																		// existant
																		// abonné
				else
					System.out.println("mazal maqadina abonne");// veritf
																// existant
																// abonné
			}
		});

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
	/*
	public Lists getbList() {
		return lists;
	}
	*/
	
	public Hashtable<String, String> login() {
		Hashtable<String, String> logininformation = new Hashtable<String, String>();

		JPanel panel = new JPanel(new BorderLayout(5, 5));

		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
		label.add(new JLabel("Login", SwingConstants.RIGHT));
		label.add(new JLabel("Password", SwingConstants.RIGHT));
		panel.add(label, BorderLayout.WEST);

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField username = new JTextField();
		controls.add(username);
		JPasswordField password = new JPasswordField();
		controls.add(password);
		panel.add(controls, BorderLayout.CENTER);

		JOptionPane.showMessageDialog(this, panel, "Login", JOptionPane.QUESTION_MESSAGE);

		logininformation.put("login", username.getText());
		logininformation.put("password", new String(password.getPassword()));
		return logininformation;
	}
}
