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
    private static int dernierNumeroBilletAttribue = 0;


    /**
     * Constructeur par défaut
     */
    public RegistreBillet() {
    }

    /**
     * Getter de l'instance
     */

    public static RegistreBillet getRegistreBilletInstance() {
        if (registreBilletInstance == null) {
            registreBilletInstance = new RegistreBillet();
        }
        return registreBilletInstance;
    }

    /**
     * Ajouter billet au registre
     */
    public int ajouterBilletAuRegistre(Billet nouveauBillet) {
        nouveauBillet.setIdBillet(this.prochainIdBillet());
        this.registreBillet.put(nouveauBillet.getIdBillet(), nouveauBillet);

        return nouveauBillet.getIdBillet();
    }

    /**
     * Récupère un Billet par son Id
     */
    public Billet chercherBilletParId(int idBillet) {
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

    boolean billetExists(int idBillet){
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
  void changerEtatBillet(String[] transitModifications) {
        int idBilletDto = Integer.parseInt(transitModifications[0]);
        String nouvelEtat = transitModifications[1];
        Billet billetTemporaire = chercherBilletParId(idBilletDto);
        billetTemporaire.setEtat(nouvelEtat);
        this.registreBillet.put(billetTemporaire.getIdBillet(), billetTemporaire);

    }

    void consulterEtatBillet(int idBillet) {
        String etat = chercherBilletParId(idBillet).getEtat();
        System.out.println("L'état du billet demandé est: " + etat);
    }

    public void modifierBillet(int id, Billet billetModifiable) {
        this.registreBillet.put(id, billetModifiable);
    }
}
