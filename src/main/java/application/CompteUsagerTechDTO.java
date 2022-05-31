package application;

/**
 * Class CompteUsagerTechDTO
 *
 * @author Gabrielle
 * @since 2022-05-31
 **/
public class CompteUsagerTechDTO {
    /**
     * Attributs de la classe
     */
    private int idUsager;
    String nomUsager;
    String motPasse;
    String courriel;

    public CompteUsagerTechDTO() {
    }

    public CompteUsagerTechDTO(int idUsager, String nomUsager, String motPasse, String courriel) {
        this.idUsager = idUsager;
        this.nomUsager = nomUsager;
        this.motPasse = motPasse;
        this.courriel = courriel;
    }

    public int getIdUsager() {
        return idUsager;
    }

    public void setIdUsager(int idUsager) {
        this.idUsager = idUsager;
    }

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

    @Override
    public String toString() {
        return "CompteUsagerTechDTO{" +
                "idUsager=" + idUsager +
                ", nomUsager='" + nomUsager + '\'' +
                ", motPasse='" + motPasse + '\'' +
                ", courriel='" + courriel + '\'' +
                '}';
    }
}
