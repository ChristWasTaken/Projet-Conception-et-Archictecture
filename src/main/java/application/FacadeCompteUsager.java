package application;

public class FacadeCompteUsager {

    private static Proxy proxy = new Proxy();

    private  RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();

    public void creerCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        CompteUsagerTech nouveauCompteUsager = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.ajouterUsager(nouveauCompteUsager);
    }

    public CompteUsagerTechDTO consulterCompteUsagerTechDTOParId(int id){
        CompteUsagerTechDTO compteUsagerTech = proxy.chercherCompteUsagerTechDTOParId(id);
        return compteUsagerTech;
    }
}
