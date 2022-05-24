package application;

import java.time.LocalDate;

public class Historique {

    /**
     * Attributs de la classe
     */
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
    public Historique(LocalDate date, int usagerTechAssigne, String commentaires) {
        this.date = date;
        this.usagerTechAssigne = usagerTechAssigne;
        this.commentaires = commentaires;
    }


    /**
     * Getters dans setters
     */
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
                "date=" + date +
                ", usagerTechAssigne=" + usagerTechAssigne +
                ", commentaires='" + commentaires + '\'' +
                '}';
    }
}
