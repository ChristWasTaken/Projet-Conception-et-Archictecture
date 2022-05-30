package application;

import java.util.ArrayList;

public class RegistreCategories {

    /**
     * Singleton pour gérer les catégories de billet
     */
    private static RegistreCategories instance;
    private ArrayList<CategorieBillet> registreCategories;

    private RegistreCategories() {
        this.registreCategories = new ArrayList<>();
    }

    public static RegistreCategories getRegistreCategorieInstance() {
        if (instance == null) {
            instance = new RegistreCategories();
        }
        return instance;
    }

    /**
     * Ajoute une catégorie de billet
     */
    public void ajouterUneCategorie(String categorieBillet) {

        this.registreCategories.add(new CategorieBillet(categorieBillet));
    }

    /**
     * Retourne la liste des catégories de billet
     *
     * @return ArrayList<CategorieBillet>
     */
    public ArrayList<CategorieBillet> recupererListeCategories() {
        return registreCategories;
    }

    public CategorieBillet recupererCategorie(String categorieBillet) {
        for (CategorieBillet categorie : registreCategories) {
            if (categorie.getCategorie().equals(categorieBillet)) {
                return categorie;
            }
        }
        return null;
    }
}
