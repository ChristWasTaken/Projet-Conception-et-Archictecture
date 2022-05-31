package coordonnateur;

import application.*;
import presentation.PackPres;

import java.time.LocalDate;

public class Coordonnateur {

    public static void main(String[] args) {
        PackPres packPres = new PackPres();
        RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
        ProjetDTO projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        CompteUsagerTech usager = new CompteUsagerTech(1, "Alain", "mdp", "email");

        registreUsagerTech.ajouterUsager(usager);

        
        FacadeServices facadeServices = new FacadeServices();
        facadeServices.assignerUsagerTech(1,1);
        facadeServices.creerProjet(projet);
        // Créer une catégorie de billet
        String categorieBillet = "Anomalie";
        facadeServices.ajoutDeCategorie(categorieBillet);

        BilletDTO billetDto = new BilletDTO(1,"Ouvert","Urgent","demandeur@gmail.com",
                "Notes 1","Description1",
                RegistreCategories.getRegistreCategorieInstance().recupererCategorie("Anomalie"),
                LocalDate.now());

        int idBillet = facadeServices.creerBillet(billetDto);

//        System.out.println(idBillet);
       // billetDto = facadeServices.chercherParIdBillet(idBillet);

        //changerEtatBillet (c'est fucked up que le main soit dans le coordonateur. En attendant je fais mes calls ici moi aussi)
        String[]transitModifications =  packPres.changerEtatBillet(facadeServices,1,"Fermé");
        facadeServices.changerEtatBillet(transitModifications);
        facadeServices.afficherRegistreBillet();
        //consulterEtatBillet
        System.out.println(facadeServices.consulterDetailBillet(1));

        //assigner un usager à un billet
        CompteUsagerTech usager2 = new CompteUsagerTech(2, "Toto", "mdp", "email@hotmail.com");
        billetDto.setIdUsagerTechAssigne(2);
        billetDto.setIdBillet(1);
        billetDto.setDateAssigne(LocalDate.now());
        billetDto.setDescription("Description2");
//        System.out.println(billetDto);
        facadeServices.assignerBillet(billetDto);
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
