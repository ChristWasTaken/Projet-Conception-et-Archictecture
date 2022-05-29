package application;

import java.util.TreeMap;

public class RegistreProjet {

    private TreeMap<Integer, Projet> registreProjet;
    private static RegistreProjet registreProjetInstance;

    private RegistreProjet() {
        this.registreProjet = new TreeMap<Integer, Projet>();
    }

    //Methode pour acceder a l'instance de la class registre projet
    public static RegistreProjet getInstance(){
        if(registreProjetInstance == null){
            registreProjetInstance = new RegistreProjet();
        }
        return registreProjetInstance;
    }

    public void ajouterProjet(Projet projet){
        this.registreProjet.put(projet.getIdProjet(), projet);
    }

    public  Projet trouverProjet(int idProjet){
        Projet projet = this.registreProjet.get(idProjet);
        return projet;
    }

    public TreeMap afficherRegistreProjet(){

        return registreProjet;
    }

}
