package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.*;

import OrganisationEvenements.model.Abonne;

public class InterfaceAbonne extends JFrame {

	
	public InterfaceAbonne(Abonne a) {
		this.design(a);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void design(Abonne a) {
		this.setTitle("Interface abonne");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new BorderLayout());
		
		
		
		
		this.setLocationRelativeTo(null);

	}
}
