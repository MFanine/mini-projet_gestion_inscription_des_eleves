package mini_projet;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    
 private String nom;
 private String prenom;
 private String adresse;
 private String tel;
 private String sex;
 private String email;
 private String villes;
 private String diplomes;
 private Double note;

    public Utilisateur(String nom) {
        this.nom = nom;
    }

    public Utilisateur() {
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String gettel() {
        return tel;
    }

    public void settel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVilles() {
        return villes;
    }

    public void setVilles(String villes) {
        this.villes = villes;
    }

    public String getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(String diplomes) {
        this.diplomes = diplomes;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", villes='" + villes + '\'' +
                ", diplome='" + diplomes + '\'' +
                ", note=" + note +
                '}';
    }

    public Utilisateur(String nom, String prenom, String adresse, String tel, String sex, String email, String villes, String diplomes, double note) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
        this.villes = villes;
        this.diplomes = diplomes;
        this.note = note;
    }
}
