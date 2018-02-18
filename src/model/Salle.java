/***********************************************************************
 * Module:  Salle.java
 * Author:  Grind-Machine
 * Purpose: Defines the Class Salle
 ***********************************************************************/

import java.util.*;

/** @pdOid 5800424f-0473-49b5-86dd-b501cc97bb5e */
public class Salle {
   /** @pdOid ff954d56-5349-403a-94a8-e040d0ed8e30 */
   private String nom;
   /** @pdOid 50f3a4e2-50df-4cdb-b2a8-5043b355e78d */
   private String ville;
   /** @pdOid 45e1e97b-25e5-49f8-bf6c-1d1cddb1792b */
   private String region;
   /** @pdOid 75ecfdba-6f29-43ca-be6d-dbddcf757af2 */
   private String adresse;
   /** @pdOid 2f11afd1-83f7-4401-8041-6cc95f2a7679 */
   private int nbPlaces;
   
   /** @pdRoleInfo migr=no name=Evenement assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Evenement> evenement;
   /** @pdRoleInfo migr=no name=GestionnaireOrganisme assc=cree mult=0..* side=A */
   public GestionnaireOrganisme[] gestionnaireOrganisme;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Evenement> getEvenement() {
      if (evenement == null)
         evenement = new java.util.HashSet<Evenement>();
      return evenement;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEvenement() {
      if (evenement == null)
         evenement = new java.util.HashSet<Evenement>();
      return evenement.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEvenement */
   public void setEvenement(java.util.Collection<Evenement> newEvenement) {
      removeAllEvenement();
      for (java.util.Iterator iter = newEvenement.iterator(); iter.hasNext();)
         addEvenement((Evenement)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEvenement */
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
   
   /** @pdGenerated default remove
     * @param oldEvenement */
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
   
   /** @pdGenerated default removeAll */
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