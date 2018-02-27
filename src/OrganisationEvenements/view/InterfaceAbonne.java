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

    public void setNatureOperation(Abonne a, char nature) {
        if (nature == 'm') {
        	bModifier.setText("Enregistrer les modification");
            tPPrincipal.add("Donnees abonne", pPrincp);
            bModifier.setText("Enregistrer les modification");
            tPPrincipal.add("Donnees abonne", pModification);

            tPPrincipal.add("Mes reservations", pReservation);
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
                //new InterfaceAbonne(a, 'm');
            });
        } else {
            // cacher le button supp
            bSuppr.setVisible(false);
            /*bouton action*/
            bModifier.addActionListener(e -> {
                a.setPrenom(tFirstName.getText());
                a.setNom(tLastName.getText());
                a.setLogin(tLogin.getText());
                a.setMdp(new String(tPassword.getPassword()));
                a.setTel(tTel.getText());
                a.setAdresse(tAddress.getText());
                a.setEmail(tEmail.getText());
                OrganisationEvenements.controller.OrganisationEvenements.getLists().getAbonneList().add(a);

                OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().afficherInterfaceAbonne('m');
                this.dispose();
                //this.setVisible(false);
                //new InterfaceAbonne(a, 'm');
                /* for(Abonne o : OrganisationEvenements.controller.OrganisationEvenements.getLists().getAbonneList() ){
                    System.out.println(o.toString());
                }*/
            });
            bModifier.setText("Valider");
        }
        bAccueil.addActionListener(e -> {
            this.dispose();
            OrganisationEvenements.controller.OrganisationEvenements.getFenetreAccueil().setVisible(true);
        });
    }
}

/*pForm.add(lLogin);
        pForm.add(lPassword);
        pForm.add(lPasswordConfirm);
        
        pForm.add(lLastName);
        pForm.add(lFirstName);
        lLogin.setLabelFor(tLogin);
        pForm.add(tLogin);
        lPassword.setLabelFor(tPassword);
        pForm.add(tPassword);
        lPasswordConfirm.setLabelFor(tPasswordConfirm);
        pForm.add(tPasswordConfirm);
        lLastName.setLabelFor(tLastName);
        pForm.add(tLastName);
        lFirstName.setLabelFor(tFirstName);
        pForm.add(tFirstName);
        //pForm.add(lTel);
        //pForm.add(lEmail);
        //pForm.add(lAddress);
        lTel.setLabelFor(tTel);
        pForm.add(tTel);
        lEmail.setLabelFor(tEmail);
        pForm.add(tEmail);
        lAddress.setLabelFor(tAddress);
        pForm.add(tAddress);

        //lLogin.setLocation(30, 30);
        lLogin.setSize(140, 20);
        //lPassword.setLocation(30, 60);
        lPassword.setSize(140, 20);
        //lPasswordConfirm.setLocation(30, 90);
        lPasswordConfirm.setSize(140, 20);
        //lLastName.setLocation(30, 120);
        lLastName.setSize(140, 20);
        //lFirstName.setLocation(30, 150);
        lFirstName.setSize(140, 20);
        //lTel.setLocation(30, 180);
        lTel.setSize(140, 20);
        //lEmail.setLocation(30, 210);
        lEmail.setSize(140, 20);
        //lAddress.setLocation(30, 240);
        lAddress.setSize(140, 20);
        //tLogin.setLocation(200, 30);
        tLogin.setSize(210, 20);
        tLogin.setEditable(false);
        //tPassword.setLocation(200, 60);
        tPassword.setSize(210, 20);
        //tPasswordConfirm.setLocation(200, 90);
        tPasswordConfirm.setSize(210, 20);
        //tLastName.setLocation(200, 120);
        tLastName.setSize(210, 20);
        tLastName.setEditable(false);
        //tFirstName.setLocation(200, 150);
        tFirstName.setSize(210, 20);
        tFirstName.setEditable(false);
        //tTel.setLocation(200, 180);
        tTel.setSize(210, 20);
        //tEmail.setLocation(200, 210);
        tEmail.setSize(210, 20);
        //tAddress.setLocation(200, 240);
        tAddress.setSize(210, 50);
        //bModifier.setLocation(60, 310);
        bModifier.setSize(150, 25);
        //bAccueil.setLocation(0, 0);
        bAccueil.setSize(100, 25);
        //bSuppr.setLocation(260, 310);
        bSuppr.setSize(150, 25);
 */
