package OrganisationEvenements.model;

public class Reservation {
    
    private Evenement evenement;
    private int nbPlaces;
    
    public Reservation(Evenement e, int nbPlaces){
        this.evenement=e;
        this.nbPlaces=nbPlaces;
    } 

    public Evenement getEvenement() {
        return evenement;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }
    
}
