package application;

import org.junit.jupiter.api.Test;
import persistence.persistenceMock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeBilletTest {

    FacadeBillet facadeBillet = new FacadeBillet();
    RegistreBillet registreBillet = RegistreBillet.getInstance();

    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
    FacadeProjet facadeProjet = new FacadeProjet();
    Proxy proxy = new Proxy();


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ProjetDTO projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
        CompteUsagerTechDTO usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");
        facadeCompteUsager.creerCompteUsagerTech(usagerDTO);
        facadeProjet.creerProjet(projet);
        facadeProjet.assignerUsagerTech(usagerDTO,projet);

        // Créer une catégorie de billet
        String categorieBillet = "Anomalie";
        //Ajout de la catégorie au ProjetDTO avant de l'envoyer à la facade
        projet.ajouterCategorieBillet(new Categorie(categorieBillet));

        BilletDTO billetDto = new BilletDTO(1,"Ouvert","Urgent","demandeur@gmail.com",
                "Notes 1","Description1",LocalDate.now());

        facadeBillet.creerBillet(billetDto);
        billetDto.setGravite("Urgent");
        facadeBillet.creerBillet(billetDto);
        billetDto.setGravite("Normal");
        facadeBillet.creerBillet(billetDto);
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

    //------------------------------------test pour créer billet ne fonctionne pas------------------------------------
    @Test
    void testCreerBilletEnPassantUnBilletDTO() {
        BilletDTO billetDTO = new BilletDTO(4,3,"Ouvert","Urgent",
                "utilisateur1@gmail.com","Etat du projet ne s'update pas.",
                "J'ai redémarré et ça ne fonctionne pas.", LocalDate.now());

        Historique nouvelHistorique = new Historique(LocalDate.now(),"Création de l'historique");
        billetDTO.getRegistreHistorique().ajouterHistoriqueAuRegistre(nouvelHistorique);

        assertEquals(nouvelHistorique.getIdHistorique(), 4);
        assertEquals(nouvelHistorique.getIdBilletAssocie(), 4);

//
//
//        Billet nouveauBillet = new Billet(billetDTO);
//        assertEquals(nouveauBillet.getIdBillet(), billetDTO.getIdBillet());
//        assertEquals(nouveauBillet.getEtat(), billetDTO.getEtat());
//
//        registreBillet.ajouterBilletAuRegistre(nouveauBillet);
//        assertEquals(registreBillet.chercherBilletParId(nouveauBillet.getIdBillet()), nouveauBillet);
//
//        proxy.persisterBillet(billetDTO);
//        BilletDTO billetTemp = proxy.chercherBilletDTOParId(4);
//        assertEquals(billetDTO, billetTemp);
    }

    @Test
    void changerEtatBillet() {
        //Debut
        BilletDTO billetDTO = facadeBillet.consulterBilletParId(1);

        facadeBillet.changerEtatBillet(billetDTO, "Fermé","Travail terminé. Fermeture du billet");
        assertEquals("Fermé",facadeBillet.consulterBilletParId(1).getEtat());
        System.out.println(facadeBillet.consulterBilletParId(1));
        assertEquals(2,facadeBillet.consulterBilletParId(1).getRegistreHistorique().getRegistreHistorique().size());

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

    @Test
    void assignerBillet() {
        persistenceMock.projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
    }

    @Test
    void consulterListeBillet() {
        System.out.println(facadeBillet.consulterListeBillet("gravite","Urgent"));
    }


}