package org.pmovieland;

public class Film {
    private String titre;
    private String realisateur;
    private String pays;
    private int annee;
    private int x;
    private int y;
    private String xy;
    private boolean vu;

    public Film(){
        this.titre = "";
        this.realisateur = "";
        this.pays = "";
        this.x = 0;
        this.y = 0;
        this.xy = "";
        this.annee = 0;
        this.vu = false;
    }

    public Film(String titre, String realisateur, String pays, int annee, int x, int y, String xy, Boolean vu){
        this.titre = titre;
        this.realisateur = realisateur;
        this.pays = pays;
        this.annee = annee;
        this.x = x;
        this.y = y;
        this.xy = xy;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVu() {
        return vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }
}
