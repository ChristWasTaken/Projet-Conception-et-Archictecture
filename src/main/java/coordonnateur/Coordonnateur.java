package coordonnateur;

import application.*;

public class Coordonnateur {

    FacadeProjet facadeProjet = new FacadeProjet();
    FacadeBillet facadeBillet = new FacadeBillet();

    public void creerCompteUsagerTech() {

    }

    public void creerProjet(){

    }

    public void assignerBilletAUsagerTech(BilletDTO billetDTO, CompteUsagerTechDTO compteUsagerTechDTO){
        billetDTO.setIdUsagerTechAssigne(compteUsagerTechDTO.getIdUsager());

        facadeBillet.assignerBillet(billetDTO);
    }

    public void definirCategorieDeBillet(ProjetDTO projetDto, String nouvelleCategorie){
        projetDto.ajouterCategorieBillet(new Categorie(nouvelleCategorie));

        facadeProjet.ajouterCategorie(projetDto);
    }
    
    public void creeBillet() {

    }

    public void assignerBilletAUsagerTech() {

    }

    public void changerEtatBillet() {

    }

    public void consulterListeBillets() {

    }

    public void consulterDetailBillet(){

    }

    public static void main(String[] args) {
//        PackPres packPres = new PackPres();
//        RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
//        ProjetDTO projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
//        CompteUsagerTechDTO usager = new CompteUsagerTechDTO(1, "Alain", "mdp", "email");




//        FacadeServices facadeServices = new FacadeServices();
//        facadeServices.creerProjet(projet);
//        facadeServices.assignerUsagerTech(1,1);

//        FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
//        facadeCompteUsager.creerCompteUsagerTech(usager);


//        // Créer une catégorie de billet
//        String categorieBillet = "Anomalie";
//        //Ajout de la catégorie au ProjetDTO avant de l'envoyer à la facade
//        projet.getRegistreCategories().ajouterUneCategorie(categorieBillet);
//        facadeServices.ajoutDeCategorie(projet);

//        BilletDTO billetDto = new BilletDTO(1,"Ouvert","Urgent","demandeur@gmail.com",
//                "Notes 1","Description1",
//                RegistreCategories.getRegistreCategorieInstance().recupererCategorie("Anomalie"),
//                LocalDate.now());
//
//        int idBillet = facadeServices.creerBillet(billetDto);

//        System.out.println(idBillet);
        // billetDto = facadeServices.chercherParIdBillet(idBillet);

        //changerEtatBillet (c'est fucked up que le main soit dans le coordonateur. En attendant je fais mes calls ici moi aussi)

//        facadeServices.changerEtatBillet();
//        facadeServices.afficherRegistreBillet();
//        //consulterEtatBillet
//        System.out.println(facadeServices.consulterDetailBillet(1));

//        //assigner un usager à un billet
//        CompteUsagerTech usager2 = new CompteUsagerTech(2, "Toto", "mdp", "email@hotmail.com");
//        billetDto.setIdUsagerTechAssigne(2);
//        billetDto.setIdBillet(1);
//        billetDto.setDateAssigne(LocalDate.now());
//        billetDto.setDescription("Description2");
////        System.out.println(billetDto);
//        facadeServices.assignerBillet(billetDto);
//        facadeServices.afficherRegistreBillet();


    }

}
