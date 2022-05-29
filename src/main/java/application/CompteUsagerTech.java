package application;

public class CompteUsagerTech {
    /**
     * Attributs de la classe
     */
    private int idUsager;
    String nomUsager;
    String motPasse;
    String courriel;



    /**
     * Constructeurs
     */
    //par défaut
    public CompteUsagerTech() { }

    //avec Parametre
    public CompteUsagerTech(int idUsager, String nomUsager, String motPasse, String courriel) {
        this.idUsager = idUsager;
        this.nomUsager = nomUsager;
        this.motPasse = motPasse;
        this.courriel = courriel;
    }

    /**
     * Getters and setters
     */
    public String getNomUsager() {
        return nomUsager;
    }

    public void setNomUsager(String nomUsager) {
        this.nomUsager = nomUsager;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public int getIdUsager() {
        return idUsager;
    }

    public void setIdUsager(int idUsager) {
        this.idUsager = idUsager;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "CompteUsagerTech{" +
                "nomUsager='" + nomUsager + '\'' +
                ", motPasse='" + motPasse + '\'' +
                ", courriel='" + courriel + '\'' +
                '}';
    }
}
