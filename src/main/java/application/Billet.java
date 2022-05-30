package application;

import java.time.LocalDate;

public class Billet {

    /**
     * Attributs de la classe
     */
    private int idBillet=0;
    private int idProjet;
    private int idUsagerTechAssigne;

    private String etat="";


    private String gravite="";
    private String courrielDemandeur="";
    private String notes="";
    private String description="";

    private CategorieBillet categorie;
    private LocalDate dateAssigne;
    private LocalDate dateDebutBillet;

    RegistreHistorique registreHistorique;



    /**
     * constructeur
     */
    //par défaut
    public Billet() {
    }

    //Constructeur avec parametre pour add
    //--FAIRE LES SET POUR LES VALEURS PAR DÉFAUT ET LES AUTO-INCREMENTATION
    //par défaut: état: ouvert


    public Billet(BilletDTO billet) {
        this.setIdBillet(billet.getIdBillet());;
        this.setIdProjet(billet.getIdProjet());
        this.setUsagerTechnique(billet.getIdUsagerTechAssigne());;
        this.setEtat(billet.getEtat());
        this.setGravite(billet.getGravite());
        this.setCourrielDemandeur(billet.getCourrielDemandeur());
        this.setNotes(billet.getNotes());
        this.setDescription(billet.getDescription());
        this.setCategorie(billet.getCategorie());
        this.setDateAssigne(billet.getDateAssigne());
        this.setDateDebutBillet(billet.getDateDebutBillet());
        this.setRegistreHistorique(billet.getRegistreHistorique());
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

    public void setUsagerTechnique(int idUsagerTechAssigne) {
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

    public CategorieBillet getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieBillet categorie) {
        this.categorie = categorie;
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
     * Getters and setters
     */


    BilletDTO asBilletDTO(){
        final BilletDTO billetDTO = new BilletDTO();

        billetDTO.setIdBillet(this.getIdBillet());
        billetDTO.setIdProjet(this.getIdProjet());
        billetDTO.setIdUsagerTechAssigne(this.getIdUsagerTechAssigne());
        billetDTO.setEtat(this.getEtat());
        billetDTO.setGravite(this.getGravite());
        billetDTO.setCourrielDemandeur(this.getCourrielDemandeur());
        billetDTO.setNotes(this.getNotes());
        billetDTO.setDescription(this.getDescription());
        billetDTO.setCategorie(this.getCategorie());
        billetDTO.setDateAssigne(this.getDateAssigne());
        billetDTO.setDateDebutBillet(this.getDateDebutBillet());
        billetDTO.setRegistreHistorique(this.getRegistreHistorique());

        return billetDTO;
    }

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
                ", description='" + description + " \' "
                + categorie + '\'' +
                ", dateAssigne=" + dateAssigne +
                ", dateDebutBillet=" + dateDebutBillet +
                ", registreHistorique=" + registreHistorique +
                '}';
    }
}
