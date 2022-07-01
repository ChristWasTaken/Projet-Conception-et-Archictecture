package accesPersistence;

import application.BilletDTO;

import java.time.LocalDate;
import java.util.TreeMap;

class BilletDAO {

    private final TreeMap<Integer, BilletDTO> collectionBillets;

    public BilletDAO() {
        this.collectionBillets = new TreeMap<>();
        BilletDTO billetDTO1 = new BilletDTO(1, "Ouvert", "Urgent", "courrielA@gmail.com", "Notes du billet no1", "Description du billet no1", LocalDate.of(2022, 6, 19));
        this.collectionBillets.put(billetDTO1.getIdProjet(), billetDTO1);
        BilletDTO billetDTO2 = new BilletDTO(3, "En suspend", "Important", "courrielB@gmail.com", "Notes du billet no2", "Description du billet no2", LocalDate.of(2022, 6, 20));
        this.collectionBillets.put(billetDTO2.getIdProjet(), billetDTO2);
    }

    public void persisterBillet(BilletDTO billetDTO){
        this.collectionBillets.put(billetDTO.getIdBillet(), billetDTO);

    }

    public BilletDTO chercherBilletDTOParId(int id) {
        BilletDTO billetDTO = this.collectionBillets.get(id);
        if(billetDTO == null){
            System.out.println("Aucun billet avec cet id");
            return null;
        }
        return billetDTO;
    }

    public boolean modifierBillet(BilletDTO billetDTO) {
        try {
            this.collectionBillets.put(billetDTO.getIdBillet(), billetDTO);
            return true;
        } catch (Exception e) {
            System.out.println("Modification interromptue - persistence.Rollback()");
            return false;
        }
    }
}
