package OrganisationEvenements.controller;

import OrganisationEvenements.controller.Lists;
import OrganisationEvenements.view.Accueil;

public class OrganisationEvenements {
	private static Lists lists;
        private static Accueil fenetreAccueil;
	
	public static void main(String[] args) {
		lists = new Lists();
		fenetreAccueil = new Accueil();
	}
	
	public static Lists getLists() {
		return lists;
	}

    public static Accueil getFenetreAccueil() {
        return fenetreAccueil;
    }
        
        
}
