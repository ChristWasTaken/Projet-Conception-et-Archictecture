package application;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FacadeProjetTest {
    RegistreProjet registreProjet = RegistreProjet.getInstance();
    Proxy proxy = new Proxy();
    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
    FacadeProjet facadeProjet = new FacadeProjet();

    @Test
    @Order(1)
    void testCreerProjetAvecUnProjetDTO() {
        ProjetDTO projetDTO = new ProjetDTO(1, "ProjetHyperSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));

        Projet nouveauProjet = new Projet(projetDTO);
        assertEquals(nouveauProjet.getIdProjet(), projetDTO.getIdProjet());
        assertEquals(nouveauProjet.getNomProjet(), projetDTO.getNomProjet());

        registreProjet.ajouterProjet(nouveauProjet);
        assertEquals(registreProjet.trouverProjet(nouveauProjet.getIdProjet()), nouveauProjet);

        proxy.persisterProjet(projetDTO);

        ProjetDTO projetTest = proxy.chercherProjetDTOParId(1);

        assertEquals(projetDTO, projetTest);
    }

    @Test
    @Order(2)
    void ajouterUneCategorieAUnProjetExistant() {
        ProjetDTO projetExistant = facadeProjet.consulterUnProjetDTOParId(1);
        projetExistant.ajouterCategorieBillet(new Categorie("Anomalie"));
        assertTrue(facadeProjet.ajouterCategorie(projetExistant));
        assertEquals("Anomalie", facadeProjet.consulterUnProjetDTOParId(1).getListeCategories().get(0).getCategorie());
        assertEquals(1, facadeProjet.consulterUnProjetDTOParId(1).getListeCategories().size());
    }

    @Test
    @Order(3)
    void ajouterUneCategorieAUnProjetNonExistant() {
        ProjetDTO projetExistant = facadeProjet.consulterUnProjetDTOParId(1);
        projetExistant.setIdProjet(10);
        projetExistant.ajouterCategorieBillet(new Categorie("Anomalie"));
        assertFalse(facadeProjet.ajouterCategorie(projetExistant));
    }

    @Test
    @Order(4)
    void testAssignerUsagerTechAvecProjetDTOUsagerDTO() {
        ProjetDTO projetDTO = proxy.chercherProjetDTOParId(1);
        CompteUsagerTechDTO usagerDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        assertEquals(1, projetDTO.getIdProjet());
        assertEquals(1, usagerDTO.getIdUsager());

        facadeCompteUsager.creerCompteUsagerTech(usagerDTO);
        facadeProjet.creerProjet(projetDTO);

        CompteUsagerTech usagerAAssigne = registreUsagerTech.trouverUsagerTech(usagerDTO.getIdUsager());
        assertEquals(usagerAAssigne.getIdUsager(), usagerDTO.getIdUsager());
        assertEquals(usagerAAssigne.getNomUsager(), usagerDTO.getNomUsager());
        assertEquals(usagerAAssigne.getCourriel(), usagerDTO.getCourriel());

        Projet projetAAssigne = registreProjet.trouverProjet(projetDTO.getIdProjet());
        assertEquals(projetDTO.getIdProjet(), projetAAssigne.getIdProjet());
        assertEquals(projetDTO.getNomProjet(), projetAAssigne.getNomProjet());

        projetAAssigne.ajouterUsagerAuRegistre(usagerAAssigne);
        projetAAssigne.getRegistreUsagerTechAssigne().afficherUsager();

        proxy.persisterProjet(projetAAssigne.asProjetDTO());
        assertNotEquals(projetDTO, proxy.chercherProjetDTOParId(1));
    }
}