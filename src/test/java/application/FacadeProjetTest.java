package application;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FacadeProjetTest {

    @Test
    void testCreerProjetAvecUnProjetDTO() {
        RegistreProjet registreProjet = RegistreProjet.getInstance();
        Proxy proxy = new Proxy();
        ProjetDTO projetDTO = new ProjetDTO(1, "ProjetHyperSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));

        Projet nouveauProjet = new Projet(projetDTO);

        registreProjet.ajouterProjet(nouveauProjet);

        proxy.persisterNouveauProjet(projetDTO);

        ProjetDTO projetTest = proxy.chercherProjetDTOParId(1);

        assertEquals(projetDTO, projetTest);
    }

    @Test
    void ajouterCategorie() {
    }

    @Test
    void assignerUsagerTech() {
    }
}