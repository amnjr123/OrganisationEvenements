/***********************************************************************
 * Module:  Evenement.java
 * Author:  Grind-Machine
 * Purpose: Defines the Class Evenement
 ***********************************************************************/

import java.util.*;

/** @pdOid 8b4d5330-0975-4bbd-ae27-45591d445743 */
public class Evenement {
   /** @pdOid c95d323f-c207-4ac2-b551-bac30f5db179 */
   private String type;
   /** @pdOid 09d9330f-49f5-4197-bf74-f12cda0008b1 */
   private String titre;
   /** @pdOid ebd68259-4213-4be8-992f-36cddb92d7a2 */
   private String detailEvenement;
   /** @pdOid 9d34b0e3-a000-4ab2-a72b-2cb0b2a98aac */
   private String villeConcernee;
   /** @pdOid 2ef989b1-c776-4f70-a5c4-cf8eca93908a */
   private int quota;
   /** @pdOid a2be69b9-4b78-4ae2-a993-1e0d460cf98f */
   private String validation;
   
   /** @pdRoleInfo migr=no name=Salle assc=association1 mult=1..1 side=A */
   public Salle salle;
   /** @pdRoleInfo migr=no name=Organisateur assc=gere mult=1..1 side=A */
   public Organisateur organisateur;
   /** @pdRoleInfo migr=no name=Abonne assc=reserve mult=0..* side=A */
   public Abonne[] abonne;
   /** @pdRoleInfo migr=no name=GestionnaireOrganisme assc=valide mult=0..* side=A */
   public GestionnaireOrganisme[] gestionnaireOrganisme;
   
   
   /** @pdGenerated default parent getter */
   public Salle getSalle() {
      return salle;
   }
   
   /** @pdGenerated default parent setter
     * @param newSalle */
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