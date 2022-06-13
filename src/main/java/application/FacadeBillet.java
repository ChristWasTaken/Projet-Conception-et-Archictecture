package application;

import java.time.LocalDate;
import java.util.TreeMap;

public class FacadeBillet {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreBillet registreBillet = RegistreBillet.getInstance();

    public FacadeBillet() {
    }


    public int creerBillet(BilletDTO billetDto) {

        Historique historique = new Historique(LocalDate.now()
                ,"Création de l'historique");
//        RegistreHistorique registreHistorique = new RegistreHistorique();
        billetDto.getRegistreHistorique()
                .ajouterHistoriqueAuRegistre(historique);
//        historique.setIdHistorique(historique.getIdHistorique());
//        billetDto.setRegistreHistorique(registreHistorique);

        Billet billet = new Billet(billetDto);

        return registreBillet.ajouterBilletAuRegistre(billet);

    }

    /**
     * Trouver un Billet par son idBillet
     */

    public BilletDTO consulterBilletParId(int idBillet) {
        Billet billetExistant = registreBillet.chercherBilletParId(idBillet);
        if (billetExistant == null) {
            return null;
        } else {
            return billetExistant.asBilletDTO();
        }
    }


    ////// Voir à changer la méthode pour qu'elle passe seulement un DTO à partir du coordonnateur - selon réponse du prof
    public void changerEtatBillet(BilletDTO billetDTO, String etat, String commentaire)
    {
        billetDTO.setEtat(etat);
        RegistreHistorique registreHistorique = billetDTO.getRegistreHistorique();

        // Ici on a le choix de passer le id de l'usager original (ce que ça fait actuellement), ou le changer
        // pour que ce soit reçu en parametre.
        int usager = registreHistorique.chercherParNumero(1).getUsagerTechAssigne();
        Historique historique = new Historique(LocalDate.now(),usager,commentaire);
        registreHistorique.ajouterHistoriqueAuRegistre(historique);
        billetDTO.setRegistreHistorique(registreHistorique);
        Billet billet = new Billet(billetDTO);
        registreBillet.modifierBillet(billet.getIdBillet(), billet);
    }


    /**
     * Assigner un billet à un usager
     * Utilisation d'un BTO au lieux d'Id directement pour ultérieurement changer cette
     * méthode qui modifie n'importe quel paramètre du billet.
     * @param billetDTO contient l'id du billet à assigner et l'id de l'usager à assigner.
     */
    public void assignerBillet(BilletDTO billetDTO){

        Billet billetModifiable = new Billet(billetDTO);
        System.out.println(billetDTO);


        billetModifiable.getRegistreHistorique().ajouterHistoriqueAuRegistre(
                new Historique(LocalDate.now(),
                        billetModifiable.getIdUsagerTechAssigne(),
                        billetModifiable.getNotes()) );
        System.out.println(billetDTO);
        registreBillet.modifierBillet(billetModifiable.getIdBillet(), billetModifiable);

    }



//    public TreeMap consulterListeBilletDTO(int idBillet){
//        TreeMap<Integer, Billet> registre = registreBillet.afficherRegistreBillet();
//
//        return registre;
//    }
//
//
//    public TreeMap recupererRegistreBilletDTO(){
//        TreeMap<Integer, Billet> registre = registreBillet.afficherRegistreBillet();
//
//        return registre;
//    }

    public TreeMap consulterListeBillet(String champs, Object object){
        return registreBillet.consulterListeBillets(champs,object);
    }

}
