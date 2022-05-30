package application;

import java.time.LocalDate;
import java.util.TreeMap;

public class FacadeServices {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreProjet registreProjet = RegistreProjet.getInstance();
    private RegistreBillet registreBillet = RegistreBillet.getInstance();


    public FacadeServices() {
    }

    public void assignerUsagerTech(int idUsager, int idProjet) {
        CompteUsagerTech usagerAAssigne = registreUsagerTech.trouverUsagerTech(idUsager);
        Projet projetAAssigne = registreProjet.trouverProjet(idProjet);
        projetAAssigne.ajouterUsagerAuRegistre(usagerAAssigne);
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
        Billet billetExistant = registreBillet.chercherParNumero(idBillet);
        if (billetExistant == null) {
            return null;
        } else {
            return billetExistant.asBilletDTO();
        }
    }

    public boolean billetExists (int idBilletDTO){
        return registreBillet.billetExists(idBilletDTO);
    }

    public void changerEtatBillet(String[] transitModifications) {
        registreBillet.changerEtatBillet(transitModifications);
    }

    public void afficherRegistreBillet(){
        TreeMap registre = registreBillet.afficherRegistreBillet();
        System.out.println(registre);

    }
}
