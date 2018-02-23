package OrganisationEvenements.view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.*;

public class InterfaceAbonne extends JFrame{
		
	public InterfaceAbonne(){
		this.design();
		this.setVisible(true);
	}
	
	public void design(){
		this.setTitle("Interface abonne");
		this.setBounds(new Rectangle(0, 0, 900, 500));
		this.setLayout(new BorderLayout());
		
	}
}
