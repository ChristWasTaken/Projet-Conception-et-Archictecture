package coordonnateur;

import application.*;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class CoordonnateurTest {

    Coordonnateur coordonnateur = new Coordonnateur();


    @Test
    void definirUneNouvelleCategorieDeBilletDansUnProjetExistant() {
        ProjetDTO projetExistant = coordonnateur.consulterUnProjetDTOParId(1);
        String categorieBillet = "Anomalie";

        assertTrue(coordonnateur.definirCategorieDeBillet(projetExistant, categorieBillet));
        assertEquals(categorieBillet, coordonnateur.consulterUnProjetDTOParId(1).getListeCategories().get(0).getCategorie());
        assertEquals(1, coordonnateur.consulterUnProjetDTOParId(1).getListeCategories().size());
    }

    @Test
    void definirUneCategorieEnDoublonDansUnProjetExistant() {
        ProjetDTO projetExistant = coordonnateur.consulterUnProjetDTOParId(1);
        String categorieBillet = "Anomalie";
        coordonnateur.definirCategorieDeBillet(projetExistant, categorieBillet);

        assertTrue(coordonnateur.definirCategorieDeBillet(projetExistant, categorieBillet));
//        assertEquals(categorieBillet, coordonnateur.consulterUnProjetDTOParId(1).getListeCategories().get(0).getCategorie());
//        assertEquals(1, coordonnateur.consulterUnProjetDTOParId(1).getListeCategories().size());
    }

    @Test
    void definirUneNouvelleCategorieDeBilletDansUnProjetNonExistant() {
        ProjetDTO projetExistant = coordonnateur.consulterUnProjetDTOParId(2);
        projetExistant.setIdProjet(5);
        String categorieBillet = "Anomalie";
        assertFalse(coordonnateur.definirCategorieDeBillet(projetExistant, categorieBillet));
    }

    @Test
    void assignerBilletAUsagerTech() {
        CompteUsagerTechDTO usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");
        BilletDTO billetDTO = new BilletDTO(1, "BilletTopSecret", "hebdo", "billet@test.ca",
                "Corriger les Classes Blob!!", "Blobs are bad mmkay!", LocalDate.of(2022,05,28));
//        CommonDAO commonDAO = CommonDAOProxy.getInstance();

        coordonnateur.assignerBilletAUsagerTech(billetDTO, usagerDTO);

        assertEquals(usagerDTO.getIdUsager(), billetDTO.getIdUsagerTechAssigne());

        assertEquals(billetDTO.getRegistreHistorique().chercherParNumero(1).getUsagerTechAssigne(),
                usagerDTO.getIdUsager());

    }
}