public class Film {
    private String titre;
    private String realisateur;
    private String pays;
    private int annee;
    private boolean vu;

    public Film(){
        this.titre = "";
        this.realisateur = "";
        this.pays = "";
        this.annee = 0;
        this.vu = false;
    }

    public Film(String titre, String realisateur, String pays, int annee, Boolean vu){
        this.titre = titre;
        this.realisateur = realisateur;
        this.pays = pays;
        this.annee = annee;
        this.vu = vu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean isVu() {
        return vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }
}
