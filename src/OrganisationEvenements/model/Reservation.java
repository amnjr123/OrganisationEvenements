/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganisationEvenements.model;

/**
 *
 * @author Amine
 */
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
