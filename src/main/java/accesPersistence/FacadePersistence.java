package accesPersistence;

import application.BilletDTO;
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
    private BilletDAO billetDAO = new BilletDAO();

    public void persisterProjet(ProjetDTO projetDTO){
        projetDAO.persisterProjet(projetDTO);
    }

    public ProjetDTO chercherProjetDTOParId(int id){
        return projetDAO.chercherProjetDTOParId(id);
    }

    public ProjetDTO modifierUnProjet(ProjetDTO projetDTO){
        return projetDAO.modifierUnProjet(projetDTO);
    }

    public void persisterCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        usagerTechDAO.persisterCompteUsagerTech(compteUsagerTechDTO);
    }

    public CompteUsagerTechDTO chercherCompteUsagerTechDTOParId(int id){
        CompteUsagerTechDTO compteUsagerTechDTO = usagerTechDAO.chercherCompteUsagerTechDTOParId(id);
        return compteUsagerTechDTO;
    }

    public void persisterBillet(BilletDTO billetDTO){
        billetDAO.persisterBillet(billetDTO);
    }

    public BilletDTO chercherBilletDTOParId(int id){
        BilletDTO billetDTO = billetDAO.chercherBilletDTOParId(id);
        return billetDTO;
    }

    public boolean modifierBilletDTO(BilletDTO billetDTO) {
        BilletDTO billetModifie = billetDAO.modifierBillet(billetDTO);
        if (billetModifie != null) {
            return true;
        }
        return false;
    }
}
