package application;

import org.junit.jupiter.api.*;
import presentation.PackPres;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class FacadeBilletTest {

    FacadeBillet facadeBillet = new FacadeBillet();
    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
    FacadeProjet facadeProjet = new FacadeProjet();


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ProjetDTO projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        CompteUsagerTechDTO usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");
        facadeCompteUsager.creerCompteUsagerTech(usagerDTO);
        facadeProjet.creerProjet(projet);
        facadeProjet.assignerUsagerTech(1,1);

        // Créer une catégorie de billet
        String categorieBillet = "Anomalie";
        //Ajout de la catégorie au ProjetDTO avant de l'envoyer à la facade
        projet.ajouterCategoriesBillet(new Categorie(categorieBillet));
//        facadeProjet.ajouterCategorie(projet);
        BilletDTO billetDto = new BilletDTO(1,"Ouvert","Urgent","demandeur@gmail.com",
                "Notes 1","Description1",LocalDate.now());
//        billetDto.setCategorie(projet.getRegistreCategories().recupererCategorie(categorieBillet));
        int idBillet = facadeBillet.creerBillet(billetDto);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void assignerUsagerTech() {
    }

    @org.junit.jupiter.api.Test
    void creerProjet() {
    }

    @org.junit.jupiter.api.Test
    void creerBillet() {
    }

    @org.junit.jupiter.api.Test
    void chercherParIdBillet() {
    }

    @org.junit.jupiter.api.Test
    void billetExists() {
    }

    @Test
    void changerEtatBillet() {
        //Debut
        BilletDTO billetDTO = facadeBillet.consulterBilletParId(1);
        billetDTO.setEtat("Fermé");
        RegistreHistorique registreHistorique = billetDTO.getRegistreHistorique();
        int usager = registreHistorique.chercherParNumero(1).getUsagerTechAssigne();
        Historique historique = new Historique(LocalDate.now(),usager,"Travail terminé. Fermeture du billet");
        registreHistorique.ajouterHistoriqueAuRegistre(historique);
        billetDTO.setRegistreHistorique(registreHistorique);
        //Fin - De tout ce qui se passe dans la couche présentation

        facadeBillet.changerEtatBillet(billetDTO);
        assertEquals("Fermé",facadeBillet.consulterBilletParId(1).getEtat());
        assertEquals(2,facadeBillet.consulterBilletParId(1).getRegistreHistorique().getRegistreHistorique().size());
        System.out.println(facadeBillet.consulterBilletParId(1));


    }

    @org.junit.jupiter.api.Test
    void afficherRegistreBillet() {
    }

    @org.junit.jupiter.api.Test
    void consulterDetailBillet() {
    }

    @org.junit.jupiter.api.Test
    void ajoutDeCategorie() {
    }

    @Test
    void assignerBillet() {
    }
}