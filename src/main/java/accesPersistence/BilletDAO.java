package accesPersistence;

import application.BilletDTO;

import java.util.TreeMap;

class BilletDAO {

//    private static BilletDTO billetDTO1 = new BilletDTO(1,2,"Ouvert","Urgent",
//            "utilisateur1@gmail.com","Etat du projet ne s'update pas.",
//            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.now());
//
//    private static BilletDTO billetDTO2 = new BilletDTO(2,3,"Ouvert","Normal",
//            "utilisateur4@gmail.com","Impossible d'ajotuer des usagers.",
//            "J'ai redémarré et ça ne fonctionne pas.", LocalDate.now());


    private TreeMap<Integer, BilletDTO> collectionBillets;

    public BilletDAO() {
        this.collectionBillets = new TreeMap<>();
//        this.collectionBillets.put(billetDTO1.getIdProjet(), billetDTO1);
//        this.collectionBillets.put(billetDTO2.getIdProjet(), billetDTO2);
    }

    public void persisterBillet(BilletDTO billetDTO){
        this.collectionBillets.put(billetDTO.getIdBillet(), billetDTO);
    }

    public BilletDTO chercherBilletDTOParId(int id) {
        BilletDTO billetDTO = this.collectionBillets.get(id);
        if(billetDTO == null){
            System.out.println("Aucun billet avec cet id");
        }
        return billetDTO;
    }

    public BilletDTO modifierBillet(BilletDTO billetDTO) {
        this.collectionBillets.put(billetDTO.getIdBillet(), billetDTO);
        return billetDTO;
    }
}
