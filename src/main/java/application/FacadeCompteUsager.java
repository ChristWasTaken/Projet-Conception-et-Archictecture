package application;

public class FacadeCompteUsager {

    private static Proxy proxy = new Proxy();

    private  RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();

    /**
     * Méthode pour créer un compte usager technique en lui passant un objet compte usager technique DTO rempli par
     * l'utilisateur a l'aide de formulaire dans la couche presentation. L'usager est sauvegarder en memoire dans un
     * registre et est persister a travers le proxy vers une base de données.
     * @param compteUsagerTechDTO
     */
    public void creerCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        CompteUsagerTech nouveauCompteUsager = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.ajouterUsager(nouveauCompteUsager);
        proxy.persisterCompteUsagerTech(nouveauCompteUsager.asCompteUsagerTechDTO());
    }

    public CompteUsagerTechDTO consulterCompteUsagerTechDTOParId(int id){
        CompteUsagerTechDTO compteUsagerTech = proxy.chercherCompteUsagerTechDTOParId(id);
        return compteUsagerTech;
    }
}
