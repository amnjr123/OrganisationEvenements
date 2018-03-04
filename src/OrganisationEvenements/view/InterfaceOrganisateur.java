package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import OrganisationEvenements.model.Organisateur;
import OrganisationEvenements.model.Organisateur;

public class InterfaceOrganisateur extends JFrame {

    private JPanel pPrincp = new JPanel();
    private JTabbedPane tabbedPaneReserv = new JTabbedPane();
    private JTabbedPane tabbedPaneEvent = new JTabbedPane();
    private JLabel lLogin = new JLabel("Login : ");
    private JLabel lPassword = new JLabel("Mot de passe : ");
    private JLabel lPasswordConfirm = new JLabel("Confirmez le mot de passe : ");
    private JLabel lLastName = new JLabel("Nom : ");
    private JLabel lFirstName = new JLabel("Prenom : ");
    private JLabel lTel = new JLabel("Numero Telephone : ");
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
    private JButton bModifier = new JButton();
    private JButton bSuppr = new JButton("Supprimer");
    private JButton bAccueil = new JButton("Accueil");
    private JPanel pForm = new JPanel();
    private JPanel pMenu = new JPanel();
    private JPanel pButtons = new JPanel();
    
	public InterfaceOrganisateur(Organisateur o,char nature) {
		this.setNatureOperation(o, nature);
		this.design(o,nature);
	}

	public void design(Organisateur o,char nature) {
		this.setTitle("Interface organisateur");
		 this.setBounds(new Rectangle(0, 0, 900, 500));
	        this.setLayout(new FlowLayout());

	        pPrincp.setLayout(new BorderLayout());
	        pPrincp.add(pMenu, BorderLayout.NORTH);
	        pMenu.add(bAccueil);
	        pPrincp.add(pForm, BorderLayout.CENTER);
	        pForm.setBorder(new EmptyBorder(0, 100, 0, 100));
	        GroupLayout formLayoutMgr = new GroupLayout(pForm);

	        pForm.setLayout(formLayoutMgr);
	        tAddress.setBorder(tEmail.getBorder());

	        pForm.setLayout(formLayoutMgr);

	        tAddress.setBorder(tEmail.getBorder());
	        pPrincp.add(pButtons, BorderLayout.SOUTH);
	        pButtons.add(bModifier);
	        pButtons.add(bSuppr);

	        //Layout manager du formulaire
	        formLayoutMgr.setAutoCreateGaps(true);
	        //Groupe sequentiel horizontal
	        GroupLayout.SequentialGroup hGroup = formLayoutMgr.createSequentialGroup();
	        hGroup.addGroup(formLayoutMgr.createParallelGroup().
	                addComponent(lEmail).
	                addComponent(lLogin).
	                addComponent(lPassword).
	                addComponent(lPasswordConfirm).
	                addComponent(lLastName).
	                addComponent(lFirstName).
	                addComponent(lTel).
	                addComponent(lAddress));
	        hGroup.addGroup(formLayoutMgr.createParallelGroup().
	                addComponent(tEmail).
	                addComponent(tLogin).
	                addComponent(tPassword).
	                addComponent(tPasswordConfirm).
	                addComponent(tLastName).
	                addComponent(tFirstName).
	                addComponent(tTel).
	                addComponent(tAddress));
	        formLayoutMgr.setHorizontalGroup(hGroup);

	        //Groupe sequentiel Vertical
	        GroupLayout.SequentialGroup vGroup = formLayoutMgr.createSequentialGroup();
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lEmail).addComponent(tEmail));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lLogin).addComponent(tLogin));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lPassword).addComponent(tPassword));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lPasswordConfirm).addComponent(tPasswordConfirm));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lLastName).addComponent(tLastName));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lFirstName).addComponent(tFirstName));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lTel).addComponent(tTel));
	        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
	                addComponent(lAddress).addComponent(tAddress));
	        formLayoutMgr.setVerticalGroup(vGroup);

	        //Fill text areas
	        tLogin.setText(o.getLogin());
	        tPassword.setText(o.getMdp());
	        tLastName.setText(o.getNom());
	        tFirstName.setText(o.getPrenom());
	        tTel.setText(o.getTel());
	        tEmail.setText(o.getEmail());
	        tAddress.setText(o.getAdresse());

	        this.setContentPane(pPrincp);
	        this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
    public void setNatureOperation(Organisateur a, char nature) {
        if (nature == 'm') {
            bModifier.setText("Enregistrer les modification");
            tLogin.setEditable(false);
            tLastName.setEditable(false);
            tFirstName.setEditable(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
                a.setTel(tTel.getText());
                a.setEmail(tEmail.getText());
                a.setAdresse(tAddress.getText());
                a.setAdresse(tAddress.getText());
                a.setAdresse(tAddress.getText());
                a.setAdresse(tAddress.getText());
                //this.setVisible(false);
                //new InterfaceOrganisateur(a, 'm');
            });
            bAccueil.addActionListener(e -> {
                this.dispose();
                OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().setVisible(true);
            });
        } else {
            /*bouton action*/
            bModifier.addActionListener(e -> {
                a.setPrenom(tFirstName.getText());
                a.setNom(tLastName.getText());
                a.setLogin(tLogin.getText());
                a.setMdp(new String(tPassword.getPassword()));
                a.setTel(tTel.getText());
                a.setAdresse(tAddress.getText());
                a.setEmail(tEmail.getText());
                OrganisationEvenements.controller.OrganisationEvenements.getLists().getOrganisateurList().add(a);
                
                OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().getControleurAccueil().afficherInterfaceOrganisateur('m',this);
                this.dispose();
                //this.setVisible(false);
                //new InterfaceOrganisateur(a, 'm');
               /* for(Organisateur o : OrganisationEvenements.controller.OrganisationEvenements.getLists().getOrganisateurList() ){
                    System.out.println(o.toString());
                }*/
            });
            bAccueil.addActionListener(e -> {
                this.dispose();
                OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().setVisible(true);
            });
            bModifier.setText("Valider");
        }

    }
}
