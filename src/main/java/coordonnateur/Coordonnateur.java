package coordonnateur;

import application.*;
import presentation.PackPres;

import java.time.LocalDate;

public class Coordonnateur {

    public static void main(String[] args) {
        PackPres packPres = new PackPres();
        RegistreProjet registreProjet = RegistreProjet.getInstance();
        RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
        Projet projet = new Projet(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        CompteUsagerTech usager = new CompteUsagerTech(1, "Alain", "mdp", "email");
        registreProjet.ajouterProjet(projet);
        registreUsagerTech.ajouterUsager(usager);

        
        FacadeServices facadeServices = new FacadeServices();
        facadeServices.assignerUsagerTech(1,1);



        BilletDTO billetDto = new BilletDTO(1,"Ouvert","Urgent","demandeur@gmail.com","Notes 1","Description1","Anomalie",LocalDate.now());

        int idBillet = facadeServices.creerBillet(billetDto);

        System.out.println(idBillet);
       // billetDto = facadeServices.chercherParIdBillet(idBillet);

        //changerEtatBillet (c'est fucked up que le main soit dans le coordonateur. En attendant je fais mes calls ici moi aussi)
        String[]transitModifications =  packPres.changerEtatBillet(facadeServices,1,"Fermé");
        facadeServices.changerEtatBillet(transitModifications);
        facadeServices.afficherRegistreBillet();
    }


    public void creerCompteUsagerTech() {

    }

    public void creerProjet(){

    }

    public void assignerUsagerTech(){

    }

    public void definirCategorie(){

    }

    public void creeBillet() {

    }

    public void assignerBillet() {

    }

    public void changerEtatBillet() {

    }

    public void consulterListeBillets() {

    }

    public void consulterDetailBillet(){

    }

}
