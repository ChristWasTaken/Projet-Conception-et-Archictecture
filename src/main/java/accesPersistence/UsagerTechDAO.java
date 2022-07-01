package accesPersistence;

import application.CompteUsagerTechDTO;

import java.util.TreeMap;

class UsagerTechDAO {
    private final static CompteUsagerTechDTO usager1 = new CompteUsagerTechDTO(1,"Roger","mdp","email");
    private final static CompteUsagerTechDTO usager2 = new CompteUsagerTechDTO(2,"Bob","mdp","courriel");
    private final static CompteUsagerTechDTO usager3 = new CompteUsagerTechDTO(3,"Steve","pwd","hotmail");
    private final TreeMap<Integer, CompteUsagerTechDTO> collectionsUsagers;

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
        if(compteUsagerTechDTO == null){
            System.out.println("Aucun usager avec cet id");
        }
        return compteUsagerTechDTO;
    }
}
