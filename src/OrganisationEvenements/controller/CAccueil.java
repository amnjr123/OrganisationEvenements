package OrganisationEvenements.controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import OrganisationEvenements.model.*;
import OrganisationEvenements.view.*;
import javax.swing.JTable;

public class CAccueil {

    private Lists lse;
    private DefaultTableModel dtmEvenement;
    private String[] entetes = {"Type", "Titre", "Detail evenement", "Ville Concernee", "quota", "Validation", "Salle",
        "Ville de la salle", "Adresse de la salle"};

    public CAccueil() {
        lse = OrganisationEvenements.getLists();
    }

    public DefaultTableModel remplirTableEvenement() {
        /* Bach maykonch tikrar f la table une fois revenu l accueil */
 /*if (OrganisationEvenements.getLists().getEvt().isEmpty()) {
            OrganisationEvenements.getLists().remplirListEvtTest();
        }*/

        dtmEvenement = new DefaultTableModel(entetes, 0) {
            /* Non editable */
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };

        for (int i = 0; i < lse.getEvt().size(); i++) {
            String type = lse.getEvt().get(i).getType();
            String titre = lse.getEvt().get(i).getTitre();
            String detailEvenement = lse.getEvt().get(i).getDetailEvenement();
            String ville = lse.getEvt().get(i).getVilleConcernee();
            int quota = lse.getEvt().get(i).getQuota();
            String validation = lse.getEvt().get(i).getValidation();
            String nomSalle;
            String villeSalle;
            String adresseSalle;
            try {
                nomSalle = lse.getEvt().get(i).getSalle().getNom();
                villeSalle = lse.getEvt().get(i).getSalle().getVille();
                adresseSalle = lse.getEvt().get(i).getSalle().getAdresse();
            } catch (Exception e) {
                nomSalle = "Aucune salle n'est affectee";
                villeSalle = "";
                adresseSalle = "";
            }
            Object[] data = {type, titre, detailEvenement, ville, quota, validation, nomSalle, villeSalle,
                adresseSalle};
            dtmEvenement.addRow(data);
        }
        return dtmEvenement;
    }

    public Hashtable<String, String> login(JFrame frame) {
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

        JOptionPane.showMessageDialog(frame, panel, "Login", JOptionPane.QUESTION_MESSAGE);

        logininformation.put("login", username.getText());
        logininformation.put("password", new String(password.getPassword()));
        return logininformation;
    }

    /*	M�thodes D'affichages des interfaces	*/
 /*			Interface abonnee				*/
    public Abonne afficherInterfaceAbonne(String login, String password, char nature, JFrame frame) {
        boolean exist = false;
        Abonne ab = new Abonne();
        if (nature == 'm') {
            if ((login == null) && (password == null)) {
                Hashtable<String, String> t = login(frame);
                login = t.get("login");
                password = t.get("password");
            }
            for (Abonne a : OrganisationEvenements.getLists().getAbonneList()) {
                if (login.equals(a.getLogin()) && password.equals(a.getMdp())) {
                    exist = true;
                    ab = a;
                    frame.setVisible(false);
                    new InterfaceAbonne(ab, nature);
                }
            }
            if (!exist) {
                JOptionPane.showMessageDialog(frame, "Compte Abonne non trouve, penser a en creer un");
            }

        } else {
            new InterfaceAbonne(ab, 'c');
        }

        return ab;
    }

    /*			Interface Organisateur				*/
    public Organisateur afficherInterfaceOrganisateur(String login, String password, char nature, JFrame frame) {
        boolean exist = false;
        Organisateur ab = new Organisateur();
        if (nature == 'm') {
            if ((login == null) && (password == null)) {
                Hashtable<String, String> t = login(frame);
                login = t.get("login");
                password = t.get("password");
            }
            for (Organisateur a : OrganisationEvenements.getLists().getOrganisateurList()) {
                if (login.equals(a.getLogin()) && password.equals(a.getMdp())) {
                    exist = true;
                    ab = a;
                    frame.setVisible(false);
                    new InterfaceOrganisateur(ab, nature);
                }
            }
            if (!exist) {
                JOptionPane.showMessageDialog(frame, "Compte Organisateur non trouve, penser a en creer un");
            }
        } else {
            new InterfaceOrganisateur(ab, 'c');
        }
        return ab;
    }

    /*			Interface GestionOrganisme			*/
    public GestionnaireOrganisme afficherInterfaceGestionnaireOrganisme(String login, String password, char nature, JFrame frame) {
        boolean exist = false;
        GestionnaireOrganisme ab = new GestionnaireOrganisme();
        if (nature == 'm') {
            if ((login == null) && (password == null)) {
                Hashtable<String, String> t = login(frame);
                login = t.get("login");
                password = t.get("password");
            }
            for (GestionnaireOrganisme a : OrganisationEvenements.getLists().getGestionnaireOrganismeList()) {
                if (login.equals(a.getLogin()) && password.equals(a.getMdp())) {
                    exist = true;
                    ab = a;
                    frame.setVisible(false);
                    new InterfaceGestionnaireOrganisme(ab, nature);
                }
            }
            if (!exist) {
                JOptionPane.showMessageDialog(frame, "Compte Organisateur non trouve, penser a en creer un");
            }
        } else {
            new InterfaceGestionnaireOrganisme(ab, 'c');
        }
        return ab;
    }

}
