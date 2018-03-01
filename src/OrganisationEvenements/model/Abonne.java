package OrganisationEvenements.model;

import java.util.*;

public class Abonne extends Personne {

    private String tel;
    private String email;
    private String adresse;
    private String ville;
    private String region;
    private ArrayList<Evenement> evenement;

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
        evenement = new ArrayList<Evenement>();
    }

    public Abonne(String nom, String prenom, String login, String mdp, String tel, String email, String adresse) {
        super(nom, prenom, login, mdp);
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
        evenement = new ArrayList<Evenement>();
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

    public ArrayList<Evenement> getEvenement() {
        return this.evenement;
    }

    public void setEvenement(ArrayList<Evenement> newEvenement) {
        removeAllEvenement();
        for (Iterator<Evenement> iter = newEvenement.iterator(); iter.hasNext();) {
            addEvenement((Evenement) iter.next());
        }
    }

    public void addEvenement(Evenement newEvenement) {
        if (newEvenement == null) {
            return;
        }
        if (this.evenement == null) {
            this.evenement = new ArrayList<Evenement>();
        }
        if (!this.evenement.contains(newEvenement)) {
            this.evenement.add(newEvenement);
        }
    }

    public void removeEvenement(Evenement oldEvenement) {
        if (oldEvenement == null) {
            return;
        }
        if (this.evenement != null) {
            if (this.evenement.contains(oldEvenement)) {
                this.evenement.remove(oldEvenement);
            }
        }
    }

    public void removeAllEvenement() {
        if (evenement != null) {
            evenement.clear();
        }
    }
}
