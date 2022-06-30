package coordonnateur;

import application.*;

public class Coordonnateur {

    FacadeProjet facadeProjet = new FacadeProjet();
    FacadeBillet facadeBillet = new FacadeBillet();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();

    public void creerCompteUsagerTech() {

    }

    public void creerProjet(ProjetDTO projetDTO) {
        facadeProjet.creerProjet(projetDTO);
    }
    public ProjetDTO consulterUnProjetDTOParId(int id) {
        return facadeProjet.consulterUnProjetDTOParId(id);
    }

    public CompteUsagerTechDTO consulterCompteUsagerTechDTO(int id) {
        return facadeCompteUsager.consulterCompteUsagerTechDTOParId(id);
    }

    public void assignerCompteUsagerTechAProjet(CompteUsagerTechDTO usagerTechDTO, ProjetDTO projetDTO) {
        facadeProjet.assignerUsagerTech(usagerTechDTO, projetDTO);
    }

    public boolean definirCategorieDeBillet(ProjetDTO projetDto, String nouvelleCategorie) {
        projetDto.ajouterCategorieBillet(new Categorie(nouvelleCategorie));
        if(facadeProjet.ajouterCategorie(projetDto)){
            return true;
        }
        return false;
    }

    public void creerBillet(BilletDTO billetDTO) {
        facadeBillet.creerBillet(billetDTO);

    }
    public boolean assignerBilletAUsagerTech(BilletDTO billetDTO, CompteUsagerTechDTO compteUsagerTechDTO) {
        billetDTO.setIdUsagerTechAssigne(compteUsagerTechDTO.getIdUsager());
        if(facadeBillet.assignerBillet(billetDTO)){
           return true;
        }
        return false;
    }


    public void changerEtatBillet(BilletDTO billetDTO, String etat, int idUsager, String noteHistorique) {
        facadeBillet.changerEtatBillet(billetDTO, etat, noteHistorique);
    }

    public void consulterListeBillets(String champs, Object filtre) {
        facadeBillet.consulterListeBillet(champs, filtre);
    }

    public BilletDTO consulterDetailBillet(int id) {
        return facadeBillet.consulterBilletParId(id);
    }


}
