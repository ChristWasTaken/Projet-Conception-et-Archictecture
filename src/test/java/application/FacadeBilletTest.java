package application;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FacadeBilletTest {

    FacadeBillet facadeBillet;
    FacadeCompteUsager facadeCompteUsager;
    FacadeProjet facadeProjet;
    RegistreProjet registreProjet;
    RegistreBillet registreBillet;
    RegistreUsagerTech registreUsagerTech;
    Proxy proxy;
    BilletDTO billetDTO;
    ProjetDTO projetDTO;
    Projet projet;
    CompteUsagerTechDTO usagerDTO;

    Categorie categorie;
    String categorieBillet;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        facadeBillet = new FacadeBillet();
        facadeProjet = new FacadeProjet();
        facadeCompteUsager = new FacadeCompteUsager();
        registreProjet = RegistreProjet.getInstance();
        registreBillet = RegistreBillet.getInstance();
        registreUsagerTech = RegistreUsagerTech.getInstance();
        proxy= new Proxy();


        //Créer un projetDTO
        projetDTO = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28),
                LocalDate.of(2022,05,29));

        facadeProjet.creerProjet(projetDTO);

        //Créer un CompteUsagerTechniqueDTO
        usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");
        facadeCompteUsager.creerCompteUsagerTech(usagerDTO);

        //Assigner UsagerTechnique au projet
        facadeProjet.assignerUsagerTech(usagerDTO, projetDTO);

        //Créer un billetDTO
        billetDTO = new BilletDTO(1, "Ouvert", "Urgent",
                "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
                "J'ai redémarré et ça ne fonctionne pas.", LocalDate.now());
        facadeBillet.creerBillet(billetDTO);

       //Ajouter une catégorie au billet
        categorieBillet = "Anomalie";
        projetDTO.ajouterCategorieBillet(categorieBillet);
        projet = new Projet(projetDTO);
        registreProjet.modifierProjet(projet);

        //Ajoute une gravité au billet
        billetDTO.setGravite("Urgent");
        //facadeBillet.//-------------------------------faire une méthode pour modifier Billet dans Facade Billet
        billetDTO.setGravite("Normal");




    }






        // Créer une catégorie de billet

        //Ajout de la catégorie au ProjetDTO avant de l'envoyer à la facade
//




//    }
//
//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void assignerUsagerTech() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void creerProjet() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void creerBillet() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void chercherParIdBillet() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void billetExists() {
//    }


    @Test
    void testCreerBilletEnPassantUnBilletDTO() {


        int indice = facadeBillet.creerBillet(billetDTO);
        assertTrue(indice>0);

        BilletDTO billetTrouve = facadeBillet.consulterBilletParId(indice);

        RegistreHistorique registreHistoriqueTrouve = billetTrouve.getRegistreHistorique();

        int id = registreHistoriqueTrouve.getRegistreHistorique().lastKey();

        Historique historiqueTrouve = registreHistoriqueTrouve.chercherParNumero(id);

        assertEquals(1,historiqueTrouve.getIdHistorique());

    }



    @Test
    void changerEtatBillet() {
        //Debut
        BilletDTO billetDTO = facadeBillet.consulterBilletParId(1);

        facadeBillet.changerEtatBillet(billetDTO, "Fermé", "Travail terminé. Fermeture du billet");
        assertEquals("Fermé", facadeBillet.consulterBilletParId(1).getEtat());
        System.out.println(facadeBillet.consulterBilletParId(1));
        assertEquals(2, facadeBillet.consulterBilletParId(1).getRegistreHistorique().getRegistreHistorique().size());

    }

    @Test
    void afficherRegistreBillet() {
    }

    @Test
    void consulterDetailBillet() {
    }

    @Test
    void ajoutDeCategorie() {
    }

//    @Test
//    void assignerBillet() {
//        presentationMock.projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
//    }

    @Test
    void consulterListeBillet() {
        System.out.println(facadeBillet.consulterListeBillet("gravite", "Urgent"));
    }


}