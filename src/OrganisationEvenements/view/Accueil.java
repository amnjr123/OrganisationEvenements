package OrganisationEvenements.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

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
	public static Lists lists ;
	
	
	
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
		/** Button config actionListener*/
		bAcces.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (cbUtilisateur.getSelectedItem() == "Organisme"){
					afficherInterfaceAbonne();
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
		/*End button config*/
		pAcces.add(bAcces);
		// Panel Consultation
		pConsultation = new JScrollPane();
		pConsultation.setBorder(BorderFactory.createTitledBorder("Liste d'évènements"));
		pPrincipal.add(pConsultation, BorderLayout.CENTER);
		// Table consultation
		tConsultation = new JTable( new TableEvenements());
		
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
	
	public Lists getbList() {
		return lists;
	}
	
	
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
	
	public Abonne afficherInterfaceAbonne(){
		boolean exist=false;
		Abonne ab = new Abonne();
		Hashtable<String,String> t = login();
		
		for(Abonne a : lists.getAbonneList()){
			if(t.get("login").equals(a.getLogin()) && t.get("password").equals(a.getMdp())){
			   exist=true; ab=a;
			   this.setVisible(false);
			   new InterfaceAbonne();
			}
		}
		if(!exist){
			JOptionPane.showMessageDialog(this, "Compte Abonne non trouvé, penser a en créer un");
		}
		return ab;
	}
}

class TableEvenements extends AbstractTableModel {
	
    private final Object[][] donnees;
    private final String[] entetes = {"Type", "Titre", "Détail évènement", "Ville Concernee", "quota", "validation", "Salle"};
    
    public TableEvenements() {
        super();
        donnees = new Object[Accueil.lists.getEvt().size()/2][2];/*{
                {"Johnathan", "Sykes", Color.red, true, Sport.TENNIS},
                {"Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
                {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
                {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
                {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
        };*/
    }
 
    public int getRowCount() {
        return donnees.length;
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        return donnees[rowIndex][columnIndex];
    }
}