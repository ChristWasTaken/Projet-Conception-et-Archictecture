package presentation;

import application.FacadeServices;

public class PackPres {
    /**
     Simule une interaction avec l'usager pour savoir quel billet changer,
     et quelle valeur on veut attribuer à son champs "Etat". Si le billet existe,
     retourne les valeurs qu'on a passé mais dans un tableau de String (parce qu'on
     doit retourner deux valeurs).
     */
    public String[] changerEtatBillet(FacadeServices facadeServices, int idBilletDTO, String nouvelEtat){
        String answer[] = new String[2];
        if (facadeServices.billetExists(idBilletDTO)) {
            answer[0] = String.valueOf(idBilletDTO);
            answer[1] = nouvelEtat;
            return answer;
        }
        else {
            System.out.println("L'opération #changerEtatBillet# n'a pu être complétée parce" +
                    " que le billet n'existe pas");
            return answer;
        }
    }
}
