package application;

import accesPersistence.UsagerTechDAO;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class RegistreUsagerTechTest {
    Proxy proxy = new Proxy();
    TreeMap<Integer, CompteUsagerTech> registreUsagerTech = new TreeMap<>();

    @Test
    void ajouterUsager() {
        CompteUsagerTechDTO compteUsagerTechDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        CompteUsagerTech compteUsagerTech = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.put(compteUsagerTech.getIdUsager(), compteUsagerTech);
        assertEquals(1, registreUsagerTech.size());
    }

    @Test
    void trouverUsagerTech() {
        CompteUsagerTechDTO compteUsagerTechDTO = proxy.chercherCompteUsagerTechDTOParId(1);
        CompteUsagerTech compteUsagerTech = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.put(1, compteUsagerTech);
        CompteUsagerTech usager = registreUsagerTech.get(1);
        assertEquals(compteUsagerTech, usager);
    }
}