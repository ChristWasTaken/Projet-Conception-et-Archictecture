package application;

public class FacadeCompteUsager {

    private static final Proxy proxy = new Proxy();

    private final RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();

    /**
     * Méthode pour créer un compte usager technique en lui passant un objet compte usager technique DTO rempli par
     * l'utilisateur à l'aide de formulaire dans la couche présentation. L'usager est sauvegardé en mémoire dans un
     * registre et est persisté à travers le proxy vers une base de données.
     * @param compteUsagerTechDTO le compte usager technique DTO
     */
    public void creerCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        CompteUsagerTech nouveauCompteUsager = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.ajouterUsager(nouveauCompteUsager);
        proxy.persisterCompteUsagerTech(nouveauCompteUsager.asCompteUsagerTechDTO());
    }

    public CompteUsagerTechDTO consulterCompteUsagerTechDTOParId(int id){
        return proxy.chercherCompteUsagerTechDTOParId(id);
    }
}
