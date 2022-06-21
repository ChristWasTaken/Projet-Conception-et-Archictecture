package application;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FacadeBilletTest {

    FacadeBillet facadeBillet = new FacadeBillet();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
    FacadeProjet facadeProjet = new FacadeProjet();
    RegistreProjet registreProjet = RegistreProjet.getInstance();
    RegistreBillet registreBillet = RegistreBillet.getInstance();
    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    Proxy proxy = new Proxy();

    BilletDTO billetDTO1 = new BilletDTO(1, "Ouvert", "Urgent",
            "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022,06,20));
    BilletDTO billetDTO2 = new BilletDTO(1, "Ouvert", "Bénin",
            "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022,06,22));
    BilletDTO billetDTO3 = new BilletDTO(1, "Fermé", "Bénin",
            "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022,06,22));
    BilletDTO billetDTO4 = new BilletDTO(1, "Fermé", "Urgent",
            "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022,06,20));
    ProjetDTO projetDTO1 =
            new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28),
            LocalDate.of(2022,05,29));

    Categorie categorieAnomalie = new Categorie("Anomalie");
    Categorie categorieEchec = new Categorie("Echec");
    CompteUsagerTechDTO usagerDTO1 =
            new CompteUsagerTechDTO(1,"Roger","mdp","email");



    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //Créer un projetDTO
        facadeProjet.creerProjet(projetDTO1);

        //Créer un CompteUsagerTechniqueDTO
        facadeCompteUsager.creerCompteUsagerTech(usagerDTO1);
        //Assigner UsagerTechnique au projet
        facadeProjet.assignerUsagerTech(usagerDTO1, projetDTO1);

        //Ajouter une catégorie au billet
        projetDTO1.ajouterCategorieBillet(categorieAnomalie);
        //Attibuer une catégorie au billet
        billetDTO1.setCategorie(categorieAnomalie);
        //Créer un billet
        facadeBillet.creerBillet(billetDTO1);
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


        int indice = facadeBillet.creerBillet(billetDTO1);
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
        System.out.println(facadeBillet.consulterListeBillet("date", LocalDate.of(2022,06,20)));
        System.out.println(facadeBillet.consulterListeBillet("demandeur", "utilisateur1@gmail.com"));
        System.out.println(facadeBillet.consulterListeBillet("etat", "Ouvert"));
        System.out.println(facadeBillet.consulterListeBillet("tech", "0"));
        System.out.println(facadeBillet.consulterListeBillet("projet", "1"));
        System.out.println(facadeBillet.consulterListeBillet("categorie", "Anomalie"));
        System.out.println(facadeBillet.consulterListeBillet("gravite", "Urgent"));

    }


}