package OrganisationEvenements.view;

import OrganisationEvenements.controller.OrganisationEvenements;
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
    private DefaultTableModel dtmEvenement;
    private String[] entetes = {"Type", "Titre", "Detail evenement", "Ville Concernee", "quota", "Validation", "Salle",
        "Ville de la salle", "Adresse de la salle"};
    private JButton bCreation;

    public Accueil() {
        this.design();
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
        bCreation = new JButton("Creer un compte");
        pAcces.add(cbUtilisateur);
        /**
         * Button config actionListener
         */
        /* JDK 8 Notation */
        bAcces.addActionListener(e -> {
            if (cbUtilisateur.getSelectedItem() == "Abonne") {
                afficherInterfaceAbonne(null, null, 'm');
            } else if (cbUtilisateur.getSelectedItem() == "Organisateur") {
                afficherInterfaceOrganisateur();
            } else {
                afficherInterfaceGestionnaireOrganisme();
            }
        });
        bCreation.addActionListener(e -> {
            if (cbUtilisateur.getSelectedItem() == "Abonne") {
                afficherInterfaceAbonne(null,null,'c');
            } else if (cbUtilisateur.getSelectedItem() == "Organisateur") {
                afficherInterfaceOrganisateur();
            } else {
                afficherInterfaceGestionnaireOrganisme();
            }
        });

        /* End button config */
        pAcces.add(bAcces);
        pAcces.add(bCreation);
        // Panel Consultation
        pConsultation = new JScrollPane();
        pConsultation.setBorder(BorderFactory.createTitledBorder("Liste d'evenements"));
        pPrincipal.add(pConsultation, BorderLayout.CENTER);
        // Table consultation
        tConsultation = new JTable();
        tConsultation.clearSelection();
        remplirTableEvenement();
        pConsultation.setViewportView(tConsultation);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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

    public void remplirTableEvenement() {
        /*Bach maykonch tikrar f la table une fois revenu l accueil*/
        if (OrganisationEvenements.getLists().getEvt().isEmpty()) {
            OrganisationEvenements.getLists().remplirListEvtTest();
        }
        Lists lists = OrganisationEvenements.getLists();

        dtmEvenement = new DefaultTableModel(entetes, 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        for (int i = 0; i < lists.getEvt().size(); i++) {
            String type = lists.getEvt().get(i).getType();
            String titre = lists.getEvt().get(i).getTitre();
            String detailEvenement = lists.getEvt().get(i).getDetailEvenement();
            String ville = lists.getEvt().get(i).getVilleConcernee();
            int quota = lists.getEvt().get(i).getQuota();
            String validation = lists.getEvt().get(i).getValidation();
            String nomSalle;
            String villeSalle;
            String adresseSalle;
            try {
                nomSalle = lists.getEvt().get(i).getSalle().getNom();
                villeSalle = lists.getEvt().get(i).getSalle().getVille();
                adresseSalle = lists.getEvt().get(i).getSalle().getAdresse();
            } catch (Exception e) {
                nomSalle = "Aucune salle n'est affectee";
                villeSalle = "";
                adresseSalle = "";
            }
            Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                adresseSalle};
            dtmEvenement.addRow(data);
        }
        tConsultation.setModel(dtmEvenement);
    }

    /* Log Acc�s */
    public Hashtable<String, String> login() {
        Hashtable<String, String> logininformation = new Hashtable<String, String>();

        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel plabel = new JPanel(new GridLayout(0, 1, 2, 2));
        plabel.add(new JLabel("Login", SwingConstants.RIGHT));
        plabel.add(new JLabel("Password", SwingConstants.RIGHT));
        panel.add(plabel, BorderLayout.WEST);

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

    public Abonne afficherInterfaceAbonne(String lg, String pw, char nature) {
        boolean exist = false;
        Abonne ab = new Abonne();
        if (nature == 'm') {
            Hashtable<String, String> t;
            if (lg == null && pw == null) {
                t = login();
                lg = t.get("login");
                pw = t.get("password");
            }

            for (Abonne a : OrganisationEvenements.getLists().getAbonneList()) {
                if (lg.equals(a.getLogin()) && pw.equals(a.getMdp())) {
                    exist = true;
                    ab = a;
                    this.setVisible(false);
                    new InterfaceAbonne(ab, nature);
                }
            }
            if (!exist) {
                JOptionPane.showMessageDialog(this, "Compte Abonne non trouve, penser a en creer un");
            }
        } else {
            new InterfaceAbonne(ab, nature);
        }
        return ab;
    }

    public Organisateur afficherInterfaceOrganisateur() {
        boolean exist = false;
        Organisateur ab = new Organisateur();
        Hashtable<String, String> t = login();

        for (Organisateur a : OrganisationEvenements.getLists().getOrganisateurList()) {
            if (t.get("login").equals(a.getLogin()) && t.get("password").equals(a.getMdp())) {
                exist = true;
                ab = a;
                this.setVisible(false);
                new InterfaceOrganisateur(ab);
            }
        }
        if (!exist) {
            JOptionPane.showMessageDialog(this, "Compte Organisateur non trouve, penser a en creer un");
        }
        return ab;
    }

    public GestionnaireOrganisme afficherInterfaceGestionnaireOrganisme() {
        boolean exist = false;
        GestionnaireOrganisme ab = new GestionnaireOrganisme();
        Hashtable<String, String> t = login();

        for (GestionnaireOrganisme a : OrganisationEvenements.getLists().getGestionnaireOrganismeList()) {
            if (t.get("login").equals(a.getLogin()) && t.get("password").equals(a.getMdp())) {
                exist = true;
                ab = a;
                this.setVisible(false);
                new InterfaceGestionnaireOrganisme(ab);
            }
        }
        if (!exist) {
            JOptionPane.showMessageDialog(this, "Compte Organisateur non trouve, penser a en creer un");
        }
        return ab;
    }
}
