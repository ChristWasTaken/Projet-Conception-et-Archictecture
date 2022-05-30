package application;

public class CategorieBillet {
    String categorie;

    public CategorieBillet() {
    }

    public CategorieBillet(String categorie) {
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
