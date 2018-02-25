package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.*;

import OrganisationEvenements.model.Organisateur;

public class InterfaceOrganisateur extends JFrame {

	public InterfaceOrganisateur(Organisateur o) {
		this.design(o);
	}

	public void design(Organisateur o) {
		this.setTitle("Interface abonne");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
