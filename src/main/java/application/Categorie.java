package application;

class Categorie {
    private String categorie;

    protected Categorie() {
    }

    protected Categorie(String categorie) {
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
