package application;

import accesPersistence.FacadePersistence;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {
    private FacadePersistence facadePersistence = new FacadePersistence();
    private Proxy proxy = new Proxy();

    @Test
    void testPersisterProjetVerifieEqualsAvecProjetChercherAvecMemeId() {
        ProjetDTO projet = new ProjetDTO(4, "ProjetHyperSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        facadePersistence.persisterProjet(projet);
        ProjetDTO projectTest = facadePersistence.chercherProjetDTOParId(4);
        assertEquals(projectTest, projet);
    }

    @Test
    void testChercherProjetDTOParIdCheckLeProjetTrouverALeMemeId() {
        ProjetDTO projet = facadePersistence.chercherProjetDTOParId(2);
        assertEquals(2, projet.getIdProjet());
    }

    @Test
    void testChercherProjetNonExistantDeLaPersistanceRetourneProjetNull(){
        ProjetDTO projet = facadePersistence.chercherProjetDTOParId(15);
        assertEquals(null, projet);
    }

    @Test
    void testPersisterCompteUsagerTechVerifieEqualsAvecUsagerChercherAvecMemeId() {
        CompteUsagerTechDTO usager = new CompteUsagerTechDTO(4,"Roger","mdp","email");
        facadePersistence.persisterCompteUsagerTech(usager);
        CompteUsagerTechDTO usagerTest = facadePersistence.chercherCompteUsagerTechDTOParId(usager.getIdUsager());
        assertEquals(usagerTest, usager);
    }

    @Test
    void testChercherCompteUsagerTechDTOParIdCheckUsagerTrouverALeMemeId() {
        CompteUsagerTechDTO usager = facadePersistence.chercherCompteUsagerTechDTOParId(3);
        assertEquals(3, usager.getIdUsager());
    }

    @Test
    void testChercherCompteUsagerTechDTOParIdNonExistantRetournUserNull(){
        CompteUsagerTechDTO usager = facadePersistence.chercherCompteUsagerTechDTOParId(13);
        assertEquals(null, usager);
    }

    @Test
    void modifierUnProjetExistantAvecUneNouvelleCategorie() {
        ProjetDTO projet = proxy.chercherProjetDTOParId(1);
        projet.ajouterCategorieBillet(new Categorie("Anomalie"));
        assertEquals("Anomalie",proxy.modifierUnProjet(projet).getListeCategories().get(0).getCategorie());
    }

    @Test
    void modifierUnProjetExistantAvecUneNCategorieExistante() {
        ProjetDTO projet = proxy.chercherProjetDTOParId(1);
        projet.ajouterCategorieBillet(new Categorie("Anomalie"));
        assertEquals("Anomalie",proxy.modifierUnProjet(projet).getListeCategories().get(0).getCategorie());
        assertEquals("Anomalie",proxy.modifierUnProjet(projet).getListeCategories().get(0).getCategorie());
        System.out.println(proxy.chercherProjetDTOParId(1).getListeCategories());

    }
}