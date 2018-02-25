package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;

import OrganisationEvenements.model.GestionnaireOrganisme;

public class InterfaceGestionnaireOrganisme extends JFrame {
	
	public InterfaceGestionnaireOrganisme(GestionnaireOrganisme gO) {
		this.design(gO);
	}

	public void design(GestionnaireOrganisme o) {
		this.setTitle("Interface gestionnaire organisme");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
