package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.*;

import OrganisationEvenements.model.Abonne;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InterfaceAbonne extends JFrame {

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
    private JButton bModifier = new JButton("Modifier");
    private JButton bSuppr = new JButton("Supprimer");
    private JButton bAccueil = new JButton("Accueil");
    private JPanel pForm = new JPanel();
    private JPanel pMenu = new JPanel();
    private JPanel pButtons = new JPanel();

    public InterfaceAbonne(Abonne a) {
        this.design(a);
    }

    public void design(Abonne a) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Interface abonne");
        this.setBounds(new Rectangle(0, 0, 900, 500));
        this.setLayout(new FlowLayout());

        pPrincp.setLayout(new BorderLayout());
        pPrincp.add(pMenu, BorderLayout.NORTH);
        pMenu.add(bAccueil);
        Dimension d = new Dimension(140, 20);
        pPrincp.add(pForm, BorderLayout.CENTER);
        pForm.setBorder(new EmptyBorder(0, 100, 0, 100));
        GroupLayout formLayoutMgr = new GroupLayout(pForm);
<<<<<<< HEAD
        pForm.setLayout(formLayoutMgr);
        tAddress.setBorder(tEmail.getBorder());
=======
        pForm.setLayout(formLayoutMgr);;

        tAddress.setBorder(tEmail.getBorder());
        
>>>>>>> da949f83e7de7dc82e032f3838642933927fc855
        formLayoutMgr.setAutoCreateGaps(true);
        //Groupe sequentiel horizontal
        GroupLayout.SequentialGroup hGroup = formLayoutMgr.createSequentialGroup();
        hGroup.addGroup(formLayoutMgr.createParallelGroup().
                addComponent(lLogin).
                addComponent(lPassword).
                addComponent(lPasswordConfirm).
                addComponent(lLastName).
                addComponent(lFirstName).
                addComponent(lTel).
                addComponent(lAddress));
        hGroup.addGroup(formLayoutMgr.createParallelGroup().
                addComponent(tLogin, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(tPassword, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(tPasswordConfirm, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(tLastName, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(tFirstName, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(tTel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(tAddress, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
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
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lTel).addComponent(tTel));
        vGroup.addGroup(formLayoutMgr.createParallelGroup(Alignment.BASELINE).
                addComponent(lAddress).addComponent(tAddress));
        formLayoutMgr.setVerticalGroup(vGroup);

        tLogin.setPreferredSize(new Dimension(140, 20));
        tLogin.setEditable(false);
        tLastName.setEditable(false);
        tFirstName.setEditable(false);
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
        tLogin.setText(a.getLogin());
        tPassword.setText(a.getMdp());
        tLastName.setText(a.getNom());
        tFirstName.setText(a.getPrenom());
        tTel.setText(a.getTel());
        tEmail.setText(a.getEmail());
        tAddress.setText(a.getAdresse());
        //tAddress.setBorder();

        //pPrincp.add(bModifier);pPrincp.add(bSuppr);pPrincp.add(bAccueil);
        //this.add(pPrincp, BorderLayout.CENTER);
        pPrincp.add(pButtons, BorderLayout.SOUTH);
        pButtons.add(bModifier);
        pButtons.add(bSuppr);

        /*bouton action*/
        bModifier.addActionListener(e -> {
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
        bAccueil.addActionListener(e -> {
            this.setVisible(false);
            new Accueil();
        });
        this.setContentPane(pPrincp);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.pack();
    }
}
