package accesPersistence;

import application.BilletDTO;

import java.util.TreeMap;

class BilletDAO {


    private TreeMap<Integer, BilletDTO> collectionBillets;

    public BilletDAO() {
        this.collectionBillets = new TreeMap<>();
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
