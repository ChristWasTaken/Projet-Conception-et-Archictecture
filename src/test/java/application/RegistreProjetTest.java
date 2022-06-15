package application;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class RegistreProjetTest {
    Proxy proxy = new Proxy();
    TreeMap<Integer, Projet> registreProjet = new TreeMap<>();


    @Test
    void testAjouterProjetAuRegistreVerifieSizeRegistre() {
        ProjetDTO projetDTO = proxy.chercherProjetDTOParId(1);
        Projet nouveauProjet = new Projet(projetDTO);

        registreProjet.put(nouveauProjet.getIdProjet(), nouveauProjet);

        assertEquals(1, registreProjet.size());
    }

    @Test
    void testTrouverProjetRetourneProjetDansRegsitre() {
        ProjetDTO projetDTO = proxy.chercherProjetDTOParId(1);
        Projet nouveauProjet = new Projet(projetDTO);
        registreProjet.put(nouveauProjet.getIdProjet(), nouveauProjet);
        Projet projet = registreProjet.get(nouveauProjet.getIdProjet());

        assertEquals(nouveauProjet, projet);
    }
}