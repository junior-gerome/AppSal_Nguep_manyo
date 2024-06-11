/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appsal_nguep_manyo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cadre extends Salary {
    public int prime;
    public int avantage;
    public int heure_supplementaire;

    public Cadre(String Matricule, String nom, String prenom, int salaire_base, int taux_horaire, String profession, Date Dat_embauche, int prime, int avantage, int heure_supplementaire) {
        super(nom, prenom, salaire_base, taux_horaire, profession, Dat_embauche);
        this.prime = prime;
        this.avantage = avantage;
        this.heure_supplementaire = heure_supplementaire;
        //this.matricule=getMatricule(Dat_embauche);
    }

    @Override
    public double get_mtan_promotion() {
        double promotion;
        Calendar cal = Calendar.getInstance();
        cal.setTime(Dat_embauche);
        int nbannee=8;
        int year = cal.get(Calendar.YEAR);
        if (year >= nbannee) {
            promotion = salaire_base + 0.15 * salaire_base;
        } else {
            promotion = salaire_base; 
        }
        return promotion;
    }

    @Override
    public double get_retenue() {
        double IRPP = 0.052 * salaire_base;
        double CAC = 0.1 * IRPP;
        double CNPS = 0.0175 * salaire_base;
        double chargesPatronales = 0.15 * salaire_base;
        double retenue = IRPP + CAC + CNPS + chargesPatronales;
        return retenue;
    }

    @Override
    public double get_mtant_Heure_suplementaire() {
        double heureSUP = taux_horaire * heure_supplementaire;   
        return heureSUP;    
    }
    
@Override
public String toString() {
    return "Cadre{" +
        "matricule='" + matricule + '\'' +
        "nom='" + nom + '\'' +
        ", prenom='" + prenom + '\'' +
        ", salaire=" + salaire_base +
        ", profession='" + profession + '\'' +
        '}';
}


    @Override
    public double getNetAPayer() {
        double NetAPayer = salaire_base - get_retenue();
        return NetAPayer;     
    }

    
}
