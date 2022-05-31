package application;

public class FacadeCompteUsager {
    private  RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();

    public void creerCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        CompteUsagerTech nouveauCompteUsager = new CompteUsagerTech(compteUsagerTechDTO);
        registreUsagerTech.ajouterUsager(nouveauCompteUsager);
    }
}
