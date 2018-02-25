package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.*;

import OrganisationEvenements.model.Abonne;

public class InterfaceAbonne extends JFrame {
	private JPanel pPrincp = new JPanel();
	private JTabbedPane tabbedPaneReserv = new JTabbedPane();
	private JTabbedPane tabbedPaneEvent = new JTabbedPane();
	private JLabel lLogin = new JLabel("Login : ");
	private JLabel lPassword = new JLabel("Mot de passe : ");
	private JLabel lLastName = new JLabel("Nom : ");
	private JLabel lFirstName = new JLabel("Prénom : ");
	private JLabel lTel = new JLabel("N° Téléphone : ");
	private JLabel lEmail = new JLabel("Adresse E-mail : ");
	private JLabel lAddress = new JLabel("Adresse Postale : ");
	private JTextField tLogin = new JTextField();
	private JPasswordField tPassword = new JPasswordField();
	private JPasswordField tPasswordConfirm = new JPasswordField();
	private JTextField tLastName = new JTextField();
	private JTextField tFirstName = new JTextField();
	private JTextField tTel = new JTextField();
	private JTextField tEmail = new JTextField();
	private JTextArea tAddress = new JTextArea();
	private JButton bModifier = new JButton("Modifier");
	private JButton bSuppr = new JButton("Supprimer");
	private JButton bAccueil = new JButton("Accueil");
	
	public InterfaceAbonne(Abonne a) {
		this.design(a);
	}

	public void design(Abonne a) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Interface abonne");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new FlowLayout());
		
		lLogin.setLocation(30, 30);lLogin.setSize(140, 20);
		lPassword.setLocation(30, 60);lPassword.setSize(140, 20);
		lLastName.setLocation(30, 120);lLastName.setSize(140, 20);
		lFirstName.setLocation(30, 150);lFirstName.setSize(140, 20);
		lTel.setLocation(30, 180);lTel.setSize(140, 20);
		lEmail.setLocation(30, 210);lEmail.setSize(140, 20);
		lAddress.setLocation(30, 240);lAddress.setSize(140, 20);
		tLogin.setLocation(200, 30);tLogin.setSize(210, 20);tLogin.setEditable(false);
		tPassword.setLocation(200, 60);tPassword.setSize(210, 20);
		tPasswordConfirm.setLocation(200, 90);tPasswordConfirm.setSize(210, 20);
		tLastName.setLocation(200, 120);tLastName.setSize(210, 20);tLastName.setEditable(false);
		tFirstName.setLocation(200, 150);tFirstName.setSize(210, 20);tFirstName.setEditable(false);
		tTel.setLocation(200, 180);tTel.setSize(210, 20);
		tEmail.setLocation(200, 210);tEmail.setSize(210, 20);
		tAddress.setLocation(200, 240);tAddress.setSize(210, 50);
		bModifier.setLocation(60, 310);bModifier.setSize(150, 25);
		bAccueil.setLocation(0,0);bAccueil.setSize(100,25);
		bSuppr.setLocation(260, 310);bSuppr.setSize(150, 25);
		tLogin.setText(a.getLogin());tPassword.setText(a.getMdp());
		tLastName.setText(a.getNom());tFirstName.setText(a.getPrenom());
		tTel.setText(a.getTel());tEmail.setText(a.getEmail());tAddress.setText(a.getAdresse());
		//tAddress.setBorder();
		pPrincp.setLayout(null);
		pPrincp.add(lLogin);pPrincp.add(lPassword);
		pPrincp.add(tPasswordConfirm);
		pPrincp.add(lLastName);pPrincp.add(lFirstName);
		pPrincp.add(tLogin);pPrincp.add(tPassword);
		pPrincp.add(tLastName);pPrincp.add(tFirstName);
		pPrincp.add(lTel);pPrincp.add(lEmail);pPrincp.add(lAddress);
		pPrincp.add(tTel);pPrincp.add(tEmail);pPrincp.add(tAddress);
		pPrincp.add(bModifier);pPrincp.add(bSuppr);pPrincp.add(bAccueil);
		//this.add(pPrincp, BorderLayout.CENTER);
		/*bouton action*/
		bModifier.addActionListener(e->{
			a.setTel(tTel.getText());
			a.setEmail(tEmail.getText());
			a.setAdresse(tAddress.getText());
			a.setAdresse(tAddress.getText());
			a.setAdresse(tAddress.getText());
			a.setAdresse(tAddress.getText());
			this.setVisible(false);
			new InterfaceAbonne(a);
			//Accueil.lists.getAbonneList().set(Accueil.lists.getAbonneList().indexOf(a), );		
		});
		bAccueil.addActionListener(e->{
			this.setVisible(false);
			new Accueil();
		});
		this.setContentPane(pPrincp);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
