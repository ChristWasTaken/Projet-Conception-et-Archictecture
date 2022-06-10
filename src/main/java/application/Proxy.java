package application;

import accesPersistence.FacadePersistence;

/**
 * Class Proxy: Sorti de la couche application pour envoyer des objets DTO a la couche accesPersistence
 *
 * @author Gabrielle
 * @since 2022-06-10
 **/
public class Proxy {

    private FacadePersistence facadePersistence = new FacadePersistence();

    /**
     * Methode pour envoyer un projet a la persistence
     */
    public void persisterNouveauProjet(ProjetDTO projetDTO){
        facadePersistence.persisterNouveauProjet(projetDTO);
    }

    /**
     * Methode pour chercher un projet de la persistence
     */
    public ProjetDTO chercherProjetDTOParId(int id){
        ProjetDTO projetDTO = facadePersistence.chercherProjetDTOParId(id);
        return projetDTO;
    }
}
