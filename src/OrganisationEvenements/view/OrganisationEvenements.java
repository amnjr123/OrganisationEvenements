package OrganisationEvenements.view;

import OrganisationEvenements.controller.Lists;

public class OrganisationEvenements {
	private static Lists lists;
	
	public static void main(String[] args) {
		lists = new Lists();
		new Accueil();
	}
	
	public static Lists getbList() {
		return lists;
	}
}
