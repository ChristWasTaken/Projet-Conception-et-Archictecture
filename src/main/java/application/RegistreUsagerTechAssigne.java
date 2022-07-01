package application;

import java.util.ArrayList;

public class RegistreUsagerTechAssigne {

    private final ArrayList<CompteUsagerTech> registreUsagerTechAssigne;

    public RegistreUsagerTechAssigne() {
        this.registreUsagerTechAssigne = new ArrayList<>();
    }

    /**
     * Méthode pour ajouter un compte usager technique au registre des usager technique assigné.
     * @param compteUsagerTech le compte usager technique à ajouter au registre.
     * @return boolean
     */
    public boolean ajouterUsager(CompteUsagerTech compteUsagerTech){
        boolean result = false;
        try {
            this.registreUsagerTechAssigne.add(compteUsagerTech);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void afficherUsager(){
        for(CompteUsagerTech tmp : registreUsagerTechAssigne){
            System.out.println(tmp);
        }
    }
}
