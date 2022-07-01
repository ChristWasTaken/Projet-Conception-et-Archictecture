package application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjetTest {
    private final Proxy proxy = new Proxy();
    RegistreUsagerTechAssigne registreUsagerTechAssigne = new RegistreUsagerTechAssigne();

    @Test
    void testAjouterUsagerAuRegistreUsagerTechAssigneRetournTrue() {
        CompteUsagerTechDTO compteUsagerTechDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        CompteUsagerTech compteUsagerTech = new CompteUsagerTech(compteUsagerTechDTO);
        assertTrue(registreUsagerTechAssigne.ajouterUsager(compteUsagerTech));
    }
}