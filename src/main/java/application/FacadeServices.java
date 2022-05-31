package application;

import java.time.LocalDate;
import java.util.TreeMap;

public class FacadeServices {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreProjet registreProjet = RegistreProjet.getInstance();
    private RegistreBillet registreBillet = RegistreBillet.getRegistreBilletInstance();

    public FacadeServices() {
    }

    public void assignerUsagerTech(int idUsager, int idProjet) {
        CompteUsagerTech usagerAAssigne = registreUsagerTech.trouverUsagerTech(idUsager);
        Projet projetAAssigne = registreProjet.trouverProjet(idProjet);
        projetAAssigne.ajouterUsagerAuRegistre(usagerAAssigne);
    }

    public void creerProjet(ProjetDTO projetDTO){
        Projet nouveauProjet = new Projet(projetDTO);
        registreProjet.ajouterProjet(nouveauProjet);
    }

    public int creerBillet(BilletDTO billetDto) {

        Historique historique = new Historique(LocalDate.now(),"Création de l'historique");
        RegistreHistorique registreHistorique = new RegistreHistorique();
        registreHistorique.ajouterHistoriqueAuRegistre(historique);
        historique.setIdHistorique(historique.getIdHistorique());
        billetDto.setRegistreHistorique(registreHistorique);

        Billet billet = new Billet(billetDto);

        return registreBillet.ajouterBilletAuRegistre(billet);


    }

    /**
     * Trouver un Billet par son idBillet
     */

    public BilletDTO chercherParIdBillet(int idBillet) {
        Billet billetExistant = registreBillet.chercherBilletParId(idBillet);
        if (billetExistant == null) {
            return null;
        } else {
            return billetExistant.asBilletDTO();
        }
    }

    public boolean billetExists (int idBilletDTO){
        return registreBillet.billetExists(idBilletDTO);
    }

    public void changerEtatBillet(BilletDTO billetDTO, String nouvelEtat) {
        Billet billet = registreBillet.chercherBilletParId(billetDTO.getIdBillet());
        billet.setEtat(nouvelEtat);
        registreBillet.modifierBillet(billet.getIdBillet(), billet);
            }

    public void afficherRegistreBillet(){
        TreeMap registre = registreBillet.afficherRegistreBillet();
        System.out.println(registre);
    }

    public BilletDTO consulterDetailBillet(int idBillet){
        return registreBillet.consulterDetailBillet(idBillet);
    }

    public void ajoutDeCategorie(ProjetDTO projet) {
        Projet projetExistant = new Projet(projet);
        registreProjet.modifierProjet(projetExistant);
    }

    /**
     * Assigner un billet à un usager
     * Utilisation d'un BTO au lieux d'Id directement pour ultérieurement changer cette
     * méthode qui modifie n'importe quel paramètre du billet.
     * @param billetDTO contient l'id du billet à assigner à la position 0
     *                  et l'id de l'usager à assigner à la position 1
     */
    public void assignerBillet(BilletDTO billetDTO){

        Billet billetModifiable = new Billet(billetDTO);
        int id = billetModifiable.getIdBillet();

        billetModifiable.getRegistreHistorique().ajouterHistoriqueAuRegistre(
                new Historique(LocalDate.now(),
                        billetModifiable.getIdUsagerTechAssigne(),
                        billetModifiable.getNotes()) );

        registreBillet.modifierBillet(id, billetModifiable);
    }
}
