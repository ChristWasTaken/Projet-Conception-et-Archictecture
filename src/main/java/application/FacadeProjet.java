package application;

import accesPersistence.UsagerTechDAO;

public class FacadeProjet {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreProjet registreProjet = RegistreProjet.getInstance();
    private Proxy proxy = new Proxy();
    public FacadeProjet() {
    }

    public void creerProjet(ProjetDTO projetDTO){
        Projet nouveauProjet = new Projet(projetDTO);
        registreProjet.ajouterProjet(nouveauProjet);
        proxy.persisterNouveauProjet(projetDTO);
    }

    public void ajouterCategorie(ProjetDTO projet) {
        Projet projetExistant = new Projet(projet);
        registreProjet.modifierProjet(projetExistant);
    }

    public void assignerUsagerTech(CompteUsagerTechDTO usagerDTO, ProjetDTO projetDTO) {
        CompteUsagerTech usagerAAssigne = registreUsagerTech.trouverUsagerTech(usagerDTO.getIdUsager());
        Projet projetAAssigne = registreProjet.trouverProjet(projetDTO.getIdProjet());
        projetAAssigne.ajouterUsagerAuRegistre(usagerAAssigne);
    }
}
