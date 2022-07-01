package application;

import accesPersistence.FacadePersistence;

/**
 * Classe Proxy: Sortie de la couche application pour envoyer des objets DTO à la couche accès Persistence
 * @author Gabrielle
 * @since 2022-06-10
 **/
public class Proxy {

    private final FacadePersistence facadePersistence = new FacadePersistence();

    /**
     * Méthode pour envoyer un projet à l'accès persistence pour le sauvegarder dans la base de données
     * @param projetDTO projet à envoyer à la persistence
     */
    public void persisterProjet(ProjetDTO projetDTO){
        facadePersistence.persisterProjet(projetDTO);
    }

    /**
     * Méthode pour chercher un projet de la persistence par ID
     * @param id le ID du projet
     * @return ProjetDTO
     */
    public ProjetDTO chercherProjetDTOParId(int id){
        return facadePersistence.chercherProjetDTOParId(id);
    }

    /**
     * Méthode pour modifier un projet déjà persisté.
     * @param projetDTO le projet à modifier
     * @return ProjetDTO le projet modifié
     */
    public ProjetDTO modifierUnProjet(ProjetDTO projetDTO) {
        return facadePersistence.modifierUnProjet(projetDTO);
    }

    /**
     * Méthode pour envoyer un usager à l'accès persistence pour le sauvegarder dans la base de données
     * @param compteUsagerTechDTO le compte usager technique DTO
     */
    public void persisterCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        facadePersistence.persisterCompteUsagerTech(compteUsagerTechDTO);
    }

    /**
     * Méthode pour chercher un usager de la persistence
     * @param id le ID de l'usager
     * @return compteUsagerTechDTO
     */
    public CompteUsagerTechDTO chercherCompteUsagerTechDTOParId(int id){
        return facadePersistence.chercherCompteUsagerTechDTOParId(id);
    }

    /**
     * Méthode pour envoyer un billetDTO à la persistence
     * @param billetDTO le billet DTO
     */
    public void persisterBillet(BilletDTO billetDTO){
        facadePersistence.persisterBillet(billetDTO);
    }

    /**
     * chercher un billetDTO en indiquant l'id du billet recherché
     * @param id le ID du billet
     * @return billetDTO trouvé
     */
    public BilletDTO chercherBilletDTOParId(int id) {
        return facadePersistence.chercherBilletDTOParId(id);
    }

    /**
     * Méthode pour modifier un billet déjà persisté.
     * @param billetDTO le billet DTO
     * @return true si la modification a été effectuée.
     */
    public boolean modifierBilletDTO(BilletDTO billetDTO) {
        return facadePersistence.modifierBilletDTO(billetDTO);
    }
}
