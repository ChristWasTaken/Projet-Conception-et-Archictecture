package application;

import java.util.TreeMap;

public class RegistreUsagerTech {
    
    private TreeMap<Integer, CompteUsagerTech> registreUsagerTech;
    private static RegistreUsagerTech registreUsagerTechInstance;

    private RegistreUsagerTech() {
        this.registreUsagerTech = new TreeMap<Integer, CompteUsagerTech>();
    }

    //Methode pour acceder a l'instance de la classe registreUsagerTech
    public static RegistreUsagerTech getInstance(){
        if(registreUsagerTechInstance == null){
            registreUsagerTechInstance = new RegistreUsagerTech();
        }
        return registreUsagerTechInstance;
    }


    public void ajouterUsager(CompteUsagerTech  compteUsagerTech){
        this.registreUsagerTech.put(compteUsagerTech.getIdUsager(), compteUsagerTech);
    }

    public CompteUsagerTech trouverUsagerTech(int idUsager){
        CompteUsagerTech usager = this.registreUsagerTech.get(idUsager);
        return usager;
    }
}
