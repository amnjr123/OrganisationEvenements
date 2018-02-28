package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.*;

import OrganisationEvenements.model.Abonne;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InterfaceAbonne extends JFrame {

    private JPanel pPrincipal = new JPanel();
    private JPanel pModification = new JPanel();
    private JTabbedPane tPPrincipal = new JTabbedPane();
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
    private JPanel pReservation = new JPanel();

    public InterfaceAbonne(Abonne a, char nature) {
        this.setNatureOperation(a, nature);
        this.design(a);
    }

    public void design(Abonne a) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Interface abonne");
        this.setBounds(new Rectangle(0, 0, 900, 500));
        this.setLayout(new FlowLayout());

        tPPrincipal.add("Donnees abonne", pModification);


        pModification.setLayout(new BorderLayout());
        pModification.add(pForm, BorderLayout.CENTER);
        pForm.setBorder(new EmptyBorder(0, 100, 0, 100));
        GroupLayout formLayoutMgr = new GroupLayout(pForm);

        pForm.setLayout(formLayoutMgr);
        tAddress.setBorder(tEmail.getBorder());

        pForm.setLayout(formLayoutMgr);

        tAddress.setBorder(tEmail.getBorder());
        pModification.add(pButtons, BorderLayout.SOUTH);
        pButtons.add(bModifier);
        pButtons.add(bSuppr);

        //CONFIRM PASSWORD
        DocumentListener documentListenerPasswordCofirm = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				verif();
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				verif();
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				verif();
			}
        };

        tPassword.getDocument().addDocumentListener(documentListenerPasswordCofirm);
        tPasswordConfirm.getDocument().addDocumentListener(documentListenerPasswordCofirm);
        //Delete Button
        bSuppr.addActionListener(e->{
        	String mdp =  JOptionPane.showInputDialog(this,"Veuillez Rentrer votre pass actuel" ,JOptionPane.YES_NO_OPTION);
    		if(OrganisationEvenements.controller.OrganisationEvenements.getLists().getAbonne(a.getLogin()).getMdp().equals(mdp)){
        		int dialogResult = JOptionPane.showConfirmDialog (null, "Vous êtes sur de vouloir supprimer ce compte?","Warning",JOptionPane.YES_NO_OPTION);
            	if(dialogResult == JOptionPane.YES_OPTION){
               	 	OrganisationEvenements.controller.OrganisationEvenements.getLists().getAbonneList().remove(a);
                    OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().setVisible(true);
               	 	this.dispose(); 
            	}
    		}else
    			JOptionPane.showMessageDialog(this, " I am asking for your pass !!");
    	});
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
        tLogin.setText(a.getLogin());
        tPassword.setText(a.getMdp());
        tLastName.setText(a.getNom());
        tFirstName.setText(a.getPrenom());
        tTel.setText(a.getTel());
        tEmail.setText(a.getEmail());
        tAddress.setText(a.getAdresse());

        this.setContentPane(pPrincipal);
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(tPPrincipal, BorderLayout.CENTER);
        pPrincipal.add(pMenu, BorderLayout.NORTH);
        pMenu.setBackground(Color.darkGray);
        pMenu.add(bAccueil);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public boolean verif(){
    	boolean t = false;
    	String pw = new String(tPassword.getPassword());
    	String pwc = new String(tPasswordConfirm.getPassword());
    	if (!pw.equals(pwc)){
    		tPassword.setBackground(Color.red);
    		tPasswordConfirm.setBackground(Color.red);
    	} else {
    		tPassword.setBackground(Color.GREEN);
    		tPasswordConfirm.setBackground(Color.green);
    		t=true;
    	}
    	return t;
    }
    
    public void setNatureOperation(Abonne a, char nature) {
        if (nature == 'm') {
            tPPrincipal.add("Mes reservations", pReservation);
            bModifier.setText("Enregistrer les modification");
            tLogin.setEditable(false);
            tLastName.setEditable(false);
            tFirstName.setEditable(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
            	if(verif()){
                    a.setTel(tTel.getText());
                    a.setEmail(tEmail.getText());
                    a.setAdresse(tAddress.getText());
                    a.setMdp(new String(tPassword.getPassword()));
            	}
            });
        } else {
            // cacher le button supp
            bSuppr.setVisible(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
            	if(verif()){
                    a.setPrenom(tFirstName.getText());
                    a.setNom(tLastName.getText());
                    a.setLogin(tLogin.getText());
                    a.setMdp(new String(tPassword.getPassword()));
                    a.setTel(tTel.getText());
                    a.setAdresse(tAddress.getText());
                    a.setEmail(tEmail.getText());
                    OrganisationEvenements.controller.OrganisationEvenements.getLists().getAbonneList().add(a);
                    OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().afficherInterfaceAbonne(a.getLogin(),a.getMdp(),'m');
                    this.dispose();
            	}
            });
            bModifier.setText("Valider");
        }
        bAccueil.addActionListener(e -> {
            this.dispose();
            OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().setVisible(true);
        });
        
    }
}
