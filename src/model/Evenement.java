import java.util.*;

public class Evenement {
   private String type;
   private String titre;
   private String detailEvenement;
   private String villeConcernee;
   private int quota;
   private String validation;
   
   public Salle salle;
   public Organisateur organisateur;
   public Abonne[] abonne;
   public GestionnaireOrganisme[] gestionnaireOrganisme;
   
   
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