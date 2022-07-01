package application;

public class FacadeProjet {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreProjet registreProjet = RegistreProjet.getInstance();
    private Proxy proxy = new Proxy();
    public FacadeProjet() {
    }

    /**
     * Méthode pour créer un projet en lui passant un objet projetDTO rempli par
     * l'utilisateur a l'aide de formulaire dans la couche presentation. Le projet est sauvegarder en memoire dans un
     * registre et est persister a travers le proxy vers une base de données.
     * @param projetDTO
     */
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
        projetDTO = proxy.modifierUnProjet(projetDTO);
        if(projetDTO != null){
            Projet projetModifier = new Projet(projetDTO);
            registreProjet.modifierProjet(projetModifier);
            return true;
        }
        return false;
    }

    /**
     * Méthode pour assigner un compte usager technique a un projet. Le projet et l'usager sont choisi dans la couche
     * presentation est passer a la facade avec des objets DTO. Le projet avec son registre d'usager assigner est
     * persister dans la base de donnée avec une mise a jour.
     * @param usagerDTO
     * @param projetDTO
     */
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
