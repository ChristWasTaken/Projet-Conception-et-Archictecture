package application;

import java.util.ArrayList;

public class RegistreCategories {

    private ArrayList<Categorie> registreCategories;

    public RegistreCategories() {
        this.registreCategories = new ArrayList<>();
    }

     /**
     * Ajoute une catégorie de billet
     */
    public void ajouterUneCategorie(String categorieBillet) {

        this.registreCategories.add(new Categorie(categorieBillet));
    }

    /**
     * Retourne la liste des catégories de billet
     *
     * @return ArrayList<CategorieBillet>
     */
    public ArrayList<Categorie> recupererListeCategories() {
        return registreCategories;
    }

    public Categorie recupererCategorie(String categorieBillet) {
        for (Categorie categorie : registreCategories) {
            if (categorie.getCategorie().equals(categorieBillet)) {
                return categorie;
            }
        }
        return null;
    }


}
