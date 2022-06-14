package application;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FacadeProjetTest {
    RegistreProjet registreProjet = RegistreProjet.getInstance();
    Proxy proxy = new Proxy();
    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
    FacadeProjet facadeProjet = new FacadeProjet();

    @Test
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
    void ajouterCategorie() {
    }

    @Test
    void TestAssignerUsagerTechAvecProjetDTOUsagerDTO() {
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