package application;

public class Categorie {
    private String categorie;

    // Implémentation de la catégorie sous forme d'objet pour
    // options futures.

    public Categorie() {}

    public Categorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Categorie du billet: " + categorie;
    }
}
