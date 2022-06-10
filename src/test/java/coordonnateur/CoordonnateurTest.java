package coordonnateur;

import application.BilletDTO;
import application.CompteUsagerTechDTO;
import application.ProjetDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CoordonnateurTest {

    Coordonnateur coordonnateur = new Coordonnateur();

    @Test
    void definirCategorieDeBilletDansListeDeCategorie() {
        ProjetDTO projetDTO = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        String categorieBillet = "Anomalie";

        coordonnateur.definirCategorieDeBillet(projetDTO, categorieBillet);
        assertEquals(categorieBillet, projetDTO.getCategoriesBillet().get(0).getCategorie());
        assertEquals(1, projetDTO.getCategoriesBillet().size());

    }

    @Test
    void assignerBilletAUsagerTech() {
        CompteUsagerTechDTO usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");
        BilletDTO billetDTO = new BilletDTO(1, "BilletTopSecret", "hebdo", "billet@test.ca",
                "Corriger les Classes Blob!!", "Blobs are bad mmkay!", LocalDate.of(2022,05,28));

        coordonnateur.assignerBilletAUsagerTech(billetDTO, usagerDTO);

        assertEquals(usagerDTO.getIdUsager(), billetDTO.getIdUsagerTechAssigne());

        assertEquals(billetDTO.getRegistreHistorique().chercherParNumero(1).getUsagerTechAssigne(),
                usagerDTO.getIdUsager());

    }
}