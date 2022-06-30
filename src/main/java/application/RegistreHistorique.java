package application;

import java.util.TreeMap;

public class RegistreHistorique {
    private TreeMap<Integer, Historique> registreHistorique =  new TreeMap<>();

    /**
     * Dernier numéro attribué à un historique.
     */
    private static int dernierNumeroHistoriqueAttribue = 0;


    /**
     * Constructeur
     */
    public RegistreHistorique() {
    }

    /**
     * Getters and setters
     */

    public TreeMap<Integer, Historique> getRegistreHistorique() {
        return registreHistorique;
    }

    public void setRegistreHistorique(TreeMap<Integer, Historique> registreHistorique) {
        this.registreHistorique = registreHistorique;
    }

    /**
     * Méthode pour Ajouter historique au registre
     * @param historique
     * @return le id de l'historique
     */
    public int ajouterHistoriqueAuRegistre(Historique historique){
        historique.setIdHistorique(this.prochainIdHistorique());
        this.registreHistorique.put(historique.getIdHistorique(), historique);
        return historique.getIdHistorique();
    }


    /**
     * Récupère un historique par son Id
     * @param idHistorique
     * @return historique
     */
    public Historique chercherParNumero(int idHistorique) {
        return this.registreHistorique.get(idHistorique);
    }

    /**
     * incrémentation automatique du IDHistorique
     * @return le nouvel id
     */
    private int prochainIdHistorique() {
        return ++dernierNumeroHistoriqueAttribue;
    }


    public TreeMap afficherRegistreHistorique() {
        return registreHistorique;
    }


    public void modifierRegistreHistorique(){

    }

    @Override
    public String toString() {
        return "RegistreHistorique{"  + "\n"+ registreHistorique  +
                '}';
    }
}
