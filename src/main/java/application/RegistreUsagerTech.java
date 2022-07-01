package application;

import java.util.TreeMap;

public class RegistreUsagerTech {
    
    private TreeMap<Integer, CompteUsagerTech> registreUsagerTech;
    private static RegistreUsagerTech Instance;

    private RegistreUsagerTech() {
        this.registreUsagerTech = new TreeMap<Integer, CompteUsagerTech>();
    }

    //Methode pour acceder a l'instance de la classe registreUsagerTech
    public static RegistreUsagerTech getInstance(){
        if(Instance == null){
            Instance = new RegistreUsagerTech();
        }
        return Instance;
    }


    /**
     * Méthode pour ajouter un compte usager technique dans le registre de tout les comptes usagers techniques.
     * @param  compteUsagerTech
     */
    public void ajouterUsager(CompteUsagerTech  compteUsagerTech){
        this.registreUsagerTech.put(compteUsagerTech.getIdUsager(), compteUsagerTech);
    }

    /**
     * Méthode pour chercher un usager en particulier qui est dans le registre.
     * @param idUsager
     */
    public CompteUsagerTech trouverUsagerTech(int idUsager){
        CompteUsagerTech usager = this.registreUsagerTech.get(idUsager);
        return usager;
    }

    public TreeMap<Integer, CompteUsagerTechDTO> recupererRegistreUsagerTechAsDTO(){
        TreeMap<Integer, CompteUsagerTechDTO> registreUsagerTechDTO = new TreeMap<Integer, CompteUsagerTechDTO>();
        for(CompteUsagerTech usager : this.registreUsagerTech.values()){
            registreUsagerTechDTO.put(usager.getIdUsager(), usager.asCompteUsagerTechDTO());
        }

        return registreUsagerTechDTO;
    }
}
