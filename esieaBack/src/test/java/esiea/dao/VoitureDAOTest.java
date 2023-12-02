package esiea.dao;

import esiea.metier.Voiture;
import esiea.metier.Voiture.Carburant;
import junit.framework.TestCase;
import java.sql.SQLException;


public class VoitureDAOTest extends TestCase {

    public void testAjouterVoiture() {
        VoitureDAO voitureDAO = new VoitureDAO();

        // créer un objet voiture à tester
        Voiture voiture = createDummyVoiture();

        try {
            // on test la methode ajouterVoiture
            voitureDAO.ajouterVoiture(voiture);

            // verifie qu'on a bien ajouté la voiture
            ReponseVoiture reponse = voitureDAO.rechercherVoitures("DummyBrand", 0, 10);
            Voiture[] voitures = reponse.getData();
            assertNotNull(voitures);
            assertEquals(1, voitures.length);
            assertEquals("DummyBrand", voitures[0].getMarque());
            assertEquals("DummyModel", voitures[0].getModele());
            assertEquals("DummyFinition", voitures[0].getFinition());
            assertEquals(Carburant.DIESEL, voitures[0].getCarburant());
            assertEquals(100000, voitures[0].getKm());
            assertEquals(2010, voitures[0].getAnnee());
            assertEquals(5000, voitures[0].getPrix());

            // check exception
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    public void testRechercherVoitures() {
        VoitureDAO voitureDAO = new VoitureDAO();

        try {
            // teste la methode rechercherVoiture
            ReponseVoiture reponse = voitureDAO.rechercherVoitures("DummySearch", 0, 10);

            // verifie que la reponse est non null et le volume de 0, pas de resultat de recherche
            assertNotNull(reponse);
            assertEquals(0, reponse.getVolume());

            // check exception
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    public void testSupprimerVoiture() {
        VoitureDAO voitureDAO = new VoitureDAO();

        try {
            // test methode supprimerVoiture
            voitureDAO.supprimerVoiture("1");

            // verifie qu'on a bien supprimé la voiture 
            ReponseVoiture reponse = voitureDAO.rechercherVoitures("1", 0, 10);
            Voiture[] voitures = reponse.getData();
            assertNotNull(voitures);
            assertEquals(0, voitures.length);

        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    private Voiture createDummyVoiture() {
        // creer et return l'objet voiture à tester
        Voiture voiture = new Voiture();
        
        voiture.setMarque("DummyBrand");
        voiture.setModele("DummyModel");
        voiture.setId(14);
		voiture.setFinition("DummyFinition");
        voiture.setCarburant(Carburant.DIESEL);
		voiture.setKm(100000);
		voiture.setAnnee(2010);
		voiture.setPrix(5000);
        return voiture;
    }
}
