package application;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RegistreBillet {


    /**
     * Instance unique.
     */
    private static RegistreBillet instance = new RegistreBillet();


    /**
     * Registre des clients indexé par numéro.
     */
    private TreeMap<Integer, Billet> registreBillet = new TreeMap<>();

    /**
     * Dernier numéro attribué à un billet.
     */
    private static int dernierNumeroBilletAttribue = 0;



    /**
     * Constructeur par défaut
     */
    public RegistreBillet() {
    }

    /**
     * Getter de l'instance
     */

    public static RegistreBillet getInstance() {
        if (instance == null) {
            instance = new RegistreBillet();
        }
        return instance;
    }

    /**
     * Ajouter billet au registre
     * @param nouveauBillet
     * @return le id du billet ajouté
     */
    public int ajouterBilletAuRegistre(Billet nouveauBillet) {
        nouveauBillet.setIdBillet(this.prochainIdBillet());
        this.registreBillet.put(nouveauBillet.getIdBillet(), nouveauBillet);

        return nouveauBillet.getIdBillet();
    }

    /**
     * Chercher un Billet par son Id
     * @param idBillet
     * @return un Billet
     */
    public Billet chercherBilletParId(int idBillet) {
        return this.registreBillet.get(idBillet);
    }


    /**
     * incrémentation automatique du IDBillet
     * @return
     */
    private int prochainIdBillet() {
        return ++dernierNumeroBilletAttribue;
    }


//    public TreeMap afficherRegistreBillet() {
//
//        return registreBillet;
//    }

    public void modifierBillet(int id, Billet billetModifiable) {
        this.registreBillet.put(id, billetModifiable);
    }



    /**
     * Consulter la Liste des Billets
     * @return liste de billets de type BilletDTO
     */
    public TreeMap<Integer, BilletDTO> consulterListeBillets(){
        TreeMap<Integer,BilletDTO> listeDTO = new TreeMap<>();
        registreBillet.forEach((key,value) -> {
            listeDTO.put(key, value.asBilletDTO());
        });
        return listeDTO;
    }

    public TreeMap<Integer, BilletDTO> consulterListeBillets(String champs, Object filtre) {
        TreeMap <Integer,BilletDTO> listeDTO = consulterListeBillets();
        Map<Integer, BilletDTO> listeTriee = listeDTO.entrySet()
                .stream()
                .filter(billetDTOEntry -> filtrerChamps(champs, filtre, billetDTOEntry))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return new TreeMap<>(listeTriee);
    }

    private boolean filtrerChamps(String champs, Object filtre, Map.Entry<Integer, BilletDTO> billetDTOEntry) {
        Boolean reponse = false;
        switch (champs) {
            case "date":
                {
                    LocalDate date = (LocalDate) filtre;
                    if (date.equals(billetDTOEntry.getValue().getDateDebutBillet())) {
                        reponse = true;
                    }
                }
                break;
            case "demandeur":
                String demandeur = (String) filtre;
                if (demandeur.equals(billetDTOEntry.getValue().getCourrielDemandeur())) {
                    reponse = true;
                }
                break;
            case "etat":
                String etat = (String) filtre;
                if (etat.equals(billetDTOEntry.getValue().getEtat())) {
                    reponse = true;
                }
                break;
            case "tech":
                int usager = Integer.parseInt((String)filtre);
                if (usager == (billetDTOEntry.getValue().getIdUsagerTechAssigne())) {
                    reponse = true;
                }
                break;
            case "projet":
                int projet = Integer.parseInt((String)filtre);
                if (projet == billetDTOEntry.getValue().getIdProjet()) {
                    reponse = true;
                }
                break;
            case "categorie":
                String categorie = (String) filtre;
                if (categorie.equals(billetDTOEntry.getValue().getCategorie().getCategorie())) {
                    reponse = true;
                }
                break;
            case "gravite":
                String gravite = (String) filtre;
                if (gravite.equals(billetDTOEntry.getValue().getGravite())) {
                    reponse = true;
                }
                break;

            default:
                reponse = false;
        }
        return reponse;
    }
}
