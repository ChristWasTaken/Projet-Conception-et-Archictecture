package application;

import java.time.LocalDate;

public class Historique {

    /**
     * Attributs de la classe
     */
    private int idHistorique;
    private LocalDate date;
    private int usagerTechAssigne;
    private String commentaires;


    /**
     * Constructeurs
     */
    //par défaut
    public Historique() {
    }

    //avec paramètres

    public Historique(int idHistorique, LocalDate date, String commentaires) {
        this.idHistorique = idHistorique;
        this.date = date;
        this.usagerTechAssigne = usagerTechAssigne;
        this.commentaires = commentaires;
    }

    /**
     * Getters dans setters
     */
    public int getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUsagerTechAssigne() {
        return usagerTechAssigne;
    }

    public void setUsagerTechAssigne(int usagerTechAssigne) {
        this.usagerTechAssigne = usagerTechAssigne;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "Historique{" +
                "idHistorique=" + idHistorique +
                ", date=" + date +
                ", usagerTechAssigne=" + usagerTechAssigne +
                ", commentaires='" + commentaires + '\'' +
                '}';
    }
}
