package application;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistreBilletTest {


    TreeMap<Integer, Billet> registreBillet = new TreeMap<>();

    Proxy proxy = new Proxy();

    @Test
    void testAjouterBilletAuRegistreVerifierSizeRegistre() {
        BilletDTO billetDTO = proxy.chercherBilletDTOParId(2);
        Billet nouveauBillet = new Billet(billetDTO);

        registreBillet.put(nouveauBillet.getIdBillet(), nouveauBillet);

        assertEquals(1, registreBillet.size());
    }
}
