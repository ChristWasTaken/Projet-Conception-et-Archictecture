package application;

import java.util.ArrayList;

public class RegistreHistorique {
    private ArrayList<Historique> registreHistorique =  new ArrayList<>();




    /**
     * Constructeur
     */
    public RegistreHistorique() {
    }

    /**
     * Getters and setters
     */
    public ArrayList<Historique> getRegistreHistorique() {
        return registreHistorique;
    }

    public void setRegistreHistorique(ArrayList<Historique> registreHistorique) {
        this.registreHistorique = registreHistorique;
    }



    public void ajouterHistoriqueAuRegistre(Historique historique){
        this.registreHistorique.add(historique.getIdHistorique(), historique);
    }

    public void modifierRegistreHistorique(){

    }
}
