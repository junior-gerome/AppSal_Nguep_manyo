/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appsal_nguep_manyo;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import appsal_nguep_manyo.Salary;
import appsal_nguep_manyo.Cadre;
import appsal_nguep_manyo.Ouvrier;
import java.sql.Date;


public class AppSal_Nguep_Manyo {
    private static int CNPS;
    
    public static void main(String[] args) {
   
    // Création d'une liste de salaires
    List<Salary> salaries = new ArrayList<>();

    // Création des dates d'embauche
    Date date1 = new Date(System.currentTimeMillis());
    Date date2 = new Date(System.currentTimeMillis());
    Date date3 = new Date(System.currentTimeMillis());
    Date date4 = new Date(System.currentTimeMillis());
    Date date5 = new Date(System.currentTimeMillis());

    
    Cadre cadre1 = new Cadre("","youdom", "philippe", 1000000, 10, "Informaticien", date1, 100, 10, 5); 
    salaries.add(cadre1);

    Cadre cadre2 = new Cadre("","Manyo", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre2);

    Cadre cadre3 = new Cadre("Matricule3","nguep manyo", "junior grerome", 3000000, 30, "Informaticien", date3, 300, 30, 15);
    salaries.add(cadre3);
    Cadre cadre4 = new Cadre("","Manyo", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre4);
    
    Cadre cadre5 = new Cadre("","Manyo1", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre5);
    Cadre cadre6 = new Cadre("","Manyo2", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre6);
    Cadre cadre7 = new Cadre("","Manyo3", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre7);
    Cadre cadre8 = new Cadre("","Manyo4", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre8);
    Cadre cadre9 = new Cadre("","Manyo5", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre9);
    Cadre cadre10 = new Cadre("","Manyo6", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre10);
    Cadre cadre11 = new Cadre("","Manyo7", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre11);
    Cadre cadre12 = new Cadre("","Manyo8", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre12);
    Cadre cadre13 = new Cadre("","Manyo9", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre13);
    Cadre cadre14 = new Cadre("","Manyo10", "gerome", 2000000, 20, "Informaticien", date2, 200, 20, 10);
    salaries.add(cadre14);
    Ouvrier ouvrier1 = new Ouvrier("",40, 5,  4000, "toto", "eric", 150000, 40, "Ouvrier", date4);
    salaries.add(ouvrier1);

    Ouvrier ouvrier2 = new Ouvrier("",50, 10,  5000, "tato", "henry", 150000, 50, "Ouvrier", date5);
   
    salaries.add(ouvrier2);

    
        // Calcul de la charge salariale
        double chargesalarialtotal = calculateChargeSalarialeTotale(salaries);
        System.out.println("Charge salariale totale : " + chargesalarialtotal);

        //  la liste des informaticiens
        List<Salary> informaticiens = getInformaticiens(salaries);
        System.out.println("Liste des informaticiens : " + informaticiens);

        // la liste des employés promotionnaires
        List<Salary> employespromo = getEmployesPromo(salaries);
        System.out.println("Liste des employés promotionnaires : " + employespromo);
       

        //  la liste des ouvriers ayant effectué des heures supplémentaires avec les détails de leur salaire
        List<Salary> ouvrierheureSup = getOuvrierHeureSUP(salaries);
        System.out.println("Liste des ouvriers ayant effectué des heures supplémentaires : " + ouvrierheureSup);
    }

    // Calcul de la charge salariale totale
    public static double calculateChargeSalarialeTotale(List<Salary> salaries) {
        double total = 0;
        for (Salary salary : salaries) {
            total += salary.getNetAPayer();
        }
        return total;
    }

    // la liste des informaticiens
    public static List<Salary> getInformaticiens(List<Salary> salaries) {
        List<Salary> informaticien = new ArrayList<>();
        for (Salary salary : salaries) {
            if ("Informaticien".equals(salary.profession)) {
                informaticien.add(salary);
            }
        }
        return informaticien;
    }

    // la liste des employés promotionnaires
    public static List<Salary> getEmployesPromo(List<Salary> salaries) {
        List<Salary> promotionalEmployees = new ArrayList<>();
        for (Salary salary : salaries) {
            if (salary instanceof Cadre && salary.get_mtan_promotion() > 0) {
                promotionalEmployees.add(salary);
            }
        }
        return promotionalEmployees;
    }

   
    
    
    

    // la liste des ouvriers ayant effectué des heures supplémentaires
    public static List<Salary> getOuvrierHeureSUP(List<Salary> salaries) {
        List<Salary> ouvrierheureSup = new ArrayList<>();
        for (Salary salary : salaries) {
            if (salary instanceof Ouvrier && ((Ouvrier) salary).heure_supplementaire > 0) {
               ouvrierheureSup.add(salary);
            }
        }
        return ouvrierheureSup;
    }
}
 