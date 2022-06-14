package accesPersistence;

import application.CompteUsagerTechDTO;
import application.ProjetDTO;

/**
 * Class FacadePersistence
 *
 * @author Gabrielle
 * @since 2022-06-10
 **/
public class FacadePersistence {
    private ProjetDAO projetDAO = new ProjetDAO();
    private UsagerTechDAO  usagerTechDAO = new UsagerTechDAO();
    public void persisterProjet(ProjetDTO projetDTO){
        projetDAO.persisterProjet(projetDTO);
    }

    public ProjetDTO chercherProjetDTOParId(int id){
        ProjetDTO projetDTO = projetDAO.chercherProjetDTOParId(id);
        return projetDTO;
    }

    public void persisterCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        usagerTechDAO.persisterCompteUsagerTech(compteUsagerTechDTO);
    }

    public CompteUsagerTechDTO chercherCompteUsagerTechDTOParId(int id){
        CompteUsagerTechDTO compteUsagerTechDTO = usagerTechDAO.chercherCompteUsagerTechDTOParId(id);
        return compteUsagerTechDTO;
    }
}
