/***********************************************************************
 * Module:  Organisateur.java
 * Author:  Grind-Machine
 * Purpose: Defines the Class Organisateur
 ***********************************************************************/

import java.util.*;

/** @pdOid 32a6d6c9-24aa-41e9-8b55-be27f8b72491 */
public class Organisateur extends Personne {
   /** @pdOid a8034730-7d57-417b-8e47-196115acfd5f */
   private String adresse;
   /** @pdOid 9e6ec9ef-425e-42c8-abbb-e613d7499b3c */
   private String tel;
   /** @pdOid 40764ff8-2826-4c10-9359-6c0b3035995d */
   private String email;
   
   /** @pdRoleInfo migr=no name=Evenement assc=gere mult=1..* */
   public Evenement[] evenement;

}