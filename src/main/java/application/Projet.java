package application;

import java.time.LocalDate;

public class Projet {

    /**
     * Attributs de la classe
     */
    private int idProjet;
    private String nomProjet;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private RegistreUsagerTechAssigne registreUsagerTechAssigne;
    private RegistreCategories registreCategories;


    /**
     * constructeurs
     */
    //par défaut
    public Projet() {
    }

    //avec paramètres
    //--FAIRE LES SET POUR LES VALEURS PAR DÉFAUT ET LES AUTO-INCREMENTATION
    public Projet(int idProjet, String nomProjet, LocalDate dateDebut, LocalDate dateFin) {
        this.idProjet = idProjet; // get key, set id
        this.nomProjet = nomProjet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.registreUsagerTechAssigne = new RegistreUsagerTechAssigne();
    }

    //Constructeur avec DTO
    public Projet(ProjetDTO projetDTO){
        this.setIdProjet(projetDTO.getIdProjet());
        this.setNomProjet(projetDTO.getNomProjet());
        this.setDateDebut(projetDTO.getDateDebut());
        this.setDateFin(projetDTO.getDateFin());
        this.setRegistreUsagerTechAssigne(projetDTO.getRegistreUsagerTechAssigne());
        this.setRegistreCategories(projetDTO.getRegistreCategories());
    }



    /**
     * Getters and setters
     */

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public RegistreUsagerTechAssigne getRegistreUsagerTechAssigne() {
        return registreUsagerTechAssigne;
    }

    public void setRegistreUsagerTechAssigne(RegistreUsagerTechAssigne registreUsagerTechAssigne) {
        this.registreUsagerTechAssigne = registreUsagerTechAssigne;
    }

    public void ajouterUsagerAuRegistre(CompteUsagerTech compteUsagerTech){
        this.registreUsagerTechAssigne.ajouterUsager(compteUsagerTech);
    }

    public RegistreCategories getRegistreCategories() {
        return registreCategories;
    }

    public void setRegistreCategories(RegistreCategories registreCategories) {
        this.registreCategories = registreCategories;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "Projet{" +
                "idProjet=" + idProjet +
                ", nomProjet='" + nomProjet + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", registreUsagerTechAssigne=" + registreUsagerTechAssigne +
                '}';
    }
}
