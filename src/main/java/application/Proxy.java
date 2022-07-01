package application;

import accesPersistence.FacadePersistence;

/**
 * Class Proxy: Sorti de la couche application pour envoyer des objets DTO a la couche acces Persistence
 *
 * @author Gabrielle
 * @since 2022-06-10
 **/
public class Proxy {

    private final FacadePersistence facadePersistence = new FacadePersistence();

    /**
     * Methode pour envoyer un projet a l'access persistence pour le sauvegarder dans la base de données
     * @param projetDTO projet a envoyer a la persistence
     */
    public void persisterProjet(ProjetDTO projetDTO){
        facadePersistence.persisterProjet(projetDTO);
    }

    /**
     * Methode pour chercher un projet de la persistence par ID
     * @param id le ID du projet
     * @return ProjetDTO
     */
    public ProjetDTO chercherProjetDTOParId(int id){
        return facadePersistence.chercherProjetDTOParId(id);
    }

    /**
     * Methode pour modifier un projet déjà persisté.
     * @param projetDTO le projet a modifier
     * @return ProjetDTO le projet modifié
     */
    public ProjetDTO modifierUnProjet(ProjetDTO projetDTO) {
        return facadePersistence.modifierUnProjet(projetDTO);
    }

    /**
     * Methode pour envoyer un usager a l'access persistence pour le sauvegarder dans la base de données
     * @param compteUsagerTechDTO le compte usager technique DTO
     */
    public void persisterCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        facadePersistence.persisterCompteUsagerTech(compteUsagerTechDTO);
    }

    /**
     * Methode pour chercher un usager de la persistence
     * @param id le ID de l'usager
     * @return compteUsagerTechDTO
     */
    public CompteUsagerTechDTO chercherCompteUsagerTechDTOParId(int id){
        return facadePersistence.chercherCompteUsagerTechDTOParId(id);
    }

    /**
     * Methode pour envoyer un billetDTO à la persistence
     * @param billetDTO le billet DTO
     */
    public void persisterBillet(BilletDTO billetDTO){
        facadePersistence.persisterBillet(billetDTO);
    }

    /**
     * chercher un billetDTO en indiquant l'id du billet rechercé
     * @param id le ID du billet
     * @return billetDTO trouvé
     */
    public BilletDTO chercherBilletDTOParId(int id) {
        return facadePersistence.chercherBilletDTOParId(id);
    }

    /**
     * Methode pour modifier un billet déjà persisté.
     * @param billetDTO le billet DTO
     * @return true si la modification a été effectuée.
     */
    public boolean modifierBilletDTO(BilletDTO billetDTO) {
        return facadePersistence.modifierBilletDTO(billetDTO);
    }
}
