package application;

import java.time.LocalDate;
import java.util.ArrayList;

class Projet {

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
    public Projet() {
    }


    //constructeur avec parametre de base
    public Projet(int idProjet, String nomProjet, LocalDate dateDebut, LocalDate dateFin) {
        this.idProjet = idProjet; // get key, set id
        this.nomProjet = nomProjet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.registreUsagerTechAssigne = new RegistreUsagerTechAssigne();
        this.listeCategories = new ArrayList<>();
    }

    //Constructeur avec DTO
    public Projet(ProjetDTO projetDTO){
        this.setIdProjet(projetDTO.getIdProjet());
        this.setNomProjet(projetDTO.getNomProjet());
        this.setDateDebut(projetDTO.getDateDebut());
        this.setDateFin(projetDTO.getDateFin());
        this.setRegistreUsagerTechAssigne(projetDTO.getRegistreUsagerTechAssigne());
        this.setListeCategories(projetDTO.getListeCategories());
    }

    /**
     * Convertie l'instance en DTO
     *
     * @return ProjetDTO
     */
    ProjetDTO asProjetDTO(){
        final ProjetDTO projetDTO = new ProjetDTO();

        projetDTO.setIdProjet(this.getIdProjet());
        projetDTO.setNomProjet(this.getNomProjet());
        projetDTO.setDateDebut(this.getDateDebut());
        projetDTO.setDateFin(this.getDateFin());
        projetDTO.setRegistreUsagerTechAssigne(this.getRegistreUsagerTechAssigne());
        projetDTO.setListeCategories(this.getListeCategories());

        return projetDTO;
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
    public void ajouterCategoriesBillet(Categorie categorie) {
        this.listeCategories.add(categorie);
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
