package esiea.api;
import org.json.JSONObject;

import junit.framework.TestCase;

public class VoitureAPITest extends TestCase {

    public void testAjouterVoiture() {
        // Crée une instance de VoitureAPI
        VoitureAPI voitureAPI = new VoitureAPI();

        // Crée un objet json pour test
        JSONObject jsonSimule = new JSONObject();

        // Appel la méthode a tester
        String resultat = voitureAPI.ajouterVoiture(jsonSimule.toString());

        //  vérifie le résultat
        assertEquals("Résultat attendu", resultat);

    }
}
