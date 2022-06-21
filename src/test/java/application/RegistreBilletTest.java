package application;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistreBilletTest {


    TreeMap<Integer, Billet> registreBillet = new TreeMap<>();

    Proxy proxy = new Proxy();

    @Test
    void testAjouterBilletAuRegistreVerifierSizeRegistre() {
        BilletDTO billetDTO = proxy.chercherBilletDTOParId(1);
        Billet nouveauBillet = new Billet(billetDTO);

        registreBillet.put(nouveauBillet.getIdBillet(), nouveauBillet);

        assertEquals(1, registreBillet.size());
    }

    @Test
    void testChercherBilletParIdRetourneBilletDuRegsitre() {
        BilletDTO billetDTO = proxy.chercherBilletDTOParId(1);
        Billet nouveauBillet = new Billet(billetDTO);
        registreBillet.put(nouveauBillet.getIdBillet(), nouveauBillet);
        Billet billet = registreBillet.get(nouveauBillet.getIdBillet());

        assertEquals(nouveauBillet, billet);
    }


}
