package coordonnateur;

import application.ProjetDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CoordonnateurTest {

    @Test
    void definirCategorie() {
        ProjetDTO projetDTO = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        String categorieBillet = "Anomalie";
        Coordonnateur coordonnateur = new Coordonnateur();

        coordonnateur.definirCategorie(projetDTO, categorieBillet);
        assertEquals(categorieBillet, projetDTO.getCategoriesBillet().get(0).getCategorie());
        assertEquals(1, projetDTO.getCategoriesBillet().size());

    }
}