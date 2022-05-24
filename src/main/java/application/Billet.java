package application;

import java.time.LocalDate;

public class Billet {

    /**
     * Attributs de la classe
     */
    int idBillet;
    int idProjet;
    int idUsagerTechAssigne;

    String etat;
    String gravite;
    String courrielDemandeur;
    String notes;
    String description;

    LocalDate dateAssigne;
    LocalDate dateDebutBillet;

    RegistreHistorique registreHistorique;

    /**
     * constructeur
     */
    //par défaut
    public Billet() {
    }

    //Constructeur avec parametre pour add
    //--FAIRE LES SET POUR LES VALEURS PAR DÉFAUT ET LES AUTO-INCREMENTATION
    public Billet(int idBillet, int idProjet, String etat, String gravite, String courrielDemandeur,
                  String notes, LocalDate dateDebutBillet, RegistreHistorique registreHistorique) {
        this.idBillet = idBillet; // get key, set id
        this.idProjet = idProjet; // get id dans une picklist, set id
        this.etat = etat;
        this.gravite = gravite;
        this.courrielDemandeur = courrielDemandeur;
        this.notes = notes;
        this.dateDebutBillet = dateDebutBillet;
        this.registreHistorique = registreHistorique;
    }


    /**
     * Getters and setters
     */
    public int getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(int idBillet) {
        this.idBillet = idBillet;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) { this.idProjet = idProjet; }
    public int getIdUsagerTechAssigne() {
        return idUsagerTechAssigne;
    }

    public void setIdUsagerTechAssigne(int idUsagerTechAssigne) {
        this.idUsagerTechAssigne = idUsagerTechAssigne;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getGravite() {
        return gravite;
    }

    public void setGravite(String gravite) { this.gravite = gravite; }

    public String getCourrielDemandeur() {
        return courrielDemandeur;
    }

    public void setCourrielDemandeur(String courrielDemandeur) {
        this.courrielDemandeur = courrielDemandeur;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAssigne() {
        return dateAssigne;
    }

    public void setDateAssigne(LocalDate dateAssigne) {
        this.dateAssigne = dateAssigne;
    }

    public LocalDate getDateDebutBillet() {
        return dateDebutBillet;
    }

    public void setDateDebutBillet(LocalDate dateDebutBillet) {
        this.dateDebutBillet = dateDebutBillet;
    }

    public RegistreHistorique getRegistreHistorique() {
        return registreHistorique;
    }

    public void setRegistreHistorique(RegistreHistorique registreHistorique) {
        this.registreHistorique = registreHistorique;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "Billet{" +
                "idBillet=" + idBillet +
                ", idProjet=" + idProjet +
                ", idUsagerTechAssigne=" + idUsagerTechAssigne +
                ", etat='" + etat + '\'' +
                ", gravite='" + gravite + '\'' +
                ", courrielDemandeur='" + courrielDemandeur + '\'' +
                ", notes='" + notes + '\'' +
                ", description='" + description + '\'' +
                ", dateAssigne=" + dateAssigne +
                ", dateDebutBillet=" + dateDebutBillet +
                ", registreHistorique=" + registreHistorique +
                '}';
    }
}
