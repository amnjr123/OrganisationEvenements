package OrganisationEvenements.model;

public class Evenement {

    private String type;
    private String titre;
    private String detailEvenement;
    private String villeConcernee;
    private int quota;
    private String validation;

    private Salle salle;
    private Organisateur organisateur;

    public GestionnaireOrganisme gestionnaireOrganisme;

    public Evenement(String type, String titre, String detailEvenement, String villeConcernee, int quota, Organisateur o) {
        this.type = type;
        this.titre = titre;
        this.detailEvenement = detailEvenement;
        this.villeConcernee = villeConcernee;
        this.quota = quota;
        this.validation = "En cours";
        this.organisateur = o;
    }

    public Evenement(String type, String titre, String detailEvenement, String villeConcernee, int quota) {
        this.type = type;
        this.titre = titre;
        this.detailEvenement = detailEvenement;
        this.villeConcernee = villeConcernee;
        this.quota = quota;
        this.validation = "En cours";
    }

    public Evenement(String type, String titre, String detailEvenement, String villeConcernee, int quota, Salle salle) {
        this.type = type;
        this.titre = titre;
        this.detailEvenement = detailEvenement;
        this.villeConcernee = villeConcernee;
        this.quota = quota;
        this.validation = "En cours";
        this.salle = salle;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDetailEvenement() {
        return detailEvenement;
    }

    public void setDetailEvenement(String detailEvenement) {
        this.detailEvenement = detailEvenement;
    }

    public String getVilleConcernee() {
        return villeConcernee;
    }

    public void setVilleConcernee(String villeConcernee) {
        this.villeConcernee = villeConcernee;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public GestionnaireOrganisme getGestionnaireOrganisme() {
        return gestionnaireOrganisme;
    }

    public void setGestionnaireOrganisme(GestionnaireOrganisme gestionnaireOrganisme) {
        this.gestionnaireOrganisme = gestionnaireOrganisme;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle newSalle) {
        if (this.salle == null || !this.salle.equals(newSalle)) {
            if (this.salle != null) {
                Salle oldSalle = this.salle;
                this.salle = null;
                oldSalle.removeEvenement(this);
            }
            if (newSalle != null) {
                this.salle = newSalle;
                this.salle.addEvenement(this);
            }
        }
    }

}
