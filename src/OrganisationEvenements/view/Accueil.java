package OrganisationEvenements.view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import OrganisationEvenements.controller.*;
import OrganisationEvenements.model.*;
import javax.swing.table.DefaultTableModel;

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
    private String[] lUtilisateurs = {"Organisme", "Organisateur", "Abonne"};
    public static Lists lists;
    private DefaultTableModel dtmEvenement;
    private String[] entetes = {"Type", "Titre", "Detail evenement", "Ville Concernee", "quota", "Validation","Salle","Ville de la salle","Adresse de la salle"};

    public Accueil() {
        lists = new Lists();
        this.design();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void remplirTableEvenement() {
        lists.remplirListEvtTest();
        dtmEvenement = new DefaultTableModel(entetes, 0){
        		/*Non editable*/
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };;
        for (int i = 0; i < lists.getEvt().size(); i++) {
            String type = lists.getEvt().get(i).getType();
            String titre = lists.getEvt().get(i).getTitre();
            String detailEvenement = lists.getEvt().get(i).getDetailEvenement();
            String ville = lists.getEvt().get(i).getVilleConcernee();
            int quota = lists.getEvt().get(i).getQuota();
            String validation = lists.getEvt().get(i).getValidation();
            String nomSalle;
            String villeSalle ;
            String adresseSalle;
            try {
                nomSalle = lists.getEvt().get(i).getSalle().getNom();
                villeSalle = lists.getEvt().get(i).getSalle().getVille();
                adresseSalle = lists.getEvt().get(i).getSalle().getAdresse();
            } catch (Exception e) {
                nomSalle= "Aucune salle n'est affectee";
                villeSalle="";
                adresseSalle="";
            }
            Object[] data = {type,titre,detailEvenement,ville,quota,validation,nomSalle,villeSalle,adresseSalle};
            dtmEvenement.addRow(data);
        }
        tConsultation.setModel(dtmEvenement);

    }

    public void design() {
        this.setTitle("Accueil");
        this.setBounds(new Rectangle(0, 0, 900, 500));
        this.setLayout(new BorderLayout());
        // Panel principal
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        this.add(pPrincipal, BorderLayout.CENTER);
        // panel Acces
        pAcces = new JPanel();
        pAcces.setBorder(BorderFactory.createTitledBorder("Acces"));
        pPrincipal.add(pAcces, BorderLayout.NORTH);
        cbUtilisateur = new JComboBox<String>(lUtilisateurs);
        /* Button COnnexion */
        bAcces = new JButton("Acceder");
        pAcces.add(cbUtilisateur);
        /**
         * Button config actionListener
         */
        /*JDK 8 Notation*/
        bAcces.addActionListener(e ->{
            if (cbUtilisateur.getSelectedItem() == "Abonne") {
                afficherInterfaceAbonne();
            } else if (cbUtilisateur.getSelectedItem() == "Organisateur") {
                System.out.println("mazal maqadina Organisateur");
            } 
            else {
                System.out.println("mazal maqadina Organisme");
            }			  
   });
        /*End button config*/
        pAcces.add(bAcces);
        // Panel Consultation
        pConsultation = new JScrollPane();
        pConsultation.setBorder(BorderFactory.createTitledBorder("Liste d'evenements"));
        pPrincipal.add(pConsultation, BorderLayout.CENTER);
        // Table consultation
        tConsultation = new JTable();
        remplirTableEvenement();
        pConsultation.setViewportView(tConsultation);

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

    public Abonne afficherInterfaceAbonne() {
        boolean exist = false;
        Abonne ab = new Abonne();
        Hashtable<String, String> t = login();

        for (Abonne a : lists.getAbonneList()) {
            if (t.get("login").equals(a.getLogin()) && t.get("password").equals(a.getMdp())) {
                exist = true;
                ab = a;
                this.setVisible(false);
                new InterfaceAbonne(ab);
            }
        }
        if (!exist) {
            JOptionPane.showMessageDialog(this, "Compte Abonne non trouve, penser a en creer un");
        }
        return ab;
    }
}