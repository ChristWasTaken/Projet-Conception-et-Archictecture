package application;

import java.time.LocalDate;
import java.util.Objects;

public class BilletDTO {

    /**
     * Attributs de la classe
     */
    private int idBillet = 0;
    private int idProjet;
    private int idUsagerTechAssigne;
    private String etat;
    private String gravite;
    private String courrielDemandeur;
    private String notes;
    private String description;
    private LocalDate dateAssigne;
    private LocalDate dateDebutBillet;
    private Categorie categorie;
    private RegistreHistorique registreHistorique;

    /**
     * constructeurs
     */
    public BilletDTO() {
    }

    public BilletDTO(int idProjet, String etat, String gravite, String courrielDemandeur, String notes, String description, LocalDate dateDebutBillet) {
        this.idProjet = idProjet;
        this.etat = etat;
        this.gravite = gravite;
        this.courrielDemandeur = courrielDemandeur;
        this.notes = notes;
        this.description = description;
        this.dateDebutBillet = dateDebutBillet;
        this.registreHistorique = new RegistreHistorique();
    }

    public BilletDTO(int idProjet, String etat, String gravite, String courrielDemandeur, String notes, String description, Categorie categorie, LocalDate dateDebutBillet) {
        this.idProjet = idProjet;
        this.etat = etat;
        this.gravite = gravite;
        this.courrielDemandeur = courrielDemandeur;
        this.notes = notes;
        this.description = description;
        this.categorie = categorie;
        this.dateDebutBillet = dateDebutBillet;
        this.registreHistorique = new RegistreHistorique();
    }

    public BilletDTO(int idBillet, int idProjet, String etat, String gravite, String courrielDemandeur, String notes, String description, LocalDate dateDebutBillet) {
        this.idBillet = idBillet;
        this.idProjet = idProjet;
        this.etat = etat;
        this.gravite = gravite;
        this.courrielDemandeur = courrielDemandeur;
        this.notes = notes;
        this.description = description;
        this.dateDebutBillet = dateDebutBillet;
        this.registreHistorique = new RegistreHistorique();
    }

    public int getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(int idBillet) {
        this.idBillet = idBillet;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

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

    public void setGravite(String gravite) {
        this.gravite = gravite;
    }

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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public LocalDate getDateAssigne() {
        return this.dateAssigne;
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

    @Override
    public String toString() {
        return "BilletDTO{" +
                "idBillet=" + idBillet +
                ", idProjet=" + idProjet +
                ", idUsagerTechAssigne=" + idUsagerTechAssigne +
                ", etat='" + etat + '\'' +
                ", gravite='" + gravite + '\'' +
                ", courrielDemandeur='" + courrielDemandeur + '\'' +
                ", notes='" + notes + '\'' +
                ", description='" + description
                + categorie + '\'' +
                ", dateAssigne=" + dateAssigne +
                ", dateDebutBillet=" + dateDebutBillet +
                ", registreHistorique=" + registreHistorique +
                '}';
    }

    /**
     * Méthode pour comparer un objet de type Object avec un BilletDTO pour valider si c'est le même objet
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BilletDTO billetDTO = (BilletDTO) o;
        return idProjet == billetDTO.idProjet && idUsagerTechAssigne == billetDTO.idUsagerTechAssigne && Objects.equals(etat, billetDTO.etat) && Objects.equals(gravite, billetDTO.gravite) && Objects.equals(courrielDemandeur, billetDTO.courrielDemandeur) && Objects.equals(notes, billetDTO.notes) && Objects.equals(description, billetDTO.description) && Objects.equals(dateAssigne, billetDTO.dateAssigne) && Objects.equals(dateDebutBillet, billetDTO.dateDebutBillet) && Objects.equals(categorie, billetDTO.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProjet, idUsagerTechAssigne, etat, gravite, courrielDemandeur, notes, description, dateAssigne, dateDebutBillet, categorie);
    }
}
