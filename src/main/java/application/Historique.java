package application;

import java.time.LocalDate;

public class Historique {

    /**
     * Attributs de la classe
     */
    private int idHistorique = 0;
    private int idBilletAssocie = 0;
    private LocalDate date;
    private int usagerTechAssigne;
    private String commentaires;

    /**
     * Constructeurs
     */

    public Historique() {
    }

    public Historique(LocalDate date, String commentaires) {
        this.date = date;
        this.commentaires = commentaires;
    }

    public Historique(LocalDate date, int usagerTechAssigne, String commentaires) {
        this.date = date;
        this.usagerTechAssigne = usagerTechAssigne;
        this.commentaires = commentaires;
    }

    public Historique(int idHistorique, int idBilletAssocie, LocalDate date, String commentaires) {
        this.idHistorique = idHistorique;
        this.idBilletAssocie = idBilletAssocie;
        this.date = date;
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

    public int getIdBilletAssocie() {
        return idBilletAssocie;
    }

    public void setIdBilletAssocie(int idBilletAssocie) {
        this.idBilletAssocie = idBilletAssocie;
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
        return  "Historique{" +
                "idHistorique=" + idHistorique +
                ", idBilletAssocié=" + idBilletAssocie +
                ", date=" + date +
                ", usagerTechAssigne=" + usagerTechAssigne +
                ", commentaires='" + commentaires + '\'' +
                '}'  +"\n";
    }
}
