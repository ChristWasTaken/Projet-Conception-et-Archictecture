package application;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class ProjetDTO
 *
 * @author Gabrielle
 * @since 2022-05-31
 **/
public class ProjetDTO {
    /**
     * Attributs de la classe
     */
    private int idProjet;
    private String nomProjet;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private RegistreUsagerTechAssigne registreUsagerTechAssigne;
    private ArrayList<Categorie> listeCategories;
    /**
     * constructeurs
     */
    //par défaut
    public ProjetDTO() {
    }

    public ProjetDTO(int idProjet, String nomProjet, LocalDate dateDebut, LocalDate dateFin) {
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.registreUsagerTechAssigne = new RegistreUsagerTechAssigne();
        this.listeCategories = new ArrayList<>();
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

    public ArrayList<Categorie> getListeCategories() {
        return listeCategories;
    }

    public void setListeCategories(ArrayList<Categorie> listeCategories) {
        this.listeCategories = listeCategories;
    }

    public boolean verifierDoublonCategorie(Categorie categorie){
        if(this.listeCategories.contains(categorie)){

            return true;
        }
        return false;
    }

    /**
     * Ajouter une catégorie à l'ArrayList
     * @param categorie
     */
    public void ajouterCategorieBillet(Categorie categorie) {
        if(!verifierDoublonCategorie(categorie)) {
            this.listeCategories.add(categorie);
        }
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "ProjetDTO{" +
                "idProjet=" + idProjet +
                ", nomProjet='" + nomProjet + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", registreUsagerTechAssigne=" + registreUsagerTechAssigne +
                ", categoriesBillet=" + listeCategories +
                '}';
    }
}
