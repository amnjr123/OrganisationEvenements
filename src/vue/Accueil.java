package vue;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Accueil extends JFrame {

    //Declaration panels
    private JFrame frame;
    private JPanel pPrincipal;
    private JPanel pAcces;
    private JScrollPane pConsultation;
    //Declaration Tableau
    private JTable tConsultation;
    //Declaration objets acces
    private JComboBox cbUtilisateur;
    private JButton bAcces;
    private String[] lUtilisateurs = {"Organnisme", "Organisateur", "Abonn�"};
    

    public Accueil() {
        this.design();
        this.setVisible(true);
    }

    public void design() {
        this.setTitle("Accueil");
        this.setBounds(new Rectangle(0, 0, 900, 500));
        this.setLayout(new BorderLayout());
        //Panel principal
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        this.add(pPrincipal, BorderLayout.CENTER);
        //panel Accès
        pAcces = new JPanel();
        pAcces.setBorder(BorderFactory.createTitledBorder("Acc�s"));
        pPrincipal.add(pAcces, BorderLayout.NORTH);
        cbUtilisateur = new JComboBox(lUtilisateurs);
        bAcces = new JButton("Acc�der");
        pAcces.add(cbUtilisateur);
        pAcces.add(bAcces);
        //Panel Consultation
        pConsultation= new JScrollPane();
        pConsultation.setBorder(BorderFactory.createTitledBorder("Liste d'�v�nements"));
        pPrincipal.add(pConsultation, BorderLayout.CENTER);
        //Table consultation
        tConsultation=new JTable();
        this.setLocationRelativeTo(null);
    }

    public JTable gettConsultation() {
        return tConsultation;
    }

    public JComboBox getCbUtilisateur() {
        return cbUtilisateur;
    }

    public JButton getbAcces() {
        return bAcces;
    }

    
    
}
