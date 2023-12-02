package esiea.dao;

import esiea.metier.Voiture;
import junit.framework.TestCase;

public class ReponseVoitureTest extends TestCase {

    public void testGetData() {
        ReponseVoiture reponse = new ReponseVoiture();

        // Teste le cas où les données sont null
        assertNull(reponse.getData());

        // Teste le cas où les données sont définies
        Voiture[] data = {new Voiture(), new Voiture()};
        reponse.setData(data);
        assertEquals(data, reponse.getData());
    }

    public void testSetData() {
        ReponseVoiture reponse = new ReponseVoiture();
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();

        // Teste ajout d'une voiture
        reponse.setData(voiture1, 0);
        assertEquals(voiture1, reponse.getData()[0]);

        // Teste ajout de plusieurs voitures
        reponse.setData(voiture2, 1);
        assertEquals(voiture2, reponse.getData()[1]);
    }

    public void testGetVolume() {
        ReponseVoiture reponse = new ReponseVoiture();

        // Teste le cas où le volume est 0 par défaut
        assertEquals(0, reponse.getVolume());

        // Teste le cas où le volume est défini
        reponse.setVolume(5);
        assertEquals(5, reponse.getVolume());
    }

    public void testTestGetData() {
    }

    public void testTestGetVolume() {
    }
}
