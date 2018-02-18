import java.util.*;

public class Salle {
   private String nom;
   private String ville;
   private String region;
   private String adresse;
   private int nbPlaces;
   
   public java.util.Collection<Evenement> evenement;
   public GestionnaireOrganisme[] gestionnaireOrganisme;
   
   
   public java.util.Collection<Evenement> getEvenement() {
      if (evenement == null)
         evenement = new java.util.HashSet<Evenement>();
      return evenement;
   }
   
   public java.util.Iterator getIteratorEvenement() {
      if (evenement == null)
         evenement = new java.util.HashSet<Evenement>();
      return evenement.iterator();
   }
   
   public void setEvenement(java.util.Collection<Evenement> newEvenement) {
      removeAllEvenement();
      for (java.util.Iterator iter = newEvenement.iterator(); iter.hasNext();)
         addEvenement((Evenement)iter.next());
   }
   
   public void addEvenement(Evenement newEvenement) {
      if (newEvenement == null)
         return;
      if (this.evenement == null)
         this.evenement = new java.util.HashSet<Evenement>();
      if (!this.evenement.contains(newEvenement))
      {
         this.evenement.add(newEvenement);
         newEvenement.setSalle(this);      
      }
   }
   
   public void removeEvenement(Evenement oldEvenement) {
      if (oldEvenement == null)
         return;
      if (this.evenement != null)
         if (this.evenement.contains(oldEvenement))
         {
            this.evenement.remove(oldEvenement);
            oldEvenement.setSalle((Salle)null);
         }
   }
   
   public void removeAllEvenement() {
      if (evenement != null)
      {
         Evenement oldEvenement;
         for (java.util.Iterator iter = getIteratorEvenement(); iter.hasNext();)
         {
            oldEvenement = (Evenement)iter.next();
            iter.remove();
            oldEvenement.setSalle((Salle)null);
         }
      }
   }

}