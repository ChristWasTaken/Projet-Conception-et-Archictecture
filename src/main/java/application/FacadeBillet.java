package application;

import java.time.LocalDate;
import java.util.TreeMap;

public class FacadeBillet {

    private final RegistreBillet registreBillet = RegistreBillet.getInstance();
    private final Proxy proxy = new Proxy();

    public FacadeBillet() {
    }


    /**
     * Créer un billet en lui passant le billet DTO
     * @param billetDTO le billet DTO
     * @return le id du billet créé
     */
    public int creerBillet(BilletDTO billetDTO) {

        Billet billet = new Billet(billetDTO);
        int id = registreBillet.ajouterBilletAuRegistre(billet);
        Historique historique = new Historique(LocalDate.now(),"Création de l'historique");

        billet.setIdBillet(id);
        historique.setIdBilletAssocie(id);
        billet.getRegistreHistorique().ajouterHistoriqueAuRegistre(historique);

        registreBillet.modifierBillet(id,billet);
        proxy.persisterBillet(billet.asBilletDTO());
        return id;
    }

    /**
     * Trouver un Billet par son idBillet
     * @param idBillet l'id du billet à trouver
     * @return l'objet obtenu en format billet DTO
     */

    public BilletDTO consulterBilletParId(int idBillet) {
        Billet billetExistant = registreBillet.chercherBilletParId(idBillet);
        if (billetExistant == null) {
            return null;
        } else {
            return billetExistant.asBilletDTO();
        }
    }


    /**
     * Méthode pour changer l'état du billet en lui passant le nouvel objetDTO, le nouvel état ainsi que le
     * commentaire expliquant ce nouvel état
     * @param billetDTO le billet DTO
     * @param etat le nouvel état
     * @param commentaire le commentaire expliquant ce nouvel état
     */
    public void changerEtatBillet(BilletDTO billetDTO, String etat, String commentaire)
    {
        billetDTO.setEtat(etat);

        int usager = billetDTO.getIdUsagerTechAssigne();
        Historique historique = new Historique(LocalDate.now(),usager,commentaire);
        historique.setIdBilletAssocie(billetDTO.getIdBillet());
        billetDTO.getRegistreHistorique().ajouterHistoriqueAuRegistre(historique);

        Billet billet = new Billet(billetDTO);
        registreBillet.modifierBillet(billet.getIdBillet(), billet);
        proxy.persisterBillet(billet.asBilletDTO());
    }


    /**
     * Assigner un billet à un usager en utilisation un DTO modifier préalablement.
     * @param billetDTO contient l'id du billet à assigner et l'id de l'usager à assigner.
     * @return true si l'assignation a été effectuée.
     */
    public boolean assignerBillet(BilletDTO billetDTO){

        Billet billetModifiable = new Billet(billetDTO);
        billetModifiable.getRegistreHistorique().ajouterHistoriqueAuRegistre(
                new Historique(LocalDate.now(),
                        billetModifiable.getIdUsagerTechAssigne(),
                        billetModifiable.getNotes()) );

        registreBillet.modifierBillet(billetModifiable.getIdBillet(), billetModifiable);
        return proxy.modifierBilletDTO(billetModifiable.asBilletDTO());
    }


    /**
     * Méthode qui permet de consulter la liste des billets en choisissant le type de filtre qu'on désire faire
     * en l'indiquant dans le paramètr champs
     * @param champs le type de filtre
     * @param filtre le filtre à appliquer
     * @return la liste des billets filtrés
     */
    public TreeMap<Integer, BilletDTO> consulterListeBillet(String champs, Object filtre){
        return registreBillet.recupererListeBilletEnDTO(champs,filtre);
    }
}
