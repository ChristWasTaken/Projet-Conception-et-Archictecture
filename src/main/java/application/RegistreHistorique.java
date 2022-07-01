package application;

import java.util.TreeMap;

public class RegistreHistorique {
    private static TreeMap<Integer, Historique> registreHistorique = new TreeMap<>();

    //Dernier numéro attribué à un historique.
    private static int dernierNumeroHistoriqueAttribue = 0;

    //Constructeur
    public RegistreHistorique() {
    }

    //Getters and setters

    public static TreeMap<Integer, Historique> getInstance() {
        return registreHistorique;
    }

    /**
     * incrémentation automatique du IDHistorique
     *
     * @return le nouvel id
     */
    private int prochainIdHistorique() {
        return ++dernierNumeroHistoriqueAttribue;
    }

    /**
     * Méthode pour Ajouter historique au registre
     *
     * @param historique le historique à ajouter
     * @return le id de l'historique
     */
    public int ajouterHistoriqueAuRegistre(Historique historique) {
        historique.setIdHistorique(this.prochainIdHistorique());
        registreHistorique.put(historique.getIdHistorique(), historique);
        return historique.getIdHistorique();
    }

    /**
     * Récupère un historique par son Id
     *
     * @param idHistorique l'id de l'historique à récupérer
     * @return historique
     */
    public Historique chercherParNumero(int idHistorique) {
        return this.registreHistorique.get(idHistorique);
    }

    public TreeMap<Integer, Historique> afficherRegistreHistorique() {
        return registreHistorique;
    }

    public void modifierRegistreHistorique() {
    }

    @Override
    public String toString() {
        return "RegistreHistorique{" + "\n" + registreHistorique +
                '}';
    }
}
