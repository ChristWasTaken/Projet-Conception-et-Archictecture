package accesPersistence;

import application.CompteUsagerTechDTO;

import java.util.TreeMap;

public class UsagerTechDAO extends CommonDAO {
    private static CompteUsagerTechDTO usager1 = new CompteUsagerTechDTO(1,"Roger","mdp","email");
    private static CompteUsagerTechDTO usager2 = new CompteUsagerTechDTO(2,"Bob","mdp","courriel");
    private static CompteUsagerTechDTO usager3 = new CompteUsagerTechDTO(3,"Steve","pwd","hotmail");
    private TreeMap<Integer, CompteUsagerTechDTO> collectionsUsagers;

    public UsagerTechDAO() {
        this.collectionsUsagers = new TreeMap<>();
        this.collectionsUsagers.put(usager1.getIdUsager(), usager1);
        this.collectionsUsagers.put(usager2.getIdUsager(), usager2);
        this.collectionsUsagers.put(usager3.getIdUsager(), usager3);
    }

    public void persisterCompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        this.collectionsUsagers.put(compteUsagerTechDTO.getIdUsager(), compteUsagerTechDTO);
    }

    public CompteUsagerTechDTO chercherCompteUsagerTechDTOParId(int id){
        CompteUsagerTechDTO compteUsagerTechDTO = this.collectionsUsagers.get(id);
        return compteUsagerTechDTO;
    }
}
