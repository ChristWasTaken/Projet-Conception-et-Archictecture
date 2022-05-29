package application;

import java.time.LocalDate;
import java.util.TreeMap;

public class FacadeServices {

    private RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    private RegistreProjet registreProjet = RegistreProjet.getInstance();
    private RegistreBillet registreBillet = RegistreBillet.getInstance();
    private RegistreHistorique registreHistorique = new RegistreHistorique();

    public FacadeServices() {
    }

    public void assignerUsagerTech(int idUsager, int idProjet) {
        CompteUsagerTech usagerAAssigne = registreUsagerTech.trouverUsagerTech(idUsager);
        Projet projetAAssigne = registreProjet.trouverProjet(idProjet);
        projetAAssigne.ajouterUsagerAuRegistre(usagerAAssigne);
    }

    public int creerBillet(BilletDTO billetDto) {
        Billet billet = new Billet(billetDto);

        Historique historique = new Historique(0, LocalDate.now(),"Création du billet");
        registreHistorique.ajouterHistoriqueAuRegistre(historique);
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

    public void consulterEtatBillet(int idBillet){
        registreBillet.consulterEtatBillet(idBillet);
    }
}
