/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import utilitaire.Conteneur;
/**
 *
 * @author Valentin
 */
public class Application1 {
    public static void main(String[] args){
        Compte compteBanc = new CompteBancaire(1000f,"1",200f,3f);
        Compte compteEpar = new CompteEpargne(2000f,"1",3000f,30f);
        
        // compteEpar.crediter(1100f);
        // compteBanc.debiter(1300f);
        
    /*    System.out.println(compteBanc.toString()+"\n");
        System.out.println(compteEpar.toString()); */
        
        
        
    }
}
