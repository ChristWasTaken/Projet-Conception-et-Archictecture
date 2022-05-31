package application;

import java.util.ArrayList;

public class RegistreUsagerTechAssigne {

    private ArrayList<CompteUsagerTech> registreUsagerTechAssigne;

    public RegistreUsagerTechAssigne() {
        this.registreUsagerTechAssigne = new ArrayList<>();
    }

    public void ajouterUsager(CompteUsagerTech compteUsagerTech){
        this.registreUsagerTechAssigne.add(compteUsagerTech);
    }

//    public void afficherUsager(){
//        for(CompteUsagerTech tmp : registreUsagerTechAssigne){
//            System.out.println(tmp);
//        }
//    }
}
