package application;

public class FacadeProjet {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreProjet registreProjet = RegistreProjet.getInstance();
    private Proxy proxy = new Proxy();
    public FacadeProjet() {
    }

    public void creerProjet(ProjetDTO projetDTO){
        Projet nouveauProjet = new Projet(projetDTO);
        registreProjet.ajouterProjet(nouveauProjet);
        proxy.persisterProjet(nouveauProjet.asProjetDTO());
    }

    public ProjetDTO consulterUnProjetDTOParId(int id){
        ProjetDTO projetDTO = proxy.chercherProjetDTOParId(id);
        return projetDTO;
    }

    public boolean ajouterCategorie(ProjetDTO projet) {
        projet = proxy.modifierUnProjet(projet);
        if(projet != null){
            Projet projetModifier = new Projet(projet);
            registreProjet.modifierProjet(projetModifier);
            return true;
        }
        return false;
    }

    public void assignerUsagerTech(CompteUsagerTechDTO usagerDTO, ProjetDTO projetDTO) {
        CompteUsagerTech usagerAAssigne = registreUsagerTech.trouverUsagerTech(usagerDTO.getIdUsager());
        Projet projetAAssigne = registreProjet.trouverProjet(projetDTO.getIdProjet());
        projetAAssigne.ajouterUsagerAuRegistre(usagerAAssigne);
        proxy.persisterProjet(projetAAssigne.asProjetDTO());
    }
}
