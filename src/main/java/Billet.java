import java.time.LocalDate;

public class Billet {
    int idBillet;
    int idProjet;
    int idUsagerTechAssigne;

    String etat;
    String gravite;
    String categorieDemaande;
    String notes;
    String description;

    LocalDate dateAssigne;
    LocalDate dateDebutBillet;

    RegistreHistorique registreHistorique;



}
