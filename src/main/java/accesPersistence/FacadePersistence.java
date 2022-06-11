package accesPersistence;

import application.ProjetDTO;

/**
 * Class FacadePersistence
 *
 * @author Gabrielle
 * @since 2022-06-10
 **/
public class FacadePersistence {
    private ProjetDAO projetDAO = new ProjetDAO();
    public void persisterProjet(ProjetDTO projetDTO){
        projetDAO.persisterProjet(projetDTO);
    }

    public ProjetDTO chercherProjetDTOParId(int id){
        ProjetDTO projetDTO = projetDAO.chercherProjetDTOParId(id);
        return projetDTO;
    }
}
