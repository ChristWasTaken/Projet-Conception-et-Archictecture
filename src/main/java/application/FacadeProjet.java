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

    /**
     * Méthode ajouter une categorie à un projetDTO par l'entremise
     * d'un DTO déja modifier au niveau du coordonateur
     * @param projetDTO
     * @return true si la catégorie n'existe pas déjà dans le projetDTO et a été créer avec succès,
     * false un doublon est trouvé ou la création à échouée sinon.
     */
    public boolean ajouterCategorie(ProjetDTO projetDTO) {
        ProjetDTO projetExistant = proxy.modifierUnProjet(projetDTO);
        if(projetExistant != null){
            Projet projetModifier = new Projet(projetExistant);
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

    public ProjetDTO consulterUnProjetDTOParId(int id){
        return proxy.chercherProjetDTOParId(id);
    }




}
