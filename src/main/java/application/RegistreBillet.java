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

    public boolean billetExists(int idBillet){
        try {
            this.registreBillet.get(idBillet);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * @param transitModifications contient le id du billet à changer à la position 0
     * et le String du nouvel état à assigner au billet.
     */
    public void changerEtatBillet(String[] transitModifications) {
        int idBilletDto = Integer.parseInt(transitModifications[0]);
        String nouvelEtat = transitModifications[1];
        Billet billetTemporaire = chercherParNumero(idBilletDto);
        billetTemporaire.setEtat(nouvelEtat);
        this.registreBillet.put(billetTemporaire.getIdBillet(), billetTemporaire);

    }
}
