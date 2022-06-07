package persistence;

import application.*;

import java.time.LocalDate;
import java.util.TreeMap;

public class persistenceMock {

    RegistreUsagerTech registreUsagerTech = RegistreUsagerTech.getInstance();
    RegistreProjet registreProjet = RegistreProjet.getInstance();

    FacadeBillet facadeBillet = new FacadeBillet();
    FacadeCompteUsager facadeCompteUsager = new FacadeCompteUsager();
    FacadeProjet facadeProjet = new FacadeProjet();

    public static ProjetDTO projet = new ProjetDTO(1, "ProjetTopSecret", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
    public static ProjetDTO projet2 = new ProjetDTO(2, "ProjetTopSecret2", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));
    public static ProjetDTO projet3 = new ProjetDTO(3, "ProjetTopSecret3", LocalDate.of(2022,05,28), LocalDate.of(2022,05,29));

    public static CompteUsagerTechDTO usagerDTO = new CompteUsagerTechDTO(1,"Roger","mdp","email");



    public TreeMap<Integer, ProjetDTO> chargerPersitanceProjet(ProjetDTO projetDTO){

        facadeProjet.creerProjet(projet);
        facadeProjet.creerProjet(projet2);
        facadeProjet.creerProjet(projet3);

        return registreProjet.recupererRegistreProjetAsDTO();
    }

}
