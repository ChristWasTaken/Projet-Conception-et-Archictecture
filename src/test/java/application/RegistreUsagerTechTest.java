package application;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class RegistreUsagerTechTest {
    private final Proxy proxy = new Proxy();
    TreeMap<Integer, CompteUsagerTech> registreUsagerTech = new TreeMap<>();

    @Test
    void testAjouterUsagerVerifieSizeRegistre() {
        CompteUsagerTechDTO compteUsagerTechDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        CompteUsagerTech compteUsagerTech = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.put(compteUsagerTech.getIdUsager(), compteUsagerTech);
        assertEquals(1, registreUsagerTech.size());
    }

    @Test
    void testTrouverUsagerTechRetourneUsagerDansRegistre() {
        CompteUsagerTechDTO compteUsagerTechDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        CompteUsagerTech compteUsagerTech = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.put(1, compteUsagerTech);
        CompteUsagerTech usager = registreUsagerTech.get(1);
        assertEquals(compteUsagerTech, usager);
    }
}