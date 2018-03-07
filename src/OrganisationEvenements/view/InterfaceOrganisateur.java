package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.*;
import OrganisationEvenements.controller.*;

import OrganisationEvenements.model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InterfaceOrganisateur extends JFrame {

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
    //private JTextField tVille = new JTextField();
    //private JTextField tRegion = new JTextField();
    //private JLabel lVille = new JLabel("Ville");
    //private JLabel lRegion = new JLabel("Region");
    private JButton bModifier = new JButton();
    private JButton bSuppr = new JButton("Supprimer");
    private JButton bAccueil = new JButton("Accueil");
    private JPanel pForm = new JPanel();
    private JPanel pMenu = new JPanel();
    private JPanel pButtons = new JPanel();
    private JPanel pEvenementsOrg = new JPanel();
    private JScrollPane spEvenements = new JScrollPane();
    private JScrollPane spEvenementsOrg = new JScrollPane();
    private JTable tEvenements = new JTable();
    private JTable tEvenementsOrg = new JTable();

    private JPanel pEvenements = new JPanel();
    private JPanel pButtonsEvenements = new JPanel();
    private JButton bAjoutRes = new JButton("Creer un evenement");
    private JButton bSupRes = new JButton("Suprimmer l'evenement");
    private JButton bModifEvt = new JButton("Modifier l'evenement");

    private JPanel pAjoutModif = new JPanel();
    private JPanel pButtonsAjout = new JPanel();
    private JPanel pAjoutEvenement = new JPanel();
    private JLabel lType = new JLabel("Type");
    private JComboBox<String> tType = new JComboBox<String>(new String[]{"Concert", "Conference"});
    private JLabel lTitre = new JLabel("Titre de l'evenement");
    private JTextField tTitre = new JTextField();
    private JLabel lDetail = new JLabel("Detail de l'evenement");
    private JTextField tDetail = new JTextField();
    private JLabel lVille = new JLabel("Ville concernee");
    private JTextField tVille = new JTextField();
    private JLabel lQuota = new JLabel("Nombre de spectateurs");
    private JTextField tQuota = new JTextField();

    private JButton bSauvegardeAjout = new JButton("Enregistrer");
    private JButton bCancel = new JButton("Annuler");

    private Organisateur organisateur;
    private COrganisateur controleurOrganisateur;

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public InterfaceOrganisateur(Organisateur o, char nature) {
        this.organisateur = o;
        controleurOrganisateur = new COrganisateur();
        this.setNatureOperation(nature);
        this.design();
    }

    public void design() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Interface organisateur");
        this.setBounds(new Rectangle(0, 0, 900, 500));
        this.setLayout(new FlowLayout());

        tPPrincipal.add("Donnees organisateur", pModification);

        pModification.setLayout(new BorderLayout());
        pModification.add(pForm, BorderLayout.CENTER);
        pForm.setBorder(new EmptyBorder(0, 100, 0, 100));
        GroupLayout formLayoutMgr = new GroupLayout(pForm);

        pForm.setLayout(formLayoutMgr);
        tAddress.setBorder(tEmail.getBorder());

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
        bSuppr.addActionListener(e -> {
            String mdp = JOptionPane.showInputDialog(this, "Veuillez Rentrer votre mot de passe actuel", JOptionPane.YES_NO_OPTION);
            if (OrganisationEvenements.getLists().getOrganisateur(organisateur.getLogin()).getMdp().equals(mdp)) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Vous etes sur de vouloir supprimer ce compte?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    OrganisationEvenements.getLists().getOrganisateurList().remove(organisateur);
                    OrganisationEvenements.getFenetreAccueil().setVisible(true);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mot de passe erronne !");
            }
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
        tLogin.setText(organisateur.getLogin());
        tPassword.setText(organisateur.getMdp());
        tLastName.setText(organisateur.getNom());
        tFirstName.setText(organisateur.getPrenom());
        tTel.setText(organisateur.getTel());
        tEmail.setText(organisateur.getEmail());
        tAddress.setText(organisateur.getAdresse());

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

    public void viderChampsAjout() {
        tTitre.setText("");
        tDetail.setText("");
        tVille.setText("");
        tQuota.setText("");
    }

    public void designAjoutEvenements() {
        pAjoutModif.setLayout(new BorderLayout());
        pAjoutModif.add(pAjoutEvenement, BorderLayout.CENTER);
        pAjoutModif.add(pButtonsAjout, BorderLayout.SOUTH);
        pButtonsAjout.add(bSauvegardeAjout);
        pButtonsAjout.add(bCancel);
        pAjoutEvenement.setBorder(new EmptyBorder(0, 100, 0, 100));
        GroupLayout formLayoutMgr = new GroupLayout(pAjoutEvenement);
        pAjoutEvenement.setLayout(formLayoutMgr);
        //Layout manager du formulaire
        formLayoutMgr.setAutoCreateGaps(true);
        //Groupe sequentiel horizontal
        GroupLayout.SequentialGroup hGroup = formLayoutMgr.createSequentialGroup();
        hGroup.addGroup(formLayoutMgr.createParallelGroup().
                addComponent(lType).
                addComponent(lTitre).
                addComponent(lDetail).
                addComponent(lVille).
                addComponent(lQuota));
        hGroup.addGroup(formLayoutMgr.createParallelGroup().
                addComponent(tType).
                addComponent(tTitre).
                addComponent(tDetail).
                addComponent(tVille).
                addComponent(tQuota));
        formLayoutMgr.setHorizontalGroup(hGroup);

        //Groupe sequentiel Vertical
        GroupLayout.SequentialGroup vGroup = formLayoutMgr.createSequentialGroup();
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lType).addComponent(tType));
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lTitre).addComponent(tTitre));
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lDetail).addComponent(tDetail));
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lVille).addComponent(tVille));
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lQuota).addComponent(tQuota));
        formLayoutMgr.setVerticalGroup(vGroup);

        bSauvegardeAjout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int numPlaces = Integer.parseInt(tQuota.getText());
                    if (!controleurOrganisateur.isModif()) {
                        Evenement evt = new Evenement(tType.getSelectedItem().toString(), tTitre.getText(), tDetail.getText(), tVille.getText(), numPlaces, organisateur);
                        controleurOrganisateur.sauvegardeEvenement(evt);
                        JOptionPane.showMessageDialog(new JFrame(), "Evenement enregistre avec succes");
                        tEvenements.setModel(controleurOrganisateur.getDtmListeEvenementsOrgValide(organisateur));
                        tEvenementsOrg.setModel(controleurOrganisateur.getDtmListeEvenementsOrgEncours(organisateur));
                        tPPrincipal.setEnabledAt(0, true);
                        tPPrincipal.setEnabledAt(2, true);
                        tPPrincipal.setEnabledAt(1, false);
                        viderChampsAjout();
                        tPPrincipal.setSelectedIndex(0);
                    } else {
                        String type = tType.getSelectedItem().toString();
                        String titre = tTitre.getText();
                        String detail = tDetail.getText();
                        String ville = tVille.getText();
                        controleurOrganisateur.modifEvemnement(controleurOrganisateur.getEvenement(), type, titre, detail, ville, numPlaces);
                        JOptionPane.showMessageDialog(new JFrame(), "Evenement modifie avec succes");
                        tEvenements.setModel(controleurOrganisateur.getDtmListeEvenementsOrgValide(organisateur));
                        tEvenementsOrg.setModel(controleurOrganisateur.getDtmListeEvenementsOrgEncours(organisateur));
                        tPPrincipal.setEnabledAt(0, true);
                        tPPrincipal.setEnabledAt(2, true);
                        tPPrincipal.setEnabledAt(1, false);
                        viderChampsAjout();
                        tPPrincipal.setSelectedIndex(0);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Verifiez le nombre de places Saisi");
                }
            }
        });
        bCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tPPrincipal.setEnabledAt(0, true);
                tPPrincipal.setEnabledAt(2, true);
                tPPrincipal.setEnabledAt(1, false);
                viderChampsAjout();
                tPPrincipal.setSelectedIndex(0);
            }
        });

    }

    public void setNatureOperation(char nature) {
        if (nature == 'm') {
            tPPrincipal.add("Mes Evenements", pEvenementsOrg);
            tPPrincipal.add("Creer ou modifier un evenement", pAjoutModif);
            tPPrincipal.setEnabledAt(1, false);

            pEvenementsOrg.setLayout(new BorderLayout());
            pEvenementsOrg.add(pEvenements, BorderLayout.CENTER);
            pEvenements.setLayout(new BorderLayout());
            pEvenements.add(spEvenements, BorderLayout.CENTER);
            pEvenements.add(pButtonsEvenements, BorderLayout.NORTH);
            pEvenementsOrg.add(spEvenementsOrg, BorderLayout.NORTH);
            spEvenements.setBorder(BorderFactory.createTitledBorder("Liste d'evenements valides"));
            spEvenementsOrg.setBorder(BorderFactory.createTitledBorder("Mes Evenements en cours"));
            pButtonsEvenements.add(bAjoutRes);
            pButtonsEvenements.add(bModifEvt);
            pButtonsEvenements.add(bSupRes);

            designAjoutEvenements();

            bSupRes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tEvenementsOrg.getSelectionModel().isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a supprimer");
                    } else {
                        String type = tEvenementsOrg.getModel().getValueAt(tEvenementsOrg.getSelectedRow(), 0).toString();
                        String titre = tEvenementsOrg.getModel().getValueAt(tEvenementsOrg.getSelectedRow(), 1).toString();
                        String detail = tEvenementsOrg.getModel().getValueAt(tEvenementsOrg.getSelectedRow(), 2).toString();
                        controleurOrganisateur.supprimerEvernement(controleurOrganisateur.rechercheEvenement(type, titre, detail));
                        tEvenements.setModel(controleurOrganisateur.getDtmListeEvenementsOrgValide(organisateur));
                        tEvenementsOrg.setModel(controleurOrganisateur.getDtmListeEvenementsOrgEncours(organisateur));
                    }
                }
            });

            bAjoutRes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tPPrincipal.setEnabledAt(0, false);
                    tPPrincipal.setEnabledAt(2, false);
                    tPPrincipal.setEnabledAt(1, true);
                    tPPrincipal.setSelectedIndex(1);
                    controleurOrganisateur.setModif(false);
                }
            });
            bModifEvt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tEvenementsOrg.getSelectionModel().isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Selectionnez un evenement a modifier");
                    } else {
                        tPPrincipal.setEnabledAt(0, false);
                        tPPrincipal.setEnabledAt(2, false);
                        tPPrincipal.setEnabledAt(1, true);
                        tPPrincipal.setSelectedIndex(1);
                        controleurOrganisateur.setModif(true);
                        String type = tEvenementsOrg.getModel().getValueAt(tEvenementsOrg.getSelectedRow(), 0).toString();
                        String titre = tEvenementsOrg.getModel().getValueAt(tEvenementsOrg.getSelectedRow(), 1).toString();
                        String detail = tEvenementsOrg.getModel().getValueAt(tEvenementsOrg.getSelectedRow(), 2).toString();
                        controleurOrganisateur.setEvenement(controleurOrganisateur.rechercheEvenement(type, titre, detail));
                    }
                }
            });
            //A rectifier bSupRes.addActionListener(new ActionListener();
            spEvenementsOrg.setViewportView(tEvenementsOrg);
            spEvenements.setViewportView(tEvenements);
            tEvenements.setModel(controleurOrganisateur.getDtmListeEvenementsOrgValide(organisateur));
            tEvenementsOrg.setModel(controleurOrganisateur.getDtmListeEvenementsOrgEncours(organisateur));
            //System.out.println(abonne.getVille());

            spEvenementsOrg.setPreferredSize(new Dimension(0, 150));

            bModifier.setText("Enregistrer les modification");
            tLogin.setEditable(false);
            tLastName.setEditable(false);
            tFirstName.setEditable(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
                if (verif()) {
                    organisateur.setTel(tTel.getText());
                    organisateur.setEmail(tEmail.getText());
                    organisateur.setAdresse(tAddress.getText());
                    organisateur.setMdp(new String(tPassword.getPassword()));
                    //tReservations.setModel(controleurReservation.getDtmListeReservationsAbonne(abonne));
                    //tEvenements.setModel(controleurReservation.getDtmListeEvenementsVilleRegionAbonne(abonne));
                    JOptionPane.showMessageDialog(this, "Modification effectues avec succes !");
                    spEvenements.setBorder(BorderFactory.createTitledBorder("Liste d'evenements"));
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
                    organisateur.setPrenom(tFirstName.getText());
                    organisateur.setNom(tLastName.getText());
                    organisateur.setLogin(tLogin.getText());
                    organisateur.setMdp(new String(tPassword.getPassword()));
                    organisateur.setTel(tTel.getText());
                    organisateur.setAdresse(tAddress.getText());
                    organisateur.setEmail(tEmail.getText());
                    OrganisationEvenements.getLists().getOrganisateurList().add(organisateur);
                    OrganisationEvenements.getFenetreAccueil().getControleurAccueil().afficherInterfaceOrganisateur(organisateur.getLogin(), organisateur.getMdp(), 'm', this);
                    JOptionPane.showMessageDialog(this, "Compte cree avec succes ! Yala raw3a :D !");
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
}
