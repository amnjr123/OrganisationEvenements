/***********************************************************************
 * Module:  Abonne.java
 * Author:  Grind-Machine
 * Purpose: Defines the Class Abonne
 ***********************************************************************/

import java.util.*;

/** @pdOid 1efa40ca-3b39-46e0-be72-6bd9f0bc9c45 */
public class Abonne extends Personne {
   /** @pdOid c3934ae6-bc52-4090-bfd0-e22174bc6b45 */
   private String tel;
   /** @pdOid a89f8d15-c7fd-45ab-b0b0-1fdc91ce68c2 */
   private String email;
   /** @pdOid 8af85579-bf6f-476d-b7a9-6aab04891df3 */
   private String adresse;
   
   /** @pdRoleInfo migr=no name=Evenement assc=reserve coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Evenement> evenement;
   
   
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
         this.evenement.add(newEvenement);
   }
   
   /** @pdGenerated default remove
     * @param oldEvenement */
   public void removeEvenement(Evenement oldEvenement) {
      if (oldEvenement == null)
         return;
      if (this.evenement != null)
         if (this.evenement.contains(oldEvenement))
            this.evenement.remove(oldEvenement);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllEvenement() {
      if (evenement != null)
         evenement.clear();
   }

}