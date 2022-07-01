package application;

import accesPersistence.FacadePersistence;

/**
 * Class Proxy: Sorti de la couche application pour envoyer des objets DTO a la couche acces Persistence
 *
 * @author Gabrielle
 * @since 2022-06-10
 **/
public class Proxy {

    private FacadePersistence facadePersistence = new FacadePersistence();

    /**
     * Methode pour envoyer un projet a la persistence
     * @param projetDTO projet a envoyer a la persistence
     */
    public void persisterProjet(ProjetDTO projetDTO){
        facadePersistence.persisterProjet(projetDTO);
    }

    /**
     * Methode pour chercher un projet de la persistence par ID
     * @param id
     * @return ProjetDTO
     */
    public ProjetDTO chercherProjetDTOParId(int id){
        return facadePersistence.chercherProjetDTOParId(id);
    }

    /**
     * Methode pour modifier un projet déjà persisté.
     * @param projetDTO
     * @return ProjetDTO
     */
    public ProjetDTO modifierUnProjet(ProjetDTO projetDTO) {
        return facadePersistence.modifierUnProjet(projetDTO);
    }

    /**
     * Methode pour envoyer un usager a la persistence
     * @param compteUsagerTechDTO
     */
    public void persisterCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        facadePersistence.persisterCompteUsagerTech(compteUsagerTechDTO);
    }

    /**
     * Methode pour chercher un usager de la persistence
     * @param id
     * @return compteUsagerTechDTO
     */
    public CompteUsagerTechDTO chercherCompteUsagerTechDTOParId(int id){
        CompteUsagerTechDTO compteUsagerTechDTO = facadePersistence.chercherCompteUsagerTechDTOParId(id);
        return compteUsagerTechDTO;
    }

    /**
     * Methode pour envoyer un billetDTO à la persistence
     * @param billetDTO
     */
    public void persisterBillet(BilletDTO billetDTO){
        facadePersistence.persisterBillet(billetDTO);
    }

    /**
     * chercher un billetDTO en indiquant l'id du billet rechercé
     * @param id
     * @return
     */
    public BilletDTO chercherBilletDTOParId(int id) {
        BilletDTO billetDTO = facadePersistence.chercherBilletDTOParId(id);
        return billetDTO;
    }

    /**
     * Methode pour modifier un billet déjà persisté.
     * @param billetDTO
     * @return true si la modification a été effectuée.
     */
    public boolean modifierBilletDTO(BilletDTO billetDTO) {
        return facadePersistence.modifierBilletDTO(billetDTO);
    }
}
