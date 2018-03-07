package OrganisationEvenements.model;

import java.util.*;

public class Abonne extends Personne {

    private String tel;
    private String email;
    private String adresse;
    private String ville;
    private String region;
    private ArrayList<Reservation> reservation;

    public ArrayList<Reservation> getReservation() {
        return reservation;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVille() {
        return ville;
    }

    public String getRegion() {
        return region;
    }

    public Abonne() {
        super("", "", "", "");
        this.tel = "";
        this.email = "";
        this.adresse = "";
        reservation = new ArrayList<Reservation>();
    }

    public Abonne(String nom, String prenom, String login, String mdp, String tel, String email, String adresse,String ville) {
        super(nom, prenom, login, mdp);
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
        this.ville=ville;
        reservation = new ArrayList<Reservation>();
    }

    public String toString() {
        return super.toString() + "\nAdresse :" + adresse + "\ntel :" + tel + "\nEmail :" + email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
