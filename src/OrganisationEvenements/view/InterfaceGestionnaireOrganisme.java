package OrganisationEvenements.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import OrganisationEvenements.controller.*;
import OrganisationEvenements.model.GestionnaireOrganisme;
import OrganisationEvenements.model.Salle;

public class InterfaceGestionnaireOrganisme extends JFrame {

    private JPanel pPrincipal = new JPanel();
    private JPanel pModification = new JPanel();
    private JTabbedPane tPPrincipal = new JTabbedPane();
    private JLabel lLogin = new JLabel("Login : ");
    private JLabel lPassword = new JLabel("Mot de passe : ");
    private JLabel lPasswordConfirm = new JLabel("Confirmez le mot de passe : ");
    private JLabel lLastName = new JLabel("Nom : ");
    private JLabel lFirstName = new JLabel("Prenom : ");
    private JTextField tLogin = new JTextField();
    private JPasswordField tPassword = new JPasswordField();
    private JPasswordField tPasswordConfirm = new JPasswordField();
    private JTextField tLastName = new JTextField();
    private JTextField tFirstName = new JTextField();
    private JButton bModifier = new JButton();
    private JButton bSuppr = new JButton("Supprimer");
    private JButton bAccueil = new JButton("Accueil");
    private JPanel pForm = new JPanel();
    private JPanel pMenu = new JPanel();
    private JPanel pButtons = new JPanel();
    private JPanel pSalles = new JPanel();
    private JScrollPane spEvenements = new JScrollPane();
    private JScrollPane spSalles = new JScrollPane();
    private JTable tEvenements = new JTable();
    private JTable tSalles = new JTable();

    private JPanel pEvenements = new JPanel();
    
    private JPanel pButtonsSalle = new JPanel();
    private JButton bAjoutSalle = new JButton("Creer ");
    private JButton bModifSalle = new JButton("Modifier");
    private JButton bSupSalle = new JButton("Supprimer");
    private JButton bAccoupler = new JButton("Affecter une Salle a Evenement");
    private JButton bRejetEv =  new JButton("Refuse un evenement");
    private JFrame instanceFrame = new JFrame();
    private GestionnaireOrganisme gestionnaireOrganisme;

    private CGestionnaireOrganisme controleurGestionnaireOrganisme;

    public InterfaceGestionnaireOrganisme(GestionnaireOrganisme gO , char nature) {
        this.gestionnaireOrganisme = gO;
        instanceFrame=this;
        controleurGestionnaireOrganisme = new CGestionnaireOrganisme();
        this.setNatureOperation(nature);
        this.design();
    }

    public void design() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Interface Gestionnaire Organisme");
        this.setBounds(new Rectangle(0, 0, 900, 500));
        this.setLayout(new FlowLayout());

        tPPrincipal.add("Donnees gestionnaire organisme", pModification);

        pModification.setLayout(new BorderLayout());
        pModification.add(pForm, BorderLayout.CENTER);
        pForm.setBorder(new EmptyBorder(0, 100, 0, 100));
        GroupLayout formLayoutMgr = new GroupLayout(pForm);

        pForm.setLayout(formLayoutMgr);

        pForm.setLayout(formLayoutMgr);

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
        bSuppr.addActionListener(e -> {
            String mdp = JOptionPane.showInputDialog(this, "Veuillez Rentrer votre mot de passe actuel", JOptionPane.YES_NO_OPTION);
            if (OrganisationEvenements.getLists().getGestionnaireOrganisme(gestionnaireOrganisme.getLogin()).getMdp().equals(mdp)) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Vous etes sur de vouloir supprimer ce compte?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    OrganisationEvenements.getLists().getGestionnaireOrganismeList().remove(gestionnaireOrganisme);
                    OrganisationEvenements.getFenetreAccueil().setVisible(true);
                    this.dispose();
                }
            }
        });
        //Layout manager du formulaire
        formLayoutMgr.setAutoCreateGaps(true);
        //Groupe sequentiel horizontal
        GroupLayout.SequentialGroup hGroup = formLayoutMgr.createSequentialGroup();
        hGroup.addGroup(formLayoutMgr.createParallelGroup().
                addComponent(lLogin).
                addComponent(lPassword).
                addComponent(lPasswordConfirm).
                addComponent(lLastName).
                addComponent(lFirstName)
               );
        hGroup.addGroup(formLayoutMgr.createParallelGroup().
                addComponent(tLogin).
                addComponent(tPassword).
                addComponent(tPasswordConfirm).
                addComponent(tLastName).
                addComponent(tFirstName)
        		);
        formLayoutMgr.setHorizontalGroup(hGroup);

        //Groupe sequentiel Vertical
        GroupLayout.SequentialGroup vGroup = formLayoutMgr.createSequentialGroup();
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
        formLayoutMgr.setVerticalGroup(vGroup);

        //Fill text areas
        tLogin.setText(gestionnaireOrganisme.getLogin());
        tPassword.setText(gestionnaireOrganisme.getMdp());
        tLastName.setText(gestionnaireOrganisme.getNom());
        tFirstName.setText(gestionnaireOrganisme.getPrenom());
       
        this.setContentPane(pPrincipal);
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(tPPrincipal, BorderLayout.CENTER);
        pPrincipal.add(pMenu, BorderLayout.NORTH);
        pMenu.setBackground(Color.darkGray);
        pMenu.add(bAccueil);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public boolean verif() {
        boolean t = false;
        String pw = new String(tPassword.getPassword());
        String pwc = new String(tPasswordConfirm.getPassword());
        if (!pw.equals(pwc)) {
            tPassword.setBackground(Color.red);
            tPasswordConfirm.setBackground(Color.red);
        } else {
            tPassword.setBackground(Color.GREEN);
            tPasswordConfirm.setBackground(Color.green);
            t = true;
        }
        return t;
    }

    public void setNatureOperation(char nature) {
        if (nature == 'm') {
            tPPrincipal.add("Salles", pSalles);
            pSalles.setLayout(new BorderLayout());
            pSalles.add(pEvenements, BorderLayout.CENTER);            
            pEvenements.setLayout(new BorderLayout());
            pEvenements.add(spEvenements, BorderLayout.CENTER);
            pEvenements.add(pButtonsSalle, BorderLayout.NORTH);
            pSalles.add(spSalles, BorderLayout.NORTH);
            spSalles.setBorder(BorderFactory.createTitledBorder("Liste des Salles"));
            spEvenements.setBorder(BorderFactory.createTitledBorder("Liste des Evenements"));
            pButtonsSalle.add(bAjoutSalle);
            pButtonsSalle.add(bModifSalle);
            pButtonsSalle.add(bSupSalle);
            pButtonsSalle.add(bAccoupler);
            pButtonsSalle.add(bRejetEv);
            
            bRejetEv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controleurGestionnaireOrganisme.rejetEvenement(tEvenements, gestionnaireOrganisme);
                    tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
                }
            });
            
            bAccoupler.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controleurGestionnaireOrganisme.accouplerSalleEvenement(tEvenements, tSalles, gestionnaireOrganisme);
                    tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
                }
            });

            controleurGestionnaireOrganisme.getFrame().addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e){
                	tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
                }
            });
            controleurGestionnaireOrganisme.getFrame().addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					//tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    //tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
               	
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					//tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    //tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
               	
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
               	
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
            bAjoutSalle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controleurGestionnaireOrganisme.gererSalle('c',tSalles,instanceFrame);
                    tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
                //System.out.println("test");    
                }
            });
            
            bModifSalle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controleurGestionnaireOrganisme.gererSalle('m',tSalles,instanceFrame);
                    tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
                }
            });

            bSupSalle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	controleurGestionnaireOrganisme.supprimerSalle(tSalles);
                    tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
                    tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
                }
            });
            

            spSalles.setViewportView(tSalles);
            spEvenements.setViewportView(tEvenements);
            tEvenements.setModel(controleurGestionnaireOrganisme.remplirTableEvenement());
            tSalles.setModel(controleurGestionnaireOrganisme.remplirTableSalle());
        
            spSalles.setPreferredSize(new Dimension(0, 150));

            bModifier.setText("Enregistrer les modification");
            tLogin.setEditable(false);
            tLastName.setEditable(false);
            tFirstName.setEditable(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
                if (verif()) {
        
                    gestionnaireOrganisme.setMdp(new String(tPassword.getPassword()));
                    JOptionPane.showMessageDialog(this, "Modification effectues avec succes !");
                } else {
                    JOptionPane.showMessageDialog(this, "Confirmez votre mot de passe");
                }
            });
        } else {
            // cacher le button supp
            bSuppr.setVisible(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
                if (verif()) {
                    gestionnaireOrganisme.setPrenom(tFirstName.getText());
                    gestionnaireOrganisme.setNom(tLastName.getText());
                    gestionnaireOrganisme.setLogin(tLogin.getText());
                    gestionnaireOrganisme.setMdp(new String(tPassword.getPassword()));
                    
                    OrganisationEvenements.getLists().getGestionnaireOrganismeList().add(gestionnaireOrganisme);
                    OrganisationEvenements.getFenetreAccueil().getControleurAccueil().afficherInterfaceGestionnaireOrganisme(gestionnaireOrganisme.getLogin(), gestionnaireOrganisme.getMdp(), 'm', this);
                    JOptionPane.showMessageDialog(this, "Compte cree avec succes !");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Confirmez votre mot de passe");
                }
            });
            bModifier.setText("Valider");
        }
        bAccueil.addActionListener(e -> {
            this.dispose();
            OrganisationEvenements.getFenetreAccueil().setVisible(true);
        });
    }

    public GestionnaireOrganisme getGestionnaireOrganisme() {
        return gestionnaireOrganisme;
    }
}


