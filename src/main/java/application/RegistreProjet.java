package application;

import java.util.TreeMap;

public class RegistreProjet {

    private final TreeMap<Integer, Projet> registreProjet;
    private static RegistreProjet Instance;

    public static int dernierNumeroProjetAttribue = 0;

    private RegistreProjet() {
        this.registreProjet = new TreeMap<>();
    }

    //Methode pour acceder a l'instance de la class registre projet
    public static RegistreProjet getInstance(){
        if(Instance == null){
            Instance = new RegistreProjet();
        }
        return Instance;
    }

    public int prochainIdProjet(){
        dernierNumeroProjetAttribue++;
        return dernierNumeroProjetAttribue;
    }

    /**
     * Méthode pour ajouter un projet dans le registre des projet
     * @param nouveauProjet le projet a ajouter
     */
    public int ajouterProjet(Projet nouveauProjet){
        nouveauProjet.setIdProjet(this.prochainIdProjet());
        this.registreProjet.put(nouveauProjet.getIdProjet(), nouveauProjet);

        return nouveauProjet.getIdProjet();
    }

    /** Permet le remplacement d'une entrée dans le registre de projets
     * @param projet le projet a remplacer
     */
    public void modifierProjet(Projet projet){
        this.registreProjet.replace(projet.getIdProjet(), projet);
    }

    /**
     * Méthode pour trouver un projet en particulier du registre
     * @param idProjet l'id du projet a trouver
     */
    public Projet trouverProjet(int idProjet){
        return this.registreProjet.get(idProjet);
    }
    public TreeMap<Integer, ProjetDTO> recupererRegistreProjetAsDTO(){
        TreeMap<Integer, ProjetDTO> registreProjetDTO = new TreeMap<>();
        for(Projet projet : this.registreProjet.values()){
            registreProjetDTO.put(projet.getIdProjet(), projet.asProjetDTO());
        }
        return registreProjetDTO;
    }
}
