package application;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        ProjetDTO projetDTO = new ProjetDTO(1, "ProjetHyperSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        CompteUsagerTechDTO usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");
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
        //TODO add test pour verifier que l'usager est dans le registre

        proxy.persisterProjet(projetAAssigne.asProjetDTO());
    }
}