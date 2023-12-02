package esiea.metier;

import junit.framework.TestCase;

public class VoitureTest extends TestCase {

    public void testCheckValidVoiture() {
        // creer voiture valide
        Voiture voiture = createValidVoiture();

        // on test la methode check
        boolean result = voiture.check();

        // verifie que la methode renvoie bien true
        assertTrue("Valid Voiture should return true from check method", result);
    }

    public void testCheckInvalidVoiture() {
        // creer une voiture non valide 
        Voiture voiture = createInvalidVoiture();

        // on teste la methode check
        boolean result = voiture.check();

        // on verifie qu'elle renvoie false pour la voiture non valide
        assertFalse("Voiture with negative id should return false from check method", result);
    }

    public void testGetTypeDonnee() {
        String typeMarque = Voiture.getTypeDonnee("marque");
        String typeModele = Voiture.getTypeDonnee("modele");
        String typeFinition = Voiture.getTypeDonnee("finition");
        String typeId = Voiture.getTypeDonnee("id");
        String typeAnnee = Voiture.getTypeDonnee("annee");
        String typeKm = Voiture.getTypeDonnee("km");
        String typePrix = Voiture.getTypeDonnee("prix");
        String invalidType = Voiture.getTypeDonnee("invalidAttribute");
    
        assertEquals("getTypeDonnee should return 'string' for attribute 'marque'", "string", typeMarque);
        assertEquals("getTypeDonnee should return 'string' for attribute 'modele'", "string", typeModele);
        assertEquals("getTypeDonnee should return 'string' for attribute 'finition'", "string", typeFinition);
        assertEquals("getTypeDonnee should return 'entier' for attribute 'id'", "entier", typeId);
        assertEquals("getTypeDonnee should return 'entier' for attribute 'annee'", "entier", typeAnnee);
        assertEquals("getTypeDonnee should return 'entier' for attribute 'km'", "entier", typeKm);
        assertEquals("getTypeDonnee should return 'entier' for attribute 'prix'", "entier", typePrix);
        assertEquals("getTypeDonnee should return an empty string for invalid attribute", "", invalidType);
    }
    
    


    private Voiture createValidVoiture() {
        // creer et renvoie une voiture valide
        Voiture voiture = new Voiture();
        // Set attributes of the valid voiture
        voiture.setId(1);
        voiture.setMarque("ValidBrand");
        voiture.setModele("ValidModel");
        voiture.setFinition("ValidFinition");
        voiture.setCarburant(Voiture.Carburant.DIESEL);
        voiture.setKm(10000);
        voiture.setAnnee(2020);
        voiture.setPrix(25000);
        return voiture;
    }

    private Voiture createInvalidVoiture() {
        // creer et renvoie une voiture non valide
        Voiture voiture = new Voiture();
        // il manque les attributs requis
        return voiture;
    }
}
