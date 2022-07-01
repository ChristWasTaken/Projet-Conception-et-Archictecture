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


    public void ajouterUsager(CompteUsagerTech  compteUsagerTech){
        this.registreUsagerTech.put(compteUsagerTech.getIdUsager(), compteUsagerTech);
    }

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
