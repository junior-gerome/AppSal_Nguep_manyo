/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appsal_nguep_manyo;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author GLOBAL STORE
 */
public abstract class Salary {
   protected  String matricule;
   protected String nom;
   protected String prenom;
   protected int salaire_base;
   protected int taux_horaire;
   protected String profession;
   protected Date Dat_embauche;
   protected static final  int CNPS=1206;
  protected static int cle=-1000;
    public Salary(String nom, String prenom, int salaire_base, int taux_horaire, String profession, Date Dat_embauche) {
        this.cle+=1001;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire_base = salaire_base;
        this.taux_horaire = taux_horaire;
        this.profession = profession;
        this.Dat_embauche = Dat_embauche;
        this.matricule=getMatricule(Dat_embauche, cle);
    }

    public abstract String toString();
    public abstract double get_mtan_promotion();
    
    public abstract  double get_retenue();
    
    public abstract double get_mtant_Heure_suplementaire();

    public void setSalaire_base(int salaire_base) {
        this.salaire_base = salaire_base;
    }
    
    public double getSalaireBase(){
        return salaire_base;
    }

    public String getMatricule(Date Dat_embauche, int cle) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    String annee = sdf.format(this.Dat_embauche);
        matricule = annee + CNPS + String.format("%04d", cle%10000);
    return matricule;}
   
   
    public abstract double getNetAPayer();

  



    }

    


  
 