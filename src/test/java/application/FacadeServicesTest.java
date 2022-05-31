package application;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import presentation.PackPres;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FacadeServicesTest {
    PackPres packPres = new PackPres();
    FacadeServices facadeServices = new FacadeServices();
    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
//    @BeforeAll
//    void beforeAll(){
//
//    }


    @org.junit.jupiter.api.BeforeEach
    void setUp() {

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
        ProjetDTO projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        CompteUsagerTech usager = new CompteUsagerTech(1, "Alain", "mdp", "email");
        registreUsagerTech.ajouterUsager(usager);
        facadeServices.creerProjet(projet);
        facadeServices.assignerUsagerTech(1,1);
        // Créer une catégorie de billet
        String categorieBillet = "Anomalie";
        //Ajout de la catégorie au ProjetDTO avant de l'envoyer à la facade
        projet.getRegistreCategories().ajouterUneCategorie(categorieBillet);
        facadeServices.ajoutDeCategorie(projet);
        BilletDTO billetDto = new BilletDTO(1,"Ouvert","Urgent","demandeur@gmail.com",
                "Notes 1","Description1",LocalDate.now());
        int idBillet = facadeServices.creerBillet(billetDto);
        System.out.println(idBillet);
       facadeServices.changerEtatBillet(billetDto,"Fermé");
        facadeServices.afficherRegistreBillet();
        //consulterEtatBillet
        System.out.println(facadeServices.consulterDetailBillet(1));

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