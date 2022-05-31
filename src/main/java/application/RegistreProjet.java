package application;

import java.util.TreeMap;

public class RegistreProjet {

    private TreeMap<Integer, Projet> registreProjet;
    private static RegistreProjet Instance;

    private RegistreProjet() {
        this.registreProjet = new TreeMap<Integer, Projet>();
    }

    //Methode pour acceder a l'instance de la class registre projet
    public static RegistreProjet getInstance(){
        if(Instance == null){
            Instance = new RegistreProjet();
        }
        return Instance;
    }

    public void ajouterProjet(Projet projet){
        this.registreProjet.put(projet.getIdProjet(), projet);
    }

    public void modifierProjet(Projet projet){
        this.registreProjet.replace(projet.getIdProjet(), projet);
    }

    public Projet trouverProjet(int idProjet){
        Projet projet = this.registreProjet.get(idProjet);
        return projet;
    }

    public TreeMap recupererRegistreProjetAsDTO(){


        return registreProjet;
    }

}
