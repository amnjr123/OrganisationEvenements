package OrganisationEvenements.model;
import java.util.*;

public class Evenement {
   private String type;
   private String titre;
   private String detailEvenement;
   private String villeConcernee;
   private int quota;
   private String validation;
   
   public Salle salle;
   public Collection<Abonne> abonne;
   public GestionnaireOrganisme gestionnaireOrganisme;
   
   
   
   public Evenement(String type, String titre, String detailEvenement, String villeConcernee, int quota, String validation,
		Salle salle) {
	this.type = type;
	this.titre = titre;
	this.detailEvenement = detailEvenement;
	this.villeConcernee = villeConcernee;
	this.quota = quota;
	this.validation = validation;
	this.salle = salle;
}

public Salle getSalle() {
      return salle;
   }
   
   public void setSalle(Salle newSalle) {
      if (this.salle == null || !this.salle.equals(newSalle))
      {
         if (this.salle != null)
         {
            Salle oldSalle = this.salle;
            this.salle = null;
            oldSalle.removeEvenement(this);
         }
         if (newSalle != null)
         {
            this.salle = newSalle;
            this.salle.addEvenement(this);
         }
      }
   }

}