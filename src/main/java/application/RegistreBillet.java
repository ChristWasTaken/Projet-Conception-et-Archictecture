package application;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RegistreBillet {

    /**
     * Instance unique du registre
     */
    private static RegistreBillet instance = new RegistreBillet();

    /**
     * Registre des clients indexé par numéro.
     */
    private TreeMap<Integer, Billet> registreBillet = new TreeMap<>();

   //Dernier numéro attribué à un billet.
    private static int dernierNumeroBilletAttribue = 0;

    //Constructeur par défaut
    private RegistreBillet() {
        this.registreBillet = new TreeMap<Integer, Billet>();
    }

    /**
     * Getter de l'instance unique
     */
    public static RegistreBillet getInstance() {
        if (instance == null) {
            instance = new RegistreBillet();
        }
        return instance;
    }

    /**
     * incrémentation automatique du IDBillet
     * @return
     */
    private int prochainIdBillet() {
        return ++dernierNumeroBilletAttribue;
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

    public void modifierBillet(int id, Billet billetModifiable) {
        this.registreBillet.put(id, billetModifiable);
    }

    /**
     * Consulter la Liste des Billets
     * @return liste de billets de type BilletDTO
     */
    public TreeMap<Integer, BilletDTO> recupererListeBilletEnDTO() {
        TreeMap<Integer, BilletDTO> listeDTO = new TreeMap<>();
        registreBillet.forEach((key, value) -> {
            listeDTO.put(key, value.asBilletDTO());
        });
        if (listeDTO == null) {
            return null;
        }
        return listeDTO;
    }

    /**
     * méthode permettant de récupérer la liste des BilletsDTO seon le type de filtre demandé
     * @param champs
     * @param filtre
     * @return liste de billetsDTO
     */
    public TreeMap<Integer, BilletDTO> recupererListeBilletEnDTO(String champs, Object filtre) {
        TreeMap<Integer, BilletDTO> listeDTO = recupererListeBilletEnDTO();
        Map<Integer, BilletDTO> listeTriee;
        if (listeDTO != null) {

            listeTriee = listeDTO.entrySet()
                    .stream()
                    .filter(billetDTOEntry -> filtrerChamps(champs, filtre, billetDTOEntry))
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        } else {
            return null;
        }
        return new TreeMap<>(listeTriee);
    }

    /**
     * Méthode qui filtre les champs afin de définir quel type de filtre sera utilisé
     * dans la méthode: recupererListeBilletEnDTO
     * @param champs
     * @param filtre
     * @param billetDTOEntry
     * @return
     */
    private boolean filtrerChamps(String champs, Object filtre, Map.Entry<Integer, BilletDTO> billetDTOEntry) {
        Boolean reponse = false;
        switch (champs) {
            case "date": {
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
                int usager = Integer.parseInt((String) filtre);
                if (usager == (billetDTOEntry.getValue().getIdUsagerTechAssigne())) {
                    reponse = true;
                }
                break;
            case "projet":
                int projet = Integer.parseInt((String) filtre);
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
