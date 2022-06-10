package accesPersistence;

import application.ProjetDTO;

import java.util.TreeMap;

 class ProjetDAO extends CommonDAO {

    private TreeMap<Integer, ProjetDTO> collectionProjets;

     public ProjetDAO() {
         this.collectionProjets = new TreeMap<>();
     }

     public void persisterNouveauProjet(ProjetDTO projetDTO){
         this.collectionProjets.put(projetDTO.getIdProjet(), projetDTO);
     }

     public ProjetDTO chercherProjetDTOParId(int id){
         ProjetDTO projetDTO = this.collectionProjets.get(id);
         return projetDTO;
     }
 }

