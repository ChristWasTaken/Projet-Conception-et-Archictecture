package application;

import java.util.TreeMap;

public class RegistreBillet {


    /**
     * Instance unique.
     */
    private static RegistreBillet registreBilletInstance = new RegistreBillet();


    /**
     * Registre des clients indexé par numéro.
     */
    private TreeMap<Integer, Billet> registreBillet = new TreeMap<>();

    /**
     * Dernier numéro attribué à un billet.
     */
    private int dernierNumeroBilletAttribue = 0;


    /**
     * Constructeur par défaut
     */
    public RegistreBillet() {
    }

    /**
     * Getter de l'instance
     */

    public static RegistreBillet getInstance() {
        if (registreBilletInstance == null) {
            registreBilletInstance = new RegistreBillet();
        }
        return registreBilletInstance;
    }

    /**
     * Enregistre le billet
     */
    public int ajouterBilletAuRegistre(Billet nouveauBillet) {
        nouveauBillet.setIdBillet(this.prochainIdBillet());
        this.registreBillet.put(nouveauBillet.getIdBillet(), nouveauBillet);

        return nouveauBillet.getIdBillet();
    }

    /**
     * Récupère un Billet par son Id
     */
    public Billet chercherParNumero(int idBillet) {
        return this.registreBillet.get(idBillet);
    }

    /**
     * incrémentation automatique du IDBillet
     */
    private int prochainIdBillet() {
        return ++dernierNumeroBilletAttribue;
    }


    public TreeMap afficherRegistreBillet() {

        return registreBillet;
    }
}
