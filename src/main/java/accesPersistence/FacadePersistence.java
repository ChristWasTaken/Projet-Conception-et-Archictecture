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
    private final ProjetDAO projetDAO = new ProjetDAO();
    private final UsagerTechDAO  usagerTechDAO = new UsagerTechDAO();
    private final BilletDAO billetDAO = new BilletDAO();

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
        return usagerTechDAO.chercherCompteUsagerTechDTOParId(id);
    }

    public void persisterBillet(BilletDTO billetDTO){
        billetDAO.persisterBillet(billetDTO);
    }

    public BilletDTO chercherBilletDTOParId(int id){
        return billetDAO.chercherBilletDTOParId(id);
    }

    public boolean modifierBilletDTO(BilletDTO billetDTO) {
        return billetDAO.modifierBillet(billetDTO);
    }
}
