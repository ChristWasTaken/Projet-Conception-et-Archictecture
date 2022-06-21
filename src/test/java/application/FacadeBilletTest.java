package application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.TreeMap;

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
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022, 06, 20));
    BilletDTO billetDTO2 = new BilletDTO(1, "Ouvert", "Bénin",
            "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022, 05, 18));
    BilletDTO billetDTO3 = new BilletDTO(1, "Fermé", "Bénin",
            "utilisateur1@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022, 05, 18));
    BilletDTO billetDTO4 = new BilletDTO(1, "Fermé", "Urgent",
            "utilisateur6@gmail.com", "Etat du projet ne s'update pas.",
            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.of(2022, 06, 20));
    ProjetDTO projetDTO1 =
            new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022, 05, 28),
                    LocalDate.of(2022, 05, 29));

    Categorie categorieAnomalie = new Categorie("Anomalie");
    Categorie categorieEchec = new Categorie("Echec");
    Categorie categorieRidicule = new Categorie("Ridicule");
    CompteUsagerTechDTO usagerDTO1 =
            new CompteUsagerTechDTO(1, "Roger", "mdp", "email");



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
        projetDTO1.ajouterCategorieBillet(categorieEchec);
        projetDTO1.ajouterCategorieBillet(categorieRidicule);
        //Attibuer une catégorie au billet
        billetDTO1.setCategorie(categorieAnomalie);
        billetDTO2.setCategorie(categorieEchec);
        billetDTO3.setCategorie(categorieAnomalie);
        billetDTO4.setCategorie(categorieRidicule);


    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
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




    @Test
    void testCreerBilletEnPassantUnBilletDTO() {


        int indice = facadeBillet.creerBillet(billetDTO1);
        assertTrue(indice > 0);

        BilletDTO billetTrouve = facadeBillet.consulterBilletParId(indice);

        RegistreHistorique registreHistoriqueTrouve = billetTrouve.getRegistreHistorique();

        int id = registreHistoriqueTrouve.getRegistreHistorique().lastKey();

        Historique historiqueTrouve = registreHistoriqueTrouve.chercherParNumero(id);
        System.out.println(historiqueTrouve.getIdHistorique());
        assertEquals(1, historiqueTrouve.getIdHistorique());

    }


    @Test
    void changerEtatBillet() {
        //Debut
        facadeBillet.creerBillet(billetDTO1);
        BilletDTO billetDTO = facadeBillet.consulterBilletParId(1);

        facadeBillet.changerEtatBillet(billetDTO, "Fermé", "Travail terminé. Fermeture du billet");
        assertEquals("Fermé", facadeBillet.consulterBilletParId(1).getEtat());

        assertEquals(2, facadeBillet.consulterBilletParId(1).getRegistreHistorique().getRegistreHistorique().size());

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
    void faireSortirLaListedeBilletsFiltreeParDateDebut() {
        facadeBillet.creerBillet(billetDTO1); //20 juin
        facadeBillet.creerBillet(billetDTO2); //18 mai
        facadeBillet.creerBillet(billetDTO3); //18 mai
        facadeBillet.creerBillet(billetDTO4); //20 juin

        TreeMap<Integer,BilletDTO> liste =facadeBillet.consulterListeBillet("date", LocalDate.of(2022, 05, 18));
        assertEquals(2,liste.size());
    }

    @Test
    void faireSortirLaListedeBilletsFiltreeParDemandeur() {
        facadeBillet.creerBillet(billetDTO1); //utilisateur1@gmail.com
        facadeBillet.creerBillet(billetDTO2); //utilisateur1@gmail.com
        facadeBillet.creerBillet(billetDTO3); //utilisateur1@gmail.com
        facadeBillet.creerBillet(billetDTO4); //utilisateur6@gmail.com
        TreeMap<Integer,BilletDTO> liste = facadeBillet.consulterListeBillet("demandeur", "utilisateur6@gmail.com");
        assertEquals(1,liste.size());
    }

    @Test
    void faireSortirLaListedeBilletsFiltreeParEtat() {
        facadeBillet.creerBillet(billetDTO1); //ouvert
        facadeBillet.creerBillet(billetDTO2); //ouvert
        facadeBillet.creerBillet(billetDTO3); //fermé
        facadeBillet.creerBillet(billetDTO4); //fermé
        TreeMap<Integer,BilletDTO> liste = facadeBillet.consulterListeBillet("etat", "Ouvert");
        assertEquals(2,liste.size());
    }

    @Test
    void faireSortirLaListedeBilletsFiltreeParTech() {
        facadeBillet.creerBillet(billetDTO1); //0
        facadeBillet.creerBillet(billetDTO2); //0
        facadeBillet.creerBillet(billetDTO3); //0
        facadeBillet.creerBillet(billetDTO4); //0
        TreeMap<Integer,BilletDTO> liste = facadeBillet.consulterListeBillet("tech", "0");
        assertEquals(4,liste.size());
    }

    @Test
    void faireSortirLaListedeBilletsFiltreeParProjet() {
        facadeBillet.creerBillet(billetDTO1); //1
        facadeBillet.creerBillet(billetDTO2); //1
        facadeBillet.creerBillet(billetDTO3); //1
        facadeBillet.creerBillet(billetDTO4); //1
        TreeMap<Integer,BilletDTO> liste = facadeBillet.consulterListeBillet("projet", "1");
        assertEquals(4, liste.size());

    }

    @Test
    void faireSortirLaListedeBilletsFiltreeParCategorie() {
        facadeBillet.creerBillet(billetDTO1); //anomalie
        facadeBillet.creerBillet(billetDTO2); //echec
        facadeBillet.creerBillet(billetDTO3); //anomalie
        facadeBillet.creerBillet(billetDTO4); //ridicule
        TreeMap<Integer,BilletDTO> liste = facadeBillet.consulterListeBillet("categorie", "Ridicule");
        assertEquals(1,liste.size());
    }

    @Test
    void faireSortirLaListedeBilletsFiltreeParGravite() {
        facadeBillet.creerBillet(billetDTO1); //urgent
        facadeBillet.creerBillet(billetDTO2); //benin
        facadeBillet.creerBillet(billetDTO3); //benin
        facadeBillet.creerBillet(billetDTO4); //urgent
        TreeMap<Integer,BilletDTO> liste = facadeBillet.consulterListeBillet("gravite", "Urgent");
        assertEquals(2,liste.size());
    }

}


