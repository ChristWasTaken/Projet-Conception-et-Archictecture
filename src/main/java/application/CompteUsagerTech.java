package application;

class CompteUsagerTech {
    /**
     * Attributs de la classe
     */
    private int idUsager;
    String nomUsager;
    String motPasse;
    String courriel;

    /**
     * Constructeurs
     */
    //par défaut
    public CompteUsagerTech() { }


    public CompteUsagerTech(CompteUsagerTechDTO compteUsagerTechDTO){
        this.setIdUsager(compteUsagerTechDTO.getIdUsager());
        this.setNomUsager(compteUsagerTechDTO.getNomUsager());
        this.setMotPasse(compteUsagerTechDTO.getMotPasse());
        this.setCourriel(compteUsagerTechDTO.getCourriel());
    }

    CompteUsagerTechDTO asCompteUsagerTechDTO() {
        CompteUsagerTechDTO compteUsagerTechDTO = new CompteUsagerTechDTO();
        compteUsagerTechDTO.setIdUsager(this.getIdUsager());
        compteUsagerTechDTO.setNomUsager(this.getNomUsager());
        compteUsagerTechDTO.setMotPasse(this.getMotPasse());
        compteUsagerTechDTO.setCourriel(this.getCourriel());
        return compteUsagerTechDTO;
    }

    /**
     * Getters and setters
     */
    public String getNomUsager() {
        return nomUsager;
    }

    public void setNomUsager(String nomUsager) {
        this.nomUsager = nomUsager;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public int getIdUsager() {
        return idUsager;
    }

    public void setIdUsager(int idUsager) {
        this.idUsager = idUsager;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "CompteUsagerTech{" +
                "nomUsager='" + nomUsager + '\'' +
                ", motPasse='" + motPasse + '\'' +
                ", courriel='" + courriel + '\'' +
                '}';
    }
}
