package application;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RegistreBillet {

    /*
     * Instance unique
     */
    private static RegistreBillet instance = new RegistreBillet();

    /*
     * Registre des clients indexé par numéro.
     */
    private final TreeMap<Integer, Billet> registreBillet;

    /*
     * Dernier numéro attribué à un billet.
     */
    private static int dernierNumeroBilletAttribue = 0;

    /*
     * Constructeur par défaut
     */
    private RegistreBillet() {
        this.registreBillet = new TreeMap<>();
    }

    /*
     * Getter de l'instance
     */
    public static RegistreBillet getInstance() {
        if (instance == null) {
            instance = new RegistreBillet();
        }
        return instance;
    }

    /**
     * incrémentation automatique du IDBillet
     * @return le nouveau IDBillet
     */
    private int prochainIdBillet() {
        return ++dernierNumeroBilletAttribue;
    }

    /*
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
     * @param idBillet l'id du billet à trouver
     * @return un Billet
     */
    public Billet chercherBilletParId(int idBillet) {
        return this.registreBillet.get(idBillet);
    }

    /**
     * Modifier un enregistrement dans le registre
     * @param id id du billet à modifier
     * @param billetModifiable billet modifié
     */
    public void modifierBillet(int id, Billet billetModifiable) {
        this.registreBillet.put(id, billetModifiable);
    }

    /**
     * Consulter la Liste des Billets
     * @return liste de billets de type BilletDTO
     */
    public TreeMap<Integer, BilletDTO> recupererListeBilletEnDTO() {
        TreeMap<Integer, BilletDTO> listeDTO = new TreeMap<>();
        registreBillet.forEach((key, value) -> listeDTO.put(key, value.asBilletDTO()));
        return listeDTO;
    }

    /**
     * méthode permettant de récupérer la liste des BilletsDTO selon le type de filtre demandé
     * @param champs les champs de filtre
     * @param filtre le type de filtre
     * @return liste de billetsDTO
     */
    public TreeMap<Integer, BilletDTO> recupererListeBilletEnDTO(String champs, Object filtre) {
        TreeMap<Integer, BilletDTO> listeDTO = recupererListeBilletEnDTO();
        Map<Integer, BilletDTO> listeTriee;
        if (listeDTO != null) {

            listeTriee = listeDTO.entrySet()
                    .stream()
                    .filter(billetDTOEntry -> filtrerChamps(champs, filtre, billetDTOEntry))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        } else {
            return null;
        }
        return new TreeMap<>(listeTriee);
    }

    /**
     * Méthode qui détermine si le champs choisi du billetDTO est conforme au filtre ou non.
     *
     * @param champs les champs de filtre
     * @param filtre le type de filtre
     * @param billetDTOEntry l'enregistrement à filtrer
     * @return true si le filtre est respecté, false sinon
     */
    private boolean filtrerChamps(String champs, Object filtre, Map.Entry<Integer, BilletDTO> billetDTOEntry) {
        boolean reponse = false;
        switch (champs) {
            case "date" -> {
                LocalDate date = (LocalDate) filtre;
                if (date.equals(billetDTOEntry.getValue().getDateDebutBillet())) {
                    reponse = true;
                }
            }
            case "demandeur" -> {
                String demandeur = (String) filtre;
                if (demandeur.equals(billetDTOEntry.getValue().getCourrielDemandeur())) {
                    reponse = true;
                }
            }
            case "etat" -> {
                String etat = (String) filtre;
                if (etat.equals(billetDTOEntry.getValue().getEtat())) {
                    reponse = true;
                }
            }
            case "tech" -> {
                int usager = Integer.parseInt((String) filtre);
                if (usager == (billetDTOEntry.getValue().getIdUsagerTechAssigne())) {
                    reponse = true;
                }
            }
            case "projet" -> {
                int projet = Integer.parseInt((String) filtre);
                if (projet == billetDTOEntry.getValue().getIdProjet()) {
                    reponse = true;
                }
            }
            case "categorie" -> {
                String categorie = (String) filtre;
                if (categorie.equals(billetDTOEntry.getValue().getCategorie().getCategorie())) {
                    reponse = true;
                }
            }
            case "gravite" -> {
                String gravite = (String) filtre;
                if (gravite.equals(billetDTOEntry.getValue().getGravite())) {
                    reponse = true;
                }
            }
        }
        return reponse;
    }
}
