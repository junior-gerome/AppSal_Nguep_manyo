/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appsal_nguep_manyo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author GLOBAL STORE
 */
public class Ouvrier extends Salary {
    public int Nbre_heure;
    public int heure_supplementaire;
    public int retenue;

    public Ouvrier(String Matricule, int Nbre_heure, int heure_supplementaire, int retenue, String nom, String prenom, int salaire_base, int taux_horaire, String profession, Date Dat_embauche) {
        super(nom, prenom, salaire_base, taux_horaire, profession, Dat_embauche);
        this.Nbre_heure = Nbre_heure;
        this.heure_supplementaire = heure_supplementaire;
        this.retenue = retenue;
    }

    @Override
    public double get_mtan_promotion() {
        return 0;
    }

    @Override
    public double get_retenue() {
        return 0.0175 * salaire_base;
    }

    @Override
    public double get_mtant_Heure_suplementaire() {
        if (Nbre_heure <= 39) {
            return 0;
        } else if (Nbre_heure <= 49) {
            return (Nbre_heure - 39) * taux_horaire * 1.5;
        } else {
            return 10 * taux_horaire * 1.5 + (Nbre_heure - 49) * taux_horaire * 1.85;
        }
    }

    @Override
    public double getNetAPayer() {
        return salaire_base - get_retenue();
    }



@Override
public String toString() {
    return "Ouvrier{" +
        "matricule='" + matricule + '\'' +
        "nom='" + nom + '\'' +
        ", prenom='" + prenom + '\'' +
        ", salaire=" + salaire_base +
        ", profession='" + profession + '\'' +
        
        '}';
}

}
    

   
  

