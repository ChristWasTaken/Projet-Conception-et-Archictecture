package application;

public class FacadeProjet {

    private final RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private final RegistreProjet registreProjet = RegistreProjet.getInstance();
    private final Proxy proxy = new Proxy();
    public FacadeProjet() {
    }

    /**
     * Méthode pour créer un projet en lui passant un objet projetDTO rempli par
     * l'utilisateur a l'aide de formulaire dans la couche presentation. Le projet est sauvegarder en memoire dans un
     * registre et est persister a travers le proxy vers une base de données.
     * @param projetDTO le projet DTO
     */
    public void creerProjet(ProjetDTO projetDTO){
        Projet nouveauProjet = new Projet(projetDTO);
        registreProjet.ajouterProjet(nouveauProjet);
        proxy.persisterProjet(nouveauProjet.asProjetDTO());
    }

    /**
     * Méthode ajouter une categorie à un projetDTO par l'entremise
     * d'un DTO déja modifier au niveau du coordonateur
     * @param projetDTO le projetDTO
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

    /**
     * Méthode pour assigner un compte usager technique à un projet. Le projet et l'usager sont choisis dans la couche
     * présentation et sont passés à la facade avec des objets DTO. Le projet avec son registre d'usagers assignés est
     * persisté dans la base de données avec une mise à jour.
     * @param usagerDTO le compte usager technique DTO
     * @param projetDTO le projet DTO
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
