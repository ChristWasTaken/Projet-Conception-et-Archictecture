package application;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ProjetTest {
    Proxy proxy = new Proxy();
    RegistreUsagerTechAssigne registreUsagerTechAssigne = new RegistreUsagerTechAssigne();


    @Test
    void testAjouterUsagerAuRegistreUsagerTechAssigneRetournTrue() {
        CompteUsagerTechDTO compteUsagerTechDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        CompteUsagerTech compteUsagerTech = new CompteUsagerTech(compteUsagerTechDTO);
        assertTrue(registreUsagerTechAssigne.ajouterUsager(compteUsagerTech));
    }
}